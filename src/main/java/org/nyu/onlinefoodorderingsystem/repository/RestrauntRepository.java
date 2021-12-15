package org.nyu.onlinefoodorderingsystem.repository;

import org.nyu.onlinefoodorderingsystem.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface RestrauntRepository extends JpaRepository<Restaurant, Long> {
}
