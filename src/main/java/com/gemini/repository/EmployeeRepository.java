package com.gemini.repository;

import com.gemini.model.Employee;
import com.gemini.model.SciencePlan;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends
        CrudRepository<Employee, Integer> {
    Employee findByUsername(String username);
}
