package com.Mylab.EmployeeManager.Services;

import com.Mylab.EmployeeManager.Models.Employee;
import com.Mylab.EmployeeManager.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServices {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeServices(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }
    public Employee UpdateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void Detele(long id){
        employeeRepo.deleteById(id);
    }
    public Employee findEmployeeById(long id){


        return  employeeRepo.findAllById(id);

    }


}
