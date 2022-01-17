package com.aht.champion.repository;

import com.aht.champion.repository.model.Skin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SkinRepository extends JpaRepository<Skin,Long> {

    public List<Skin> findByChromas(boolean chromas);

    public List<Skin> findByChampionId(Long champion_id);

    public List<Skin> findByChampionIdAndChromas(Long champion_id, boolean chromas);
}

