package com.sandlayth.fastfood.repository;

import com.sandlayth.fastfood.entity.products.Composition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long>{
}