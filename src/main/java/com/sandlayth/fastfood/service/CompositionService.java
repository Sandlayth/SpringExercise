package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.products.Composition;
import com.sandlayth.fastfood.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompositionService {
    @Autowired
    private CompositionRepository compositionRepository;

    public Composition saveComposition(Composition composition) { return compositionRepository.save(composition); }
    public List<Composition> saveCompositions(List<Composition> compositions) { return compositionRepository.saveAll(compositions); }


    public List<Composition> getCompositions() { return compositionRepository.findAll(); }
    public Composition getCompositionById(Long id) { return compositionRepository.findById(id).orElse(null); }

    public void deleteComposition(Composition composition) { compositionRepository.delete(composition); }

    public Composition updateComposition(Composition composition) {
        Composition c = compositionRepository.findById(composition.getId()).orElse(composition);
        c.setCost(composition.getCost());
        c.setPrices(composition.getPrices());
        c.setABase(composition.getABase());
        c.setAppearsInMenu(composition.getAppearsInMenu());
        c.setName(composition.getName());
        c.setPicture(composition.getPicture());
        c.setQuantity(composition.getQuantity());
        return compositionRepository.save(c);
    }

}
