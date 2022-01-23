package com.hqc.sms.dao;

import com.hqc.sms.pojo.Department;
import com.hqc.sms.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    DepartmentDao departmentDao;

    private static Map<Integer, Employee> employeeMap = null;
    private static Integer initId = 6;

    static {
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(1001,new Employee(1001,"AA","A123@hqc.com",0,new Date(System.currentTimeMillis()),new Department(101, "生产部")));
        employeeMap.put(1002,new Employee(1002,"BB","B123@hqc.com",1,new Date(System.currentTimeMillis()),new Department(102, "研发部")));
        employeeMap.put(1003,new Employee(1003,"CC","C123@hqc.com",0,new Date(System.currentTimeMillis()),new Department(103, "人力资源部")));
        employeeMap.put(1004,new Employee(1004,"DD","D123@hqc.com",1,new Date(System.currentTimeMillis()),new Department(104, "销售部")));
        employeeMap.put(1005,new Employee(1005,"EE","E123@hqc.com",0,new Date(System.currentTimeMillis()),new Department(105, "采购部")));
    }

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employeeMap.put(employee.getId(),employee);
    }

    public Collection<Employee> getEmployees(){
        return employeeMap.values();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
