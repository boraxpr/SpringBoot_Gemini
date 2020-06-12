package com.gemini.repository;

import com.gemini.model.Employee;
import com.gemini.model.SciencePlan;
import org.springframework.data.repository.CrudRepository;

public interface ObservableSciplanRepository extends
        CrudRepository<SciencePlan, Integer> {
    SciencePlan findByPlanNo(int planNo);
}
