package com.wkprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wkprojects.domain.DemandItem;

@Repository
public interface DemandItemRepository extends JpaRepository<DemandItem, Integer>{

}
