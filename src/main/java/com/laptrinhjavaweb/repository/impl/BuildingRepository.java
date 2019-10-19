package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BuildingRepository extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository  {

    public List<BuildingEntity> findAll(Map<String,Object> params, Pageable pageable,BuildingSearchBuilder fieldSearch){
        String sqlSpecial = buildSqlSpecial(fieldSearch);
        System.out.println(sqlSpecial);
        StringBuilder sqlSearch = new StringBuilder(" Select * from building as A");
        if ( StringUtils.isNotBlank(fieldSearch.getStaffId())){
            sqlSearch.append(" INNER JOIN assignmentstaff AS am ON A.id = am.staffid");
        }
        sqlSearch.append(" WHERE 1=1");
        sqlSearch=this.createSqlFindAll(sqlSearch,params);
        sqlSearch.append(sqlSpecial);
        //System.out.println("sql Special:"+sqlSpecial);
        System.out.println("Sql search:"+sqlSearch.toString());
        return this.findAll(sqlSearch.toString(),pageable);
    }


    @Override
    public List<BuildingEntity> findAll(Map<String,Object> params, Pageable pageable) {
        StringBuilder sql = new StringBuilder(" select * from building as A");
        return this.findAll(sql.toString(),pageable);
    }

    @Override
    public Long save(BuildingEntity buildingEntity) {
        return this.insert(buildingEntity);
    }



    private String buildSqlSpecial(BuildingSearchBuilder fieldSearch) {
        StringBuilder sql = new StringBuilder("");
        //use java 7
        if (StringUtils.isNotBlank(fieldSearch.getCostRentForm())){
            sql.append(" AND A.costrent >= "+fieldSearch.getCostRentForm()+"");
        }
        if (StringUtils.isNotBlank(fieldSearch.getCostRentTo())){
            sql.append(" AND A.costrent <= "+fieldSearch.getCostRentTo()+"");
        }
        if (fieldSearch.getBuildingTypes().length>0){
            sql.append(" AND (");
            //java 7
//            int i=0;
//            for (String item : fieldSearch.getBuildingTypes()){
//                if (i==0){
//                    sql.append("A.type LIKE '%"+item+"%'");
//                }else {
//                    sql.append(" OR A.type LIKE '%"+item+"%'");
//                }
//                i++;
//            }
            sql.append("A.type LIKE '%"+fieldSearch.getBuildingTypes()[0]+"%'");
            Arrays.stream(fieldSearch.getBuildingTypes())
                    .filter(item -> !item.equals(fieldSearch.getBuildingTypes()[0]))
                    .forEach(item -> sql.append(" OR A.type LIKE '%"+item+"%'"));

            sql.append(")");
        }
        if (StringUtils.isNotBlank(fieldSearch.getRentAreaFrom()) || StringUtils.isNotBlank(fieldSearch.getCostRentTo()) )
        {
            sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ( ra.buildingid = A.id ");
            if (fieldSearch.getRentAreaFrom()!= null){
                sql.append(" AND ra.value >= "+fieldSearch.getRentAreaFrom()+"");
            }
            if (fieldSearch.getRentAreaTo()!= null){
                sql.append(" AND ra.value <= "+fieldSearch.getRentAreaTo()+"");
            }
            sql.append("))");
            if ( StringUtils.isNotBlank(fieldSearch.getStaffId())){
                sql.append(" AND am.staffid='"+fieldSearch.getStaffId()+"'");
            }
        }
        return sql.toString();
    }
}
