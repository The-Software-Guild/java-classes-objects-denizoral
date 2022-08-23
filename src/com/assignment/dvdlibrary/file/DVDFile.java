package com.assignment.dvdlibrary.file;

import com.assignment.dvdlibrary.dvdlibrary.DVD;
import com.assignment.dvdlibrary.controller.DVDCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DVDFile {

    public void saveToFile(DVD dvd) {
        FileWriter saved;
        try {
            saved = new FileWriter("DVDLibrary.txt", true);
            saved.append(dvd.getTitle()).append("\n")
                    .append(dvd.getReleaseDate()).append("\n")
                    .append(String.valueOf(dvd.getRating()))
                    .append("\n").append(dvd.getDirectorName())
                    .append("\n").append(dvd.getStudio())
                    .append("\n").append(String.valueOf(dvd.getUserRating()))
                    .append("\n");
            saved.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clearFile() {

        FileWriter clean;
        try {
            clean = new FileWriter("DVDLibrary.txt");
            clean.write("");
            clean.flush();
            clean.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkIfEmpty () {
        File file = new File("DVDLibrary.txt");
        return file.exists();
    }


    public void readFromFile(DVDCollections collections) {
//        DVDCollections dvdCollections = new DVDCollections();
        File f = new File("DVDLibrary.txt");
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String title = s.nextLine();
            String releaseDate = s.nextLine();
            String mpaa = s.nextLine();
            String directorName = s.nextLine();
            String studio = s.nextLine();
            String userRating = s.nextLine();
            DVD dvd = new DVD(title, releaseDate, mpaa, directorName, studio, userRating);
            System.out.println(dvd.getTitle() + " added");
            collections.addToCollection(dvd);
        }
        System.out.println("Added all dvds from file!");
    }

}
