package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.ArrayList;
import java.util.List;

public class ResultSetMapper<T> {
    public ResultSetMapper(){

    }
    public List<T> mapRow(ResultSet resultSet, Class<T> zClass, Object... objects){
        List<T> result = new ArrayList<>();
        try {
            if (zClass.isAnnotationPresent(Table.class)&&zClass.isAnnotationPresent(Entity.class)){
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                Field[] fields = zClass.getDeclaredFields();
                while (resultSet.next()){
                    T object = zClass.newInstance();
                    for (int i =0 ;i<resultSetMetaData.getColumnCount();i++){
                        ColumnModel columnModel = new ColumnModel();
                        String columnName = resultSetMetaData.getColumnName(i+1);
                        Object columnValue = resultSet.getObject(i+1);
                        columnModel.setColumnName(columnName);
                        columnModel.setColumnValue(columnValue);
                        convertResultSetToEntity(fields,columnModel,object);
                        Class<?> parentClass = zClass.getSuperclass();
                        while (parentClass!=null){
                            Field[] fieldsParent = parentClass.getDeclaredFields();
                            convertResultSetToEntity(fieldsParent,columnModel,object);
                            parentClass = parentClass.getSuperclass();

                        }
                    }
                    result.add(object);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    private void convertResultSetToEntity(Field[] fields,ColumnModel columnModel,Object... objects){
        T object = (T) objects[0];
        for (Field field : fields){
            if(field.isAnnotationPresent(Column.class)){
                Column column = field.getAnnotation(Column.class);
                if (column.name().equals(columnModel.getColumnName()) && columnModel.getColumnName()!=null){
                    //convert data
                    try {
                        BeanUtils.setProperty(object,field.getName(),columnModel.columnValue);
                    } catch (IllegalAccessException|InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    //stop when meet true target
                    break;
                }
            }
        }
    }
    class ColumnModel{
        private String columnName;
        private Object columnValue;

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public Object getColumnValue() {
            return columnValue;
        }

        public void setColumnValue(Object columnValue) {
            this.columnValue = columnValue;
        }
    }
}
