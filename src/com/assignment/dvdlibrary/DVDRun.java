package com.assignment.dvdlibrary;

import com.assignment.dvdlibrary.ui.Misc;
import com.assignment.dvdlibrary.ui.UI;

import java.text.ParseException;

public class DVDRun {

    public static void main(String[] args) {
        Misc misc = new Misc();
        System.out.println(misc.startMessage);
        System.out.println(misc.greet);
        UI ui = new UI(misc);
        ui.start();
    }
}
