package com.example.securitymaster.controller;

import com.example.securitymaster.dao.EmployeeDao;
import com.example.securitymaster.ds.Employee;
import com.example.securitymaster.security.annotation.employees.EmployeesCreate;
import com.example.securitymaster.security.annotation.employees.EmployeesPagView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @EmployeesPagView
    @GetMapping("/employees")
    public ModelAndView findAllEmployees(){
        return new ModelAndView("employees",
                "employees",employeeDao.findAll());
    }
    @EmployeesCreate
    public String employeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employee-form";
    }
}
