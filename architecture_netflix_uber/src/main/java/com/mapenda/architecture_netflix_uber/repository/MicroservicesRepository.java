package com.mapenda.architecture_netflix_uber.repository;

import com.mapenda.architecture_netflix_uber.entity.MS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("MicroservicesRepository")
public interface MicroservicesRepository extends JpaRepository<MS, Integer> {

     MS findById(int id);

}