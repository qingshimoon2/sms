package com.hqc.sms.dao;

import com.hqc.sms.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(101, new Department(101, "生产部"));
        departmentMap.put(102, new Department(102, "研发部"));
        departmentMap.put(103, new Department(103, "人力资源部"));
        departmentMap.put(104, new Department(104, "销售部"));
        departmentMap.put(105, new Department(105, "采购部"));
    }

    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
