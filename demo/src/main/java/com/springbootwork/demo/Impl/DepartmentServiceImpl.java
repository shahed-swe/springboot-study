package com.springbootwork.demo.Impl;

import com.springbootwork.demo.entity.Department;
import com.springbootwork.demo.repository.DepartmentRepository;
import com.springbootwork.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
