package com.backend.heArt.model;


import lombok.Data;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Data
public class GraphQLRequestBody {

    private String query;
    private String operationName;
    private Map<String, Object> variables;

}
