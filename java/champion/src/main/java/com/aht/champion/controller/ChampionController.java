package com.aht.champion.controller;

import com.aht.champion.repository.model.Champion;
import com.aht.champion.repository.model.Skill;
import com.aht.champion.repository.model.Skin;
import com.aht.champion.repository.ChampionRepository;
import com.aht.champion.repository.SkillRepository;
import com.aht.champion.repository.SkinRepository;
import com.aht.champion.service.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ChampionController {

    @Autowired
    ChampionRepository championRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    SkinService skinService;

    @GetMapping("/champion")
    public ResponseEntity<Object> getAllChamp(){
        return new ResponseEntity<>(championRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/champion/{id}")
    public ResponseEntity<Object> getAllChamp(@PathVariable Long id){
        return new ResponseEntity<>(championRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/skin")
    public ResponseEntity<Object> getAllSkin(){
        return new ResponseEntity<>(skinService.getAllSkin(), HttpStatus.OK);
    }

    @GetMapping("/skin/chromas")
    public ResponseEntity<Object> getAllChormasSkin(@Param("chromas") boolean chromas){
        return new ResponseEntity<>(skinService.getAllChromas(chromas), HttpStatus.OK);
    }

    @GetMapping("/skin/champion")
    public ResponseEntity<Object> getAllChampionSkin(@Param("champion_id") Long champion_id,
                                                     @Param("chromas") boolean chromas){
        return new ResponseEntity<>(skinService.getAllSkinByChampionIdAndChromas(champion_id, chromas), HttpStatus.OK);
    }
}
