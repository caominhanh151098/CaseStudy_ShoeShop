package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.SizeDao;
import com.example.casestudy_shoeshop.model.Size;

import java.util.List;

public class SizeService {
    private final SizeDao sizeDao = new SizeDao();

    public List<Size> findAll(){
        return sizeDao.findAll();
    }
}
