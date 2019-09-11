package com.wkprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wkprojects.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
