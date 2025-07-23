package com.tgod2100.animeList.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "animelist")
public class AnimeList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "enName")
    private String enName;

    @Column(name = "twName")
    private String twName;

    @Column(name = "jpName")
    private String jpName;

    @Column(name = "description")
    private String description;

    @Column(name = "isWatched")
    private boolean isWatched;

    @Column(name = "watchedTimes")
    private Integer watchedTimes;

    @Column(name = "releaseYear")
    private Integer releaseYear;

    public AnimeList() {
    }

    public AnimeList(String enName, String twName, String jpName, String description, boolean isWatched, Integer watchedTimes, Integer releaseYear) {
        this.enName = enName;
        this.twName = twName;
        this.jpName = jpName;
        this.description = description;
        this.isWatched = isWatched;
        this.watchedTimes = watchedTimes;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getTwName() {
        return twName;
    }

    public void setTwName(String twName) {
        this.twName = twName;
    }

    public String getJpName() {
        return jpName;
    }

    public void setJpName(String jpName) {
        this.jpName = jpName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public Integer getWatchedTimes() {
        return watchedTimes;
    }

    public void setWatchedTimes(Integer watchedTimes) {
        this.watchedTimes = watchedTimes;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "AnimeList{" +
                "id=" + id +
                ", enName='" + enName + '\'' +
                ", twName='" + twName + '\'' +
                ", jpName='" + jpName + '\'' +
                ", description='" + description + '\'' +
                ", isWatched=" + isWatched +
                ", watchedTimes=" + watchedTimes +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
