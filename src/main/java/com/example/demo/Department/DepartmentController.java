package com.example.demo.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceInterface departmentServiceInterface;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentServiceInterface.createDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentServiceInterface.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") UUID id) {
        return departmentServiceInterface.getDepartmentById(id).orElseThrow();
    }
    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") UUID id){
        departmentServiceInterface.deleteDepartmentById(id);
        return "Department with id " + id + " deleted successfully";
    }
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") UUID id, @RequestBody Department department){
        return departmentServiceInterface.updateDepartment(id, department);
    }
    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        return departmentServiceInterface.getDepartmentByName(name).orElseThrow();
    }

}
