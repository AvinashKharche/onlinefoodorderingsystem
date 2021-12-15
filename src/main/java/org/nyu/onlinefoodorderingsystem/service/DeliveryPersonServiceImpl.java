package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.DeliveryPerson;
import org.nyu.onlinefoodorderingsystem.repository.DeliveryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeliveryPersonServiceImpl implements DeliveryPersonService {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    public DeliveryPerson getDeliveryPerson(long deliveryPersonId) {
        Optional<DeliveryPerson> optional = deliveryPersonRepository.findById(deliveryPersonId);
        if (optional.isPresent()) return optional.get();
        throw new NoSuchElementException();
    }

    public List<DeliveryPerson> getAllDeliveryPerson() {
        return deliveryPersonRepository.findAll();
    }

    public void addDeliveryPersons(List<DeliveryPerson> deliveryPersons) {
        deliveryPersons.stream().forEach(c -> c.setCreatedDate(new Timestamp(System.currentTimeMillis())));
        deliveryPersonRepository.saveAll(deliveryPersons);
    }

    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPerson.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        deliveryPersonRepository.save(deliveryPerson);
    }
}
