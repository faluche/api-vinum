package io.faluche.vinum.api.service;

import io.faluche.vinum.api.model.AttendeeModel;
import io.faluche.vinum.api.model.InteractionModel;
import io.faluche.vinum.api.repository.EventRepository;
import io.faluche.vinum.api.repository.InteractionRepository;
import io.faluche.vinum.api.repository.domain.Attendee;
import io.faluche.vinum.api.repository.domain.Event;
import io.faluche.vinum.api.repository.domain.Interaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final InteractionRepository interactionRepository;

    public List<InteractionModel> findInteractionsByEventId(Long eventId) throws Exception {
        // Recherche de l'évènement
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isEmpty()) {
            throw new Exception();
        }
        // Récupération des interactions
        List<Interaction> interactions = interactionRepository.findAllByEvent(event.get());

        return interactions.stream().map(this::map).collect(toList());


    }

    private InteractionModel map(Interaction interaction) {
        return InteractionModel.builder()
                .attendee(map(interaction.getAttendee()))
                .build();
    }

    private AttendeeModel map(Attendee attendee) {
        return AttendeeModel.builder()
                .idFaluche(attendee.getIdFaluche())
                .build();
    }
}
