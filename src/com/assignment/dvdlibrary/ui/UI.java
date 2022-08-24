package com.assignment.dvdlibrary.ui;

import com.assignment.dvdlibrary.controller.DVDController;
import com.assignment.dvdlibrary.dvdlibrary.DVD;

import java.util.Locale;
import java.util.Scanner;

public class UI {
    private final DVDController dvdCollections = new DVDController();
    private final Misc misc;

    public UI (Misc misc) {
        this.misc = misc;
    }

     public void start() {
        label:
        while (true) {
            System.out.println(misc.instructions);
            System.out.print(misc.cmdCursor);
            int selection = Integer.parseInt(misc.input());
            switch (selection) {
                case 1:
                    readDVD();
                    break;
                case 2:
                    editDVD();
                    break;
                case 3:
                    removeDVD();
                    break;
                case 4:
                    showContents();
                    break;
                case 5:
                    batchAction("add");
                    break;
                case 6:
                    batchAction("edit");
                    break;
                case 7:
                    batchAction("remove");
                    break;
                case 8:
                    showDVDs();
                    break;
                case 9:
                    searchDVD();
                    break;
                case 10:
                    saveDVDs();
                    break;
                case 11:
                    loadDVDs(dvdCollections);
                    break;
                case 12:
                    break label;
            }
        }
        System.out.println("Goodbye!");
    }

    private void editDVD() {
        String input = misc.input("Enter the title of the DVD (type exit to exit)");
        if (!input.equals("exit")) dvdCollections.editCollection(input);
    }

    private void showDVDs() {
        dvdCollections.listCollections();
    }

    private void removeDVD() {
        System.out.println("Enter your DVD title to remove");
        String title = misc.input(misc.cmdCursor);
        System.out.println(dvdCollections.removeCollection(title));
    }

    private void readDVD() {
        System.out.println("Adding a DVD, please enter DVD format in order: ");
        String title = misc.input("Title");
        String date = misc.input("Release date (in dd-mm-yyyy format)");
        String MPAA_RATING = misc.input("Mpaa Rating");
        String directorName = misc.input("Director name");
        String studio = misc.input("Studio");
        String userRating = misc.input("Comments about the DVD");
        DVD dvd = new DVD(title, date, MPAA_RATING, directorName, studio, userRating);
        dvdCollections.addToCollection(dvd);
        System.out.println("Your dvd has been added!");
    }

    private void batchAction(String action) {
        String input;
        do {
            System.out.print("Continue? (Y/N): ");
            input = misc.input().toLowerCase(Locale.ROOT);
            if ("y".equals(input)) {
                switch (action) {
                    case "add":
                        readDVD();
                        break;
                    case "edit":
                        editDVD();
                        break;
                    case "remove":
                        removeDVD();
                        break;
                    default:
                        break;
                }
            }
        } while (!input.equals("n"));

    }

    private void showContents() {
        String title = misc.input("Enter the title of your DVD");
        dvdCollections.showContents(title);
    }

    private void searchDVD() {
        String title = misc.input("Enter the title of your DVD");
        if (dvdCollections.doesExist(title)) {
            System.out.format("Found DVD titled: %s%n" +
                    "would you like to view the contents? (Y/N) ", title);
            String selection = misc.input().toLowerCase(Locale.ROOT);
            if (selection.equals("y")) {
                dvdCollections.showContents(title);
            }
        } else {
            System.out.println("That DVD does not exist.");
        }
    }

    private void saveDVDs() {
        dvdCollections.saveDVDList();
    }

    private void loadDVDs(DVDController collections) {
        dvdCollections.loadDVDlist(collections);
    }
}
