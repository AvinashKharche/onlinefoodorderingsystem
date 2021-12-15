package org.nyu.onlinefoodorderingsystem.repository;

import org.nyu.onlinefoodorderingsystem.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {

}