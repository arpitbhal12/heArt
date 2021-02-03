package com.backend.heArt.controller;


import java.util.concurrent.CompletableFuture;

import com.backend.heArt.model.GraphQLRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;

@RestController
public class GraphQLController {

    @Autowired
    private GraphQL graphql;

    @PostMapping(value="graphql", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ExecutionResult> execute(@RequestBody GraphQLRequestBody body) {
        return graphql.executeAsync(ExecutionInput.newExecutionInput().query(body.getQuery())
                .operationName(body.getOperationName()).variables(body.getVariables()).build());
    }
}