package com.backend.heArt.service.mutation;

import com.backend.heArt.entity.About;
import com.backend.heArt.entity.User;
import com.backend.heArt.entity.UserInput;
import com.backend.heArt.exception.ResourceNotFoundException;
import com.backend.heArt.model.AboutInput;
import com.backend.heArt.repository.AboutRepository;
import com.backend.heArt.repository.UserRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserMutationService implements GraphQLMutationResolver {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AboutRepository aboutRepository;

    @Transactional
    public User updateUser(UserInput userInput) {
        if(!userRepository.findById(userInput.getId()).isPresent()) {
            throw new ResourceNotFoundException("User", "name", userInput.getName());
        } else {
            User previousUser = userRepository.findById(userInput.getId()).get();
            if (userInput.getName() != null) {
                previousUser.setName(userInput.getName());
            }
            if (userInput.getUsername() != null) {
                previousUser.setUsername(userInput.getUsername());
            }
            if (userInput.getEmail() != null) {
                previousUser.setEmail(userInput.getEmail());
            }
            if (userInput.getPassword() != null) {
                previousUser.setPassword(userInput.getPassword());
            }
            if (userInput.getPhone() != null) {
                previousUser.setPhone(userInput.getPhone());
            }
            if (userInput.getRating() > 0) {
                previousUser.setRating(userInput.getRating());
            }
            userRepository.save(previousUser);
            return previousUser;
        }
    }

    @Transactional
    public About updateAbout(AboutInput aboutInput) {
        Optional<About> about = aboutRepository.findById(aboutInput.getId());
        if(!about.isPresent()) {
            throw new ResourceNotFoundException("About", "User Id", aboutInput.getId());
        } else {
            About newAbout = about.get();
            if(aboutInput.getDob() != null) {
                newAbout.setDob(aboutInput.getDob());
            }
            if(aboutInput.getBio() != null) {
                newAbout.setBio(aboutInput.getBio());
            }
            aboutRepository.save(newAbout);
            return newAbout;
        }
    }

}
