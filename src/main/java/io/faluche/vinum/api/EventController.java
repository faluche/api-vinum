package io.faluche.vinum.api;

import io.faluche.vinum.api.model.InteractionModel;
import io.faluche.vinum.api.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public void createEvent() {

    }

    @GetMapping
    public void findAllEvents() {

    }

    @GetMapping("{idEvent}")
    public void getEventById(@PathVariable Long idEvent) {

    }

    @DeleteMapping
    public void deleteEvent() {

    }

    @GetMapping("{idEvent}/attendees")
    public void getAttendeesByEventId(@PathVariable Long idEvent) {

    }

    @GetMapping("{idEvent}/interactions")
    public List<InteractionModel> findInteractionsByEventId(@PathVariable Long idEvent) throws Exception {
        return eventService.findInteractionsByEventId(idEvent);
    }
}
