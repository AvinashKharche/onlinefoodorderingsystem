
package org.nyu.onlinefoodorderingsystem.repository;

import org.nyu.onlinefoodorderingsystem.model.PositionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<PositionDetails, Long> {

}