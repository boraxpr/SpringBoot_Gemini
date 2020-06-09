package com.gemini.repository;

import com.gemini.model.SciencePlan;
import org.springframework.data.repository.CrudRepository;

public interface SciencePlanRepository extends
        CrudRepository<SciencePlan, Integer> {
}
