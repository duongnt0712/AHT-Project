package com.aht.champion.service;

import com.aht.champion.repository.SkinRepository;
import com.aht.champion.repository.model.Skin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinService {

    @Autowired
    SkinRepository skinRepository;

    public List<Skin> getAllSkin(){
        return skinRepository.findAll();
    }

    public List<Skin> getAllChromas(boolean chromas){
        return skinRepository.findByChromas(chromas);
    }

    public List<Skin> getAllChampSkin(Long champion_id){
        return skinRepository.findByChampionId(champion_id);
    }

    public List<Skin> getAllSkinByChampionIdAndChromas(Long id, boolean chromas){
        return skinRepository.findByChampionIdAndChromas(id, chromas);
    }
}
