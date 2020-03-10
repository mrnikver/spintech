package com.spintech.service;

public interface ActorService {

    void addFavouriteActor(Long userId, Long actorId);

    void removeFavouriteActor(Long userId, Long actorId);
}
