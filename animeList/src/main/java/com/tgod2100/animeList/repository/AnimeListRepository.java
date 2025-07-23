package com.tgod2100.animeList.repository;

import com.tgod2100.animeList.entity.AnimeList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimeListRepository extends JpaRepository<AnimeList, Long> {
    List<AnimeList>findByEnNameContainingIgnoreCase(String enName);
    List<AnimeList>findByTwNameContainingIgnoreCase(String twName);
    List<AnimeList>findByJpNameContainingIgnoreCase(String jpName);
    Optional<AnimeList> findByEnName(String enName);
    Optional<AnimeList> findByTwName(String twName);
    Optional<AnimeList> findByJpName(String jpName);
}
