package com.assignment.dvdlibrary.ui;

import com.assignment.dvdlibrary.dvdlibrary.DVD;
import com.assignment.dvdlibrary.controller.DVDCollections;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class DVDRun {

    static DVDCollections dvdCollections = new DVDCollections();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        System.out.println(Misc.startMessage);
        System.out.println(Misc.greet);
        start();
    }

    public static void start() throws ParseException {
        label:
        while (true) {
            System.out.println(Misc.instructions);
            System.out.print(Misc.cmdCursor);
            int selection = Integer.parseInt(scan.nextLine());
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

    private static void editDVD() {
        System.out.print("Enter the title of the DVD (type exit to exit): ");
        String input = scan.nextLine();
        if (!input.equals("exit")) dvdCollections.editCollection(input, scan);
    }

    private static void showDVDs() {
        dvdCollections.listCollections();
    }

    private static void removeDVD() {
        System.out.println("Enter your DVD title to remove");
        System.out.print(Misc.cmdCursor);
        String title = scan.nextLine();
        System.out.println(dvdCollections.removeCollection(title));
    }

    private static void readDVD() throws ParseException {
        System.out.println("Adding a DVD, please enter DVD format in order: ");
        System.out.print("Title: ");
        String title = scan.nextLine();
        System.out.print("Release date (in dd-mm-yyyy format): ");
        String date = scan.nextLine();
        System.out.print("MPAA Rating: ");
        String MPAA_RATING = scan.nextLine();
        System.out.print("Director Name: ");
        String directorName = scan.nextLine();
        System.out.print("Studio: ");
        String studio = scan.nextLine();
        System.out.print("Comments about the DVD: ");
        String userRating = scan.nextLine();
        DVD dvd = new DVD(title, date, MPAA_RATING, directorName, studio, userRating);
        dvdCollections.addToCollection(dvd);
        System.out.println("Your dvd has been added!");
    }

    private static void batchAction(String action) throws ParseException {
        String input;
        do {
            System.out.print("Continue? (Y/N): ");
            input = scan.nextLine().toLowerCase(Locale.ROOT);
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

    private static void showContents() {
        System.out.println("Enter the title of your DVD");
        System.out.print(Misc.cmdCursor);
        String title = scan.nextLine();
        dvdCollections.showContents(title);
    }

    private static void searchDVD() {
        System.out.println("Enter the title of your DVD");
        System.out.print(Misc.cmdCursor);
        String title = scan.nextLine();
        if (dvdCollections.doesExist(title)) {
            System.out.format("Found DVD titled: %s%n" +
                    "would you like to view the contents? (Y/N) ", title);
            String selection = scan.nextLine().toLowerCase(Locale.ROOT);
            if (selection.equals("y")) {
                dvdCollections.showContents(title);
            }
        } else {
            System.out.println("That DVD does not exist.");
        }
    }

    private static void saveDVDs() {
        dvdCollections.saveDVDList();
    }

    private static void loadDVDs(DVDCollections collections) {
        dvdCollections.loadDVDlist(collections);
    }
}
