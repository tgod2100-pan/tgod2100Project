package com.tgod2100.animeList.service;

import com.tgod2100.animeList.entity.AnimeList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AnimeListService {
    List<AnimeList> getAllAnime();
    AnimeList findById(Long id);
    List<AnimeList> findByEnName(@PathVariable("enName")String enName);
    List<AnimeList> findByTwName(@PathVariable("twName")String twName);
    List<AnimeList> findByJpName(@PathVariable("jpName")String jpName);
    AnimeList createAnimeList(AnimeList animeList);
    List<AnimeList> createAnimes(List<AnimeList> animeLists);
    AnimeList updateAnimeList(Long id, AnimeList animeList);
    AnimeList updateByEnName(String enName, AnimeList animeList);
    AnimeList updateByTwName(String twName, AnimeList animeList);
    AnimeList updateByJpName(String jpName, AnimeList animeList);
    void deleteAnimeList(Long id);
    void deleteAllAnimeList();

}
