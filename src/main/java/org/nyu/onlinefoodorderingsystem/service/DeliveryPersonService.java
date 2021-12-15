package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.DeliveryPerson;

import java.util.List;

public interface DeliveryPersonService {
    void addDeliveryPerson(DeliveryPerson deliveryPerson);

    void addDeliveryPersons(List<DeliveryPerson> deliveryPersons);

    List<DeliveryPerson> getAllDeliveryPerson();

    DeliveryPerson getDeliveryPerson(long deliveryPersonId);
}
