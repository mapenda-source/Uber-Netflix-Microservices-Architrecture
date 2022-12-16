package com.mapenda.architecture_netflix_uber.graphql.datafetcher;


import com.mapenda.architecture_netflix_uber.entity.MS;
import com.mapenda.architecture_netflix_uber.repository.MicroservicesRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleDataFetcher implements DataFetcher {

    @Autowired
    MicroservicesRepository microserviceRepository;

    @Override
    public MS get(DataFetchingEnvironment environment) {

        String key= environment.getArgument("id");
        int i=Integer.parseInt(key);
        return microserviceRepository.findById(i);
    }

}