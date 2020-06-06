package com.sandlayth.fastfood.repository;

import com.sandlayth.fastfood.entity.products.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{
    public List<Pizza> findByName(String name);
}