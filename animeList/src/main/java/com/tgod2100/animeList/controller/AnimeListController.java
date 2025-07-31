package com.tgod2100.animeList.controller;

import com.tgod2100.animeList.entity.AnimeList;
import com.tgod2100.animeList.service.AnimeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animelist")
public class AnimeListController {

    @Autowired
    private AnimeListService animeListService;

    @GetMapping
    public ResponseEntity<List<AnimeList>> getAllAnime() {
        List<AnimeList> animelist = animeListService.getAllAnime();
        if (animelist.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(animelist, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeList> findById(@PathVariable("id")Long id) {
        AnimeList anime = animeListService.findById(id);
        if (anime != null) {
            return new ResponseEntity<>(anime, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/en")
    public ResponseEntity<List<AnimeList>> searchByEnName(@RequestParam String keyword) {
        return ResponseEntity.ok(animeListService.findByEnName(keyword));
    }

    @GetMapping("/search/tw")
    public ResponseEntity<List<AnimeList>> searchByTwName(@RequestParam String keyword) {
        return ResponseEntity.ok(animeListService.findByTwName(keyword));
    }

    @GetMapping("/search/jp")
    public ResponseEntity<List<AnimeList>> searchByJpName(@RequestParam String keyword) {
        return ResponseEntity.ok(animeListService.findByJpName(keyword));
    }

    @PostMapping
    public AnimeList createAnimeList(@RequestBody AnimeList animeList) {
        return animeListService.createAnimeList(animeList);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<AnimeList>> createAnimes(@RequestBody List<AnimeList> animeLists) {
        List<AnimeList> savedList = animeListService.createAnimes(animeLists);
        return new ResponseEntity<>(savedList, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public AnimeList updateAnimeList(@PathVariable Long id, @RequestBody AnimeList updatedAnimeList) {
        return animeListService.updateAnimeList(id, updatedAnimeList);
    }

    @PutMapping("/update-by-en-name/{enName}")
    public AnimeList updateByEnName(@PathVariable String enName, @RequestBody AnimeList animeList) {
        return animeListService.updateByEnName(enName, animeList);
    }

    @PutMapping("/update-by-tw-name/{twName}")
    public AnimeList updateByTwName(@PathVariable String twName, @RequestBody AnimeList animeList) {
        return animeListService.updateByTwName(twName, animeList);
    }

    @PutMapping("/update-by-jp-name/{enName}")
    public AnimeList updateByJpName(@PathVariable String jpName, @RequestBody AnimeList animeList) {
        return animeListService.updateByJpName(jpName, animeList);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimeList(Long id) {
        animeListService.deleteAnimeList(id);
    }

    @DeleteMapping
    public void deleteAllAnimeList() {
        animeListService.deleteAllAnimeList();
    }

}
