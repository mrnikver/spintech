package com.spintech.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ActorResponse {
    private String name;
    private String surname;
}
