package com.assignment.dvdlibrary.ui;

import java.util.Scanner;

public class Misc {

    public String startMessage = "  _______      _______    _      _ _                          \n" +
            " |  __ \\ \\    / /  __ \\  | |    (_) |                         \n" +
            " | |  | \\ \\  / /| |  | | | |     _| |__  _ __ __ _ _ __ _   _ \n" +
            " | |  | |\\ \\/ / | |  | | | |    | | '_ \\| '__/ _` | '__| | | |\n" +
            " | |__| | \\  /  | |__| | | |____| | |_) | | | (_| | |  | |_| |\n" +
            " |_____/   \\/   |_____/  |______|_|_.__/|_|  \\__,_|_|   \\__, |\n" +
            "                                                         __/ |\n" +
            "                                                        |___/";

    public String greet = "Welcome to DVD library!\n";

    public String instructions =
            "1 - Add DVD\n" +
            "2 - Edit DVD\n" +
            "3 - Remove DVD\n" +
            "4 - Show contents of DVD\n" +
            "5 - Batch add DVDs\n" +
            "6 - Batch edit DVDs\n" +
            "7 - Batch remove DVDs\n" +
            "8 - List DVDs\n" +
            "9 - Search DVD\n" +
            "10 - Save DVD\n" +
            "11 - Load DVD\n" +
            "12 - EXIT\n";

    public String listDVDs = "\n=========================\n" +
            "=== Listing your DVDs ===\n" +
            "=========================";

    public String cmdCursor = ">> ";

    public String input(String s) {
        System.out.print(s + ": ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public String input() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

}
