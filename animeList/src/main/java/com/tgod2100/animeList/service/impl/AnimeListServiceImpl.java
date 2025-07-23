package com.tgod2100.animeList.service.impl;

import com.tgod2100.animeList.entity.AnimeList;
import com.tgod2100.animeList.repository.AnimeListRepository;
import com.tgod2100.animeList.service.AnimeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimeListServiceImpl implements AnimeListService {
    @Autowired
    private AnimeListRepository animeListRepository;

    @Override
    public List<AnimeList> getAllAnime(){
        return animeListRepository.findAll();
    }

    @Override
    public AnimeList findById(Long id) {
        return animeListRepository.findById(id).orElseThrow(() -> new RuntimeException("AnimeList not found with id: " + id));
    }

    @Override
    public List<AnimeList> findByEnName(String enName) {
        return animeListRepository.findByEnNameContainingIgnoreCase(enName);
    }

    @Override
    public List<AnimeList> findByTwName(String twName) {
        return animeListRepository.findByTwNameContainingIgnoreCase(twName);
    }

    @Override
    public List<AnimeList> findByJpName(String jpName) {
        return animeListRepository.findByJpNameContainingIgnoreCase(jpName);
    }

    @Override
    public AnimeList createAnimeList(AnimeList animeList){
        return animeListRepository.save(animeList);
    }

    public List<AnimeList> createAnimes(List<AnimeList> animeLists) {
        return animeListRepository.saveAll(animeLists);
    }

    @Override
    public AnimeList updateAnimeList(Long id, AnimeList updatedAnimeList){
        Optional<AnimeList> optionalAnimeList = animeListRepository.findById(id);
        if(optionalAnimeList.isPresent()){
            AnimeList existingAnimeList = optionalAnimeList.get();

            existingAnimeList.setEnName(updatedAnimeList.getEnName());
            existingAnimeList.setTwName(updatedAnimeList.getTwName());
            existingAnimeList.setJpName(updatedAnimeList.getJpName());
            existingAnimeList.setDescription(updatedAnimeList.getDescription());
            existingAnimeList.setWatched(updatedAnimeList.isWatched());
            existingAnimeList.setWatchedTimes(updatedAnimeList.getWatchedTimes());
            existingAnimeList.setReleaseYear(updatedAnimeList.getReleaseYear());

            return animeListRepository.save(existingAnimeList);
        } else {
            throw new RuntimeException("AnimeList not found with id:" + id);
        }
    }

    @Override
    public AnimeList updateByEnName(String enName, AnimeList animeList){
        AnimeList existing = animeListRepository.findByEnName(enName).orElseThrow(() -> new RuntimeException("Anime not found with English name: " + enName));
        return updateAnimeListData(existing, animeList);
    }

    @Override
    public AnimeList updateByTwName(String twName, AnimeList animeList){
        AnimeList existing = animeListRepository.findByTwName(twName).orElseThrow(() -> new RuntimeException("Anime not found with Taiwan name: " + twName));
        return updateAnimeListData(existing, animeList);
    }

    @Override
    public AnimeList updateByJpName(String jpName, AnimeList animeList){
        AnimeList existing = animeListRepository.findByJpName(jpName).orElseThrow(() -> new RuntimeException("Anime not found with Japan name: " + jpName));
        return updateAnimeListData(existing, animeList);
    }

    private AnimeList updateAnimeListData(AnimeList existing, AnimeList newData){
        existing.setEnName(newData.getEnName());
        existing.setTwName(newData.getTwName());
        existing.setJpName(newData.getJpName());
        existing.setDescription(newData.getDescription());
        existing.setWatched(newData.isWatched());
        existing.setWatchedTimes(newData.getWatchedTimes());
        existing.setReleaseYear(newData.getReleaseYear());
        return animeListRepository.save(existing);
    }

    @Override
    public void deleteAnimeList(Long id){
        if (animeListRepository.existsById(id)) {
            animeListRepository.deleteById(id);
        } else {
            throw  new RuntimeException("AnimeList not found with id: " + id);
        }
    }

    public void deleteAllAnimeList(){
        animeListRepository.deleteAll();
    }

}
