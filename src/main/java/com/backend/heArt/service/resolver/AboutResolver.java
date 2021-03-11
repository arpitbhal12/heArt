package com.backend.heArt.service.resolver;

import com.backend.heArt.entity.About;
import com.backend.heArt.entity.User;
import com.backend.heArt.repository.AboutRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutResolver implements GraphQLResolver<User> {

    @Autowired
    AboutRepository aboutRepository;

    public About about(User user) {
        return aboutRepository.getAboutById(user.getAbout().getId());
    }
}
