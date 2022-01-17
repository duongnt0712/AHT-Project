package com.aht.champion.repository;

import com.aht.champion.repository.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepository extends JpaRepository<Champion, Integer> {
    Champion findById(Long id);
}