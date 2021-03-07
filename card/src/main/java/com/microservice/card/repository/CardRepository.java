package com.microservice.card.repository;

import com.microservice.card.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

    Page<Card> findAll(Pageable page);

    Card getById(UUID id);

    List<Card> getByCustomerId(Long tc);
}
