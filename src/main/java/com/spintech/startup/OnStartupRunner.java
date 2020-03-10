package com.spintech.startup;

import com.spintech.entity.impl.Actor;
import com.spintech.entity.impl.Show;
import com.spintech.entity.impl.User;
import com.spintech.repository.ActorRepository;
import com.spintech.repository.ShowRepository;
import com.spintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class OnStartupRunner implements ApplicationRunner {
    private final ActorRepository actorRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        Show knivesOut = new Show()
                .setName("Knives Out")
                .setDescription("Knives Out description");

        Show skyfall = new Show()
                .setName("SkyFall")
                .setDescription("SkyFall description");

        Actor actor = new Actor()
                .setFirstName("Daniel")
                .setLastName("Craig")
                .setShows(Set.of(knivesOut, skyfall));

        User user = new User()
                .setEmail("user@user.user")
                .setFirstName("firstName")
                .setLastName("lastName");

        actorRepository.save(actor);
        showRepository.saveAll(List.of(knivesOut, skyfall));
        userRepository.save(user);
    }
}
