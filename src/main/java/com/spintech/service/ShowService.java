package com.spintech.service;

public interface ShowService {
    void addWatchedShow(Long userId, Long showId);

    void removeWatchedShow(Long userId, Long showId);
}
