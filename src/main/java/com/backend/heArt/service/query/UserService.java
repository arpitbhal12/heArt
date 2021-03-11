package com.backend.heArt.service.query;

import com.backend.heArt.entity.About;
import com.backend.heArt.entity.User;
import com.backend.heArt.repository.AboutRepository;
import com.backend.heArt.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements GraphQLQueryResolver {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AboutRepository aboutRepository;

    public User getUser(Integer id) {
        return userRepository.findById((long) id).get();
    }

    public About getAbout(Integer id) {
        return aboutRepository.findById((long) id).get();
    }
}
