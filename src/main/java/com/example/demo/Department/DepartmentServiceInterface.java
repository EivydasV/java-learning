package com.example.demo.Department;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DepartmentServiceInterface {
    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Optional<Department> getDepartmentById(UUID id);

    void deleteDepartmentById(UUID id);

    Department updateDepartment(UUID id, Department department);

    Optional<Department> getDepartmentByName(String name);
}
