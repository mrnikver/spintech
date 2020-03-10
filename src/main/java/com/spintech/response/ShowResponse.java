package com.spintech.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ShowResponse {
    private String name;
    private String description;
    private List<ActorResponse> actors;
}
