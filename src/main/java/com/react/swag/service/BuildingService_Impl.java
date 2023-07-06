package com.react.swag.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.react.swag.entity.Building;
import com.react.swag.exception.classes.BuildingDetailsNotAdded;
import com.react.swag.exception.classes.BuildingNotFound;
import com.react.swag.repo.BuildingRepositry;
@Component
public class BuildingService_Impl implements IBuildingService {


	private BuildingRepositry repo;

	@Autowired
	public void setRepo(BuildingRepositry repo) {
		this.repo = repo;
	}

	@Override
	public void saveData(Building bill) {
		if (bill != null && bill.getBuildingName() != " ") {
			repo.save(bill);
		} else {
			throw new BuildingDetailsNotAdded("Data Not Added Successfully. Please Try Again");
		}
	}

	@Override
	public Optional<Building> getBuildingData(int id) {
		Optional<Building> op = repo.findById(id);
		if (op.isPresent()) {
			return op;
		} else {
			throw new BuildingNotFound("No Data Present With This ID : " + id);
		}

	}

	@Override
	public List<Building> fetchData() {
		
		
		return repo.findAll();
	}

	@Override
	public Building updateById(Building build) {

		return repo.save(build);
	}

	@Override
	public void deleteBuilding(int id) {
		repo.deleteById(id);
	}

}
