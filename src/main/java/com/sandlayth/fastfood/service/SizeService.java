package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.Size;
import com.sandlayth.fastfood.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getSizes() { return sizeRepository.findAll();}
    public Size getSizeById(Long id) { return sizeRepository.findById(id).orElse(null);}

    public Size saveSize(Size size) { return sizeRepository.save(size);}

    public void deleteSize(Size size) { sizeRepository.delete(size); }

    public Size updateSize(Size size) {
        Size s = sizeRepository.findById(size.getId()).orElse(size);
        s.setName(size.getName());
        return sizeRepository.save(s);
    }
}
