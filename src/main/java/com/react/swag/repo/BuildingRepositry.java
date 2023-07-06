package com.react.swag.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.react.swag.entity.Building;

@Repository
public interface BuildingRepositry extends JpaRepository<Building, Integer> {

}
