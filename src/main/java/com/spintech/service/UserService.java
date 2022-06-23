package com.spintech.service;

import com.spintech.response.ShowResponse;

import java.util.List;

public interface UserService {
    List<ShowResponse> getRecommendedUnwatchedShows(Long userId);

    List<ShowResponse> getAllShows();
}
