package com.spintech.service.impl;

import com.spintech.entity.Show;
import com.spintech.entity.User;
import com.spintech.repository.ShowRepository;
import com.spintech.repository.UserRepository;
import com.spintech.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;


    @Override
    public void addWatchedShow(Long userId, Long showId) {
        User user = userRepository.getOne(userId);
        Show show = showRepository.getOne(showId);

        user.getWatchedShows().add(show);
        userRepository.save(user);
    }

    @Override
    public void removeWatchedShow(Long userId, Long showId) {
        User user = userRepository.getOne(userId);
        Show show = showRepository.getOne(showId);

        user.getWatchedShows().remove(show);
        userRepository.save(user);
    }
}
