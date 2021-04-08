package com.Mylab.EmployeeManager.Repo;

import com.Mylab.EmployeeManager.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long > {
    void deleteById(long id);

    Employee findAllById(long id);
}
