package com.market.magas.repository;

import com.market.magas.entity.BirdEntityInMagaz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BirdEntityInMagazReposiotory extends JpaRepository<BirdEntityInMagaz, Long> {
    List<BirdEntityInMagaz> findAllByBirdType(String type);
}
