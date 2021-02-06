package com.backend.heArt;

import com.backend.heArt.service.datafetcher.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;

@SpringBootApplication
@EnableAsync
public class HeArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeArtApplication.class, args);
	}

	@Autowired
	UserDataFetcher userDataFetcher;

	@Bean
	public GraphQL graphQL() throws IOException {
		SchemaParser schemaParser = new SchemaParser();
		ClassPathResource schema = new ClassPathResource("schema.graphql");
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema.getInputStream());

		RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getUser", userDataFetcher))
				.build();

		SchemaGenerator generator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = generator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		return GraphQL.newGraphQL(graphQLSchema).build();
	}

	@Bean
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("JDAsync-");
		executor.initialize();
		return executor;
	}

}
