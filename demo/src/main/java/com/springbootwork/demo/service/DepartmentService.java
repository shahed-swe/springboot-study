package com.springbootwork.demo.service;

import com.springbootwork.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartment();

    public Department getDepartmentById(Long dpeartmentId);

    public void deleteDepartmentById(Long departmentId);
}
