package com.Mylab.EmployeeManager;

import com.Mylab.EmployeeManager.Models.Employee;
import com.Mylab.EmployeeManager.Services.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeServices employeeServices;

    public EmployeeResource(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeServices.findAllEmployee();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getOneEmployees(@PathVariable("id") long id){
        Employee employees = employeeServices.findEmployeeById(id);
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employees = employeeServices.addEmployee(employee);
        return  new ResponseEntity<>(employees,HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployees(@PathVariable("id") long id){
        employeeServices.Detele(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployees(@RequestBody Employee employee){
        Employee employees = employeeServices.UpdateEmployee(employee);
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
