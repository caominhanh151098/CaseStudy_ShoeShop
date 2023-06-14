package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.DeliveryDao;
import com.example.casestudy_shoeshop.model.Delivery;

import java.util.List;

public class DeliveryService {
    private static DeliveryDao deliveryDao = new DeliveryDao();

    public List<Delivery> findAll() {
        return deliveryDao.getAll();
    }

    public void createDelivery(Delivery delivery) {
        deliveryDao.insertDelivery(delivery);
    }

    public Delivery findById(int id) {
        return deliveryDao.findById(id);
    }

    public void editDeli(Delivery delivery) {
        deliveryDao.updateDelivery(delivery);
    }
}
