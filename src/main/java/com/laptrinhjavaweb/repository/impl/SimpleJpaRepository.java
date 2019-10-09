package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.JpaRepository;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleJpaRepository<T>  implements JpaRepository<T> {
    private Class zClass;
    public SimpleJpaRepository(){
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public List<T> findAll() {

        String tableName = "";
        if (zClass.isAnnotationPresent(Table.class)&&zClass.isAnnotationPresent(Entity.class)){
            Table tableClass = (Table) zClass.getAnnotation(Table.class);
            tableName = tableClass.name();
        }
        StringBuilder sql = new StringBuilder("select * from "+ tableName+"AS A WHERE 1=1");

        System.out.println(sql.toString());
        ResultSet resultSet =null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

        try {
            connection = EntityManagerFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            resultSet = ps.executeQuery();
            return resultSetMapper.mapRow(resultSet,zClass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<T> findAll(Pageable pageable,Object... objects) {
        String tableName = "";
        if (zClass.isAnnotationPresent(Table.class)&&zClass.isAnnotationPresent(Entity.class)){
            Table tableClass = (Table) zClass.getAnnotation(Table.class);
            tableName = tableClass.name();
        }
        StringBuilder sql = new StringBuilder("select * from "+ tableName+" AS A WHERE 1=1");
        if (objects.length>0 && objects!=null )
        {
            sql.append(objects[0]);
        }
        if (pageable.getLimit()!=null && pageable.getOffSet()!=null) {
            sql.append(" LIMIT " + pageable.getOffSet() + " , " + pageable.getLimit());
        }
        System.out.println(sql.toString());
        ResultSet resultSet =null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

        try {
            connection = EntityManagerFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            resultSet = ps.executeQuery();
            return resultSetMapper.mapRow(resultSet,zClass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<T> findAll(String sql1, Pageable pageable, Object... objects) {

        StringBuilder sql = new StringBuilder(sql1);
        if (pageable.getLimit()!=null && pageable.getOffSet()!=null) {
            sql.append(" LIMIT " + pageable.getOffSet() + " , " + pageable.getLimit());
        }
        System.out.println(sql.toString());
        ResultSet resultSet =null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

        try {
            connection = EntityManagerFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            resultSet = ps.executeQuery();
            return resultSetMapper.mapRow(resultSet,zClass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    protected StringBuilder createSqlFindAll(StringBuilder where, Map<String,Object> propeties){
        if (propeties!=null && propeties.size()>0){
            String[] keys = new String[propeties.size()];
            Object[] values =new Object[propeties.size()];
            int i = 0;
            for (Map.Entry<String,Object> entry : propeties.entrySet()){
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
                i++;
            }
            for (int i1 = 0; i1 < keys.length;i1++){
                if (values[i1] instanceof String && StringUtils.isNotBlank(values[i1].toString())){
                    where.append(" AND A."+keys[i1]+" LIKE  '%"+values[i1]+"%'");
                }
                if (values[i1] instanceof Integer && values[i1]!=null){
                    where.append(" AND A."+keys[i1]+" = "+values[i1]);
                }
                if (values[i1] instanceof Long && values[i1]!=null){
                    where.append(" AND A."+keys[i1]+" = "+values[i1]);
                }
            }
        }
        return where;
    }
}
