package com.hqc.sms.controller;

import com.hqc.sms.dao.DepartmentDao;
import com.hqc.sms.dao.EmployeeDao;
import com.hqc.sms.pojo.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/list")
    public String employeeList(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    @GetMapping("/add")
    public String addPage(Model model){
        model.addAttribute("departments",departmentDao.getDepartments());
        return "emp/add";
    }

    @PostMapping("/add")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/update/{id}")
    public String editPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("departments",departmentDao.getDepartments());
        return "emp/edit";
    }

    @PostMapping("/update")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee/list";
    }
}
