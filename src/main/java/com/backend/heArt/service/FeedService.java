package com.backend.heArt.service;

import com.backend.heArt.entity.Comment;
import com.backend.heArt.entity.Post;
import com.backend.heArt.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class FeedService implements CommandLineRunner {

    @Autowired
    PostsRepository postsRepository;

    @Override
    public void run(String... args) throws Exception {
        Post post = new  Post(
            "Mona Lisa",
                (long) 1,
                "Monil",
                "\n" +
                        "Mona Lisa\n" +
                        "Italian: Monna Lisa, Italian: La Gioconda\n" +
                        "See adjacent text.\n" +
                        "The Mona Lisa digitally retouched to reduce the effects of aging. The unretouched image is darker.[1][2][3]\n" +
                        "Artist\tLeonardo da Vinci\n" +
                        "Year\tc. 1503–1506, perhaps continuing until c. 1517\n" +
                        "Medium\tOil on poplar panel\n" +
                        "Subject\tLisa Gherardini\n" +
                        "Dimensions\t77 cm × 53 cm (30 in × 21 in)\n" +
                        "Location\tLouvre, Paris\n" +
                        "The Mona Lisa (/ˌmoʊnə ˈliːsə/; Italian: Monna Lisa [ˈmɔnna ˈliːza] or La Gioconda [la dʒoˈkonda]; French: La Joconde [la ʒɔkɔ̃d]) is a half-length portrait painting by Italian artist Leonardo da Vinci. ",
                2500,
                    new Date(),
                Arrays.asList(
                        new Comment((long) 2, "Arpit", "Good!", 1200),
                        new Comment((long) 2, "Arpit", "Great Work Amigo!", 1200)
                )
        );
    }

    public List<Post> showFeed() {
        List<Post> posts = postsRepository.findAll();
        return posts;
    }

    public void savePost(Post post) {
        postsRepository.save(post);
        return;
    }

}
