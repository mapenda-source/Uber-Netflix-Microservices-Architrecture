package com.mapenda.architecture_netflix_uber.graphql.service;

import com.mapenda.architecture_netflix_uber.graphql.datafetcher.AllDataFetcher;
import com.mapenda.architecture_netflix_uber.graphql.datafetcher.SingleDataFetcher;
import com.mapenda.architecture_netflix_uber.repository.MicroservicesRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.errors.SchemaProblem;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
@Service
public class GraphQLService {
    @Autowired
    MicroservicesRepository microserviceRepository;

    @Value("classpath:microservice.graphql")
    Resource resource;

    @Autowired
    private AllDataFetcher allDataFetcher;

    @Autowired
    private SingleDataFetcher singleDataFetcher;

    private GraphQL graphQL;

    @PostConstruct
    private void loadSchema() throws IOException, SchemaProblem {


        File schemaFile=resource.getFile();

        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();

    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allData", allDataFetcher)
                        .dataFetcher("single", singleDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
