package com.mapenda.architecture_netflix_uber.service;

import com.mapenda.architecture_netflix_uber.entity.MS;

import java.util.List;

public interface MicroserviceServiceInterface {

    public List<MS> findAll();

    public void save(MS OBJ);

    public void deleteById(int theId);

    public MS findById(int theId);

    //public List<Microservices> findByMicroentity1(String seq);
}
