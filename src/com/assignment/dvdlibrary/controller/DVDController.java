package com.assignment.dvdlibrary.controller;

import com.assignment.dvdlibrary.dvdlibrary.DVD;
import com.assignment.dvdlibrary.file.DVDFile;
import com.assignment.dvdlibrary.ui.Misc;

import java.util.*;

public class DVDController {
    private Map<String, DVD> dvdList;
    private final Misc misc = new Misc();

    public DVDController() {
        dvdList = new HashMap<>();
    }

    //method to add dvds
    public void addToCollection(DVD dvd) {
        dvdList.putIfAbsent(dvd.getTitle(), dvd);
    }

    public void editCollection(String title){
        if (doesExist(title)) {
            System.out.print("What would you like to edit?\n" +
                    "1 - Title\n" +
                    "2 - Release Date\n" +
                    "3 - MPAA rating\n" +
                    "4 - Director name\n" +
                    "5 - Studio name\n" +
                    "6 - User rating\n" +
                    "7 - Exit\n");
            System.out.print(">> ");
            int selection = Integer.parseInt(misc.input());
            switch (selection) {
                case 1:
                    String newTitle = misc.input("Editing title");
                    dvdList.get(title).setTitle(newTitle);
                    DVD newDvd = dvdList.get(title);
                    removeCollection(title);
                    addToCollection(newDvd);
                    break;
                case 2:
                    String newDate = misc.input("Editing release date (in DD-MM-YYYY format)");
                    dvdList.get(title).setReleaseDate(newDate);
                    break;
                case 3:
                    String newMpaaRating = misc.input("Editing mpaa rating");
                    dvdList.get(title).setMPAA_RATING(newMpaaRating);
                    break;
                case 4:
                    String newDirectorName = misc.input("Editing director name");
                    dvdList.get(title).setDirectorName(newDirectorName);
                    break;
                case 5:
                    String newStudio = misc.input("Editing studio name");
                    dvdList.get(title).setStudio(newStudio);
                    break;
                case 6:
                    String newUserRating = misc.input("Editing user rating");
                    dvdList.get(title).setUserRating(newUserRating);
                    break;
                default:
                    break;
            }
            System.out.println("Edit complete.\n");
        } else {
            System.out.println("This title doesn't exist!");
        }
    }

    public String removeCollection(String title) {
        if (dvdList.containsKey(title)) {
            dvdList.remove(title);
            return "DVD removed.\n";
        } else {
            return "DVD doesn't exist!\n";
        }
    }

    public void listCollections() {
        int count = 1;
        if (dvdList.size() >= 1) {
            System.out.println("\n=========================\n" +
                    "=== Listing your DVDs ===\n" +
                    "=========================");
            for (String dvds : dvdList.keySet()) {
                System.out.format("%o - %s%n", count, dvds);
                count++;
            }
            System.out.println("=========================\n");
        } else {
            System.out.println("\nYou have no DVDs.\n");
        }
    }

    public void saveDVDList() {
        DVDFile save = new DVDFile();
        save.clearFile();
        if (dvdList.size() >= 1) {
            for (String dvds : dvdList.keySet()) {
                save.saveToFile(dvdList.get(dvds));
                System.out.format("saving %s%n", dvds);
            }
            System.out.println("Saved.");
        } else {
            System.out.println("Nothing to save.");
        }
    }

    public void loadDVDlist(DVDController collections) {
        DVDFile load = new DVDFile();
        load.readFromFile(collections);
    }

    public void showContents(String title) {
        System.out.println(dvdList.get(title).toString());
    }

    public boolean doesExist(String title) {
        return dvdList.containsKey(title);
    }

}
