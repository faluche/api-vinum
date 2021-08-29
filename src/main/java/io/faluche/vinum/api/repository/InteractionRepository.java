package io.faluche.vinum.api.repository;

import io.faluche.vinum.api.repository.domain.Event;
import io.faluche.vinum.api.repository.domain.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {

     List<Interaction> findAllByEvent(Event event);
}
