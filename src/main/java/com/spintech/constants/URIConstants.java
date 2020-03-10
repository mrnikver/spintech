package com.spintech.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class URIConstants {
    public static final String USER = "/user/{userId}";
    public static final String USER_ACTOR = USER + "/actor";
    public static final String USER_SHOW = USER + "/show";
    public static final String RECOMMENDED = USER_SHOW + "/recommendations";
}
