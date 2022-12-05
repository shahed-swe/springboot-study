package com.springbootwork.demo.controller;


import com.springbootwork.demo.Impl.DepartmentServiceImpl;
import com.springbootwork.demo.entity.Department;
import com.springbootwork.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departmentssave")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getDepartment();
    }


    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully";
    }

}
