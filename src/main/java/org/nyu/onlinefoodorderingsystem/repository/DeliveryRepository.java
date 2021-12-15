package org.nyu.onlinefoodorderingsystem.repository;

import org.nyu.onlinefoodorderingsystem.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}