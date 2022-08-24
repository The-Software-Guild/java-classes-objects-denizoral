package com.assignment.dvdlibrary.dvdlibrary;

import java.time.LocalDate;
import java.util.Date;

public class DVD {

    private String title;
    private String releaseDate;
    private String MPAA_RATING;
    private String directorName;
    private String studio;
    private String userRating;

    public DVD(String title, String releaseDate, String MPAA_RATING,
               String directorName, String studio, String userRating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.MPAA_RATING = MPAA_RATING;
        this.directorName = directorName;
        this.studio = studio;
        this.userRating = userRating;
    }

    /*
    setters
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMPAA_RATING(String MPAA_RATING) {
        this.MPAA_RATING = MPAA_RATING;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    /*
    getters
     */
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate.toString();
    }

    public String getRating() {
        return MPAA_RATING;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getStudio() {
        return studio;
    }

    public String getUserRating() {
        return userRating;
    }

    @Override
    public String toString() {
        return String.format("Title: %s%n" +
                "Release date: %s%n" +
                "Rating: %s%n" +
                "Director: %s%n" +
                "Studio: %s%n" +
                "User Rating: %s%n", getTitle(), getReleaseDate(), getRating(), getDirectorName(), getStudio(), getUserRating());
    }
}
