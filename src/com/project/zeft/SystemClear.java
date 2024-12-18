package com.project.zeft;

import java.util.Scanner;

public class SystemClear {

    /**
     * Clears the console screen using ANSI escape codes.
     * Note: This works for terminals that support ANSI escape codes.
     */

    public static void pause() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
