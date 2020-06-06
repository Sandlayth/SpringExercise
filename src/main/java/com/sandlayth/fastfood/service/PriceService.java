package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.Price;
import com.sandlayth.fastfood.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;
    
    public List<Price> getPrices() { return priceRepository.findAll();}
    public Price getPriceById(Long id) { return priceRepository.findById(id).orElse(null); }
    
    public Price savePrice(Price price) { return priceRepository.save(price);}
    public List<Price> savePrices(List<Price> prices) { return priceRepository.saveAll(prices);}
    
    public void deletePrice(Price price) { priceRepository.delete(price);}
    
    public Price updatePrice(Price price) {
        Price p = priceRepository.findById(price.getId()).orElse(price);
        p.setPrice(price.getPrice());
        p.setSize(price.getSize());
        p.setType(price.getType());
        return priceRepository.save(p);
    }
}
