package com.mapenda.architecture_netflix_uber.graphql.datafetcher;

import com.mapenda.architecture_netflix_uber.entity.MS;
import com.mapenda.architecture_netflix_uber.repository.MicroservicesRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllDataFetcher implements DataFetcher {

    @Autowired
    MicroservicesRepository microserviceRepository;

    @Override
    public List<MS> get(DataFetchingEnvironment environment) {

        return microserviceRepository.findAll();
    }


}
