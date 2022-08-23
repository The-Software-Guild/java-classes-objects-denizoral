package com.assignment.dvdlibrary.controller;

import com.assignment.dvdlibrary.dvdlibrary.DVD;
import com.assignment.dvdlibrary.file.DVDFile;
import com.assignment.dvdlibrary.ui.Misc;

import java.util.*;

public class DVDCollections {
    //Hashmap will hold the title and the com.assignment.dvdlibrary.dvdlibrary.DVD data.
    Map<String, List<DVD>> dvdList;
    Misc misc = new Misc();

    public DVDCollections() {
        dvdList = new HashMap<>();
    }

    //method to add dvds
    public void addToCollection(DVD dvd) {
        dvdList.putIfAbsent(dvd.getTitle(), Collections.singletonList(dvd));
    }

    public void editCollection(String title, Scanner scan){
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
            int selection = Integer.parseInt(scan.nextLine());
            switch (selection) {
                case 1:
                    System.out.print("Editing title: ");
                    String newTitle = scan.nextLine();
                    dvdList.get(title).get(0).setTitle(newTitle);
                    DVD newDvd = dvdList.get(title).get(0);
                    removeCollection(title);
                    addToCollection(newDvd);
                    break;
                case 2:
                    System.out.println("Editing release date (in DD-MM-YYYY format): ");
                    String newDate = scan.nextLine();
                    dvdList.get(title).get(0).setReleaseDate(newDate);
                    break;
                case 3:
                    System.out.print("Editing MPAA RATING: ");
                    String newMpaaRating = scan.nextLine();
                    dvdList.get(title).get(0).setMPAA_RATING(newMpaaRating);
                    break;
                case 4:
                    System.out.print("Editing director name: ");
                    String newDirectorName = scan.nextLine();
                    dvdList.get(title).get(0).setDirectorName(newDirectorName);
                    break;
                case 5:
                    System.out.print("Editing studio name: ");
                    String newStudio = scan.nextLine();
                    dvdList.get(title).get(0).setStudio(newStudio);
                    break;
                case 6:
                    System.out.print("Editing user rating: ");
                    String newUserRating = scan.nextLine();
                    dvdList.get(title).get(0).setUserRating(newUserRating);
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
                save.saveToFile(dvdList.get(dvds).get(0));
                System.out.format("saving %s%n", dvds);
            }
            System.out.println("Saved.");
        } else {
            System.out.println("Nothing to save.");
        }
    }

    public void loadDVDlist(DVDCollections collections) {
        DVDFile load = new DVDFile();
        load.readFromFile(collections);
    }

    public void showContents(String title) {
        System.out.println(dvdList.get(title).get(0).toString());
    }

    public boolean doesExist(String title) {
        return dvdList.containsKey(title);
    }
}
