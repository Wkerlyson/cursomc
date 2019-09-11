package com.wkprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wkprojects.domain.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Integer> {

}
