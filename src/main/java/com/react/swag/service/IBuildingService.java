package com.react.swag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.react.swag.entity.Building;

@Service
public interface IBuildingService {

	void saveData(Building bill);

	Optional<Building> getBuildingData(int id);

	List<Building> fetchData();

	Building updateById( Building build);

	void deleteBuilding(int id);

}
