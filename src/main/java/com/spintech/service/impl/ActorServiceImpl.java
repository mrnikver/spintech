package com.spintech.service.impl;

import com.spintech.entity.Actor;
import com.spintech.entity.User;
import com.spintech.repository.ActorRepository;
import com.spintech.repository.UserRepository;
import com.spintech.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    private final UserRepository userRepository;

    @Override
    public void addFavouriteActor(Long userId, Long actorId) {
        User user = userRepository.getOne(userId);
        Actor actor = actorRepository.getOne(actorId);

        user.getFavouriteActors().add(actor);
        userRepository.save(user);
    }

    @Override
    public void removeFavouriteActor(Long userId, Long actorId) {
        User user = userRepository.getOne(userId);
        Actor actor = actorRepository.getOne(actorId);

        user.getFavouriteActors().remove(actor);
        userRepository.save(user);
    }
}
