package com.backend.heArt.service.datafetcher;

import com.backend.heArt.entity.User;
import com.backend.heArt.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataFetcher implements DataFetcher<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public User get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        int id = dataFetchingEnvironment.getArgument("id");
        return userRepository.findById((long) id).get();
    }
}
