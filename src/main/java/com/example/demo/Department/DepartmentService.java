package com.example.demo.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService implements DepartmentServiceInterface{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(UUID id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void deleteDepartmentById(UUID id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(UUID id, Department department) {
        Department depDB = departmentRepository.findById(id).orElseThrow();
        if(department.getAddress() != null && !department.getAddress().isEmpty()) depDB.setAddress(department.getAddress());
        if(department.getName() != null && !department.getName().isEmpty()) depDB.setName(department.getName());
        if(department.getCode() != null && !department.getCode().isEmpty()) depDB.setCode(department.getCode());

        return departmentRepository.save(depDB);
    }

    @Override
    public Optional<Department> getDepartmentByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
    }
}
