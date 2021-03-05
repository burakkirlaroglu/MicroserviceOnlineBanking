package com.microservice.card.repository;

import com.microservice.card.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Page<Card> findAll(Pageable page);

    Card getById(Integer id);
}
