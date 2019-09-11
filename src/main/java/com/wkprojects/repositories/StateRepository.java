package com.wkprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wkprojects.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
