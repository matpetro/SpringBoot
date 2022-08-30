package com.mattpetro.springboottutorial.service;

import java.util.List;

import com.mattpetro.springboottutorial.entity.Department;
import com.mattpetro.springboottutorial.error.DepartmentNotFoundException;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> getDepartments();
    public Department getDepartment(Long id) throws DepartmentNotFoundException;
    public void deleteDepartment(Long id);
    public Department updateDepartment(Long departmentId, Department department);
    public Department getDepartmentByName(String name);
}
