package com.spintech.contoller;

import com.spintech.response.ShowResponse;
import com.spintech.service.ActorService;
import com.spintech.service.ShowService;
import com.spintech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.spintech.constants.URIConstants.*;

@RestController
@AllArgsConstructor
public class UserShowController {
    private final UserService userService;
    private final ActorService actorService;
    private final ShowService showService;

    @PostMapping(USER_ACTOR)
    public void addFavouriteActor(@PathVariable Long userId,
                                  @RequestParam Long actorId) {
        actorService.addFavouriteActor(userId, actorId);
    }

    @DeleteMapping(USER_ACTOR)
    public void removeFavouriteActor(@PathVariable Long userId,
                                     @RequestParam Long actorId) {
        actorService.removeFavouriteActor(userId, actorId);
    }

    @PostMapping(USER_SHOW)
    public void addWatchedShow(@PathVariable Long userId,
                               @RequestParam Long showId) {
        showService.addWatchedShow(userId, showId);
    }

    @DeleteMapping(USER_SHOW)
    public void removeWatchedShow(@PathVariable Long userId,
                                  @RequestParam Long showId) {
        showService.removeWatchedShow(userId, showId);
    }

    @GetMapping(RECOMMENDED)
    public List<ShowResponse> getRecommendedUnwatchedShows(@PathVariable Long userId) {
        return userService.getRecommendedUnwatchedShows(userId);
    }
}
