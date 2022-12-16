package com.mapenda.architecture_netflix_uber.repository;


import com.mapenda.architecture_netflix_uber.entity.MS;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroservicesPageRepository extends PagingAndSortingRepository<MS, Integer> {

}