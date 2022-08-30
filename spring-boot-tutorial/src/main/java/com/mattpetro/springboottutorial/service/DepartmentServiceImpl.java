package com.mattpetro.springboottutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattpetro.springboottutorial.entity.Department;
import com.mattpetro.springboottutorial.error.DepartmentNotFoundException;
import com.mattpetro.springboottutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department){
        // no processing necessary, save it to the database
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments(){
        // will get all the deparments from the database
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long id) throws DepartmentNotFoundException{
        Optional<Department> department = departmentRepository.findById(id);  //get the specific department

        if (!department.isPresent()){  // what happens when there is no department with that Id
            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get(); // get the department object and return it
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        // nab value from the database
        Department depDB = departmentRepository.findById(departmentId).get();

        // check if any nulls or empties in our input, and if so do not change them
        if (Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())){
            depDB.setDepartmentName(department.getDepartmentAddress());
        }

        // save new values
        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
