package com.sandlayth.fastfood.repository;

import com.sandlayth.fastfood.entity.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{
}