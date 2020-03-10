package com.spintech.service.impl;

import com.spintech.entity.impl.Actor;
import com.spintech.entity.impl.Show;
import com.spintech.entity.impl.User;
import com.spintech.repository.UserRepository;
import com.spintech.response.ActorResponse;
import com.spintech.response.ShowResponse;
import com.spintech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<ShowResponse> getRecommendedUnwatchedShows(Long userId) {
        User user = userRepository.getOne(userId);
        return user.getFavouriteActors()
                .stream()
                .map(Actor::getShows)
                .flatMap(Collection::stream)
                .filter(show -> !user.getWatchedShows().contains(show))
                .map(this::toShowResponse)
                .collect(Collectors.toList());
    }

    private ShowResponse toShowResponse(Show show) {
        final List<ActorResponse> actors = show.getActors().stream()
                .map(this::toActorResponse)
                .collect(Collectors.toList());

        return ShowResponse.builder()
                .description(show.getDescription())
                .name(show.getName())
                .actors(actors)
                .build();
    }

    private ActorResponse toActorResponse(Actor actor) {
        return ActorResponse.builder()
                .name(actor.getFirstName())
                .surname(actor.getLastName())
                .build();
    }
}
