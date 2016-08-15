package com.insightfullogic.java8.exercises.chapter4;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.List;
import java.util.Optional;

public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public  Optional<Artist> getArtist(int index) {
        Optional<Artist> artist = Optional.empty();

        if (index >= 0 || index >= artists.size()) {
            return artist;
        }

        return Optional.of(artists.get(index));
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index + 
                                           " doesn't correspond to an Artist");
    }

    public String getArtistName(int index) {
        try {
            Optional<Artist> artist = getArtist(index);
            if (artist.isPresent()){
                return artist.get().getName();
            }

            return "";
        } catch (IllegalArgumentException e) {
            return "unknown";
        }
    }

}
