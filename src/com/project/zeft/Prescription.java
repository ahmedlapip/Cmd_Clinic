package com.project.zeft;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prescription {
    private final int dosage;
    private final String Medicine_Name;
    private final String Other_Notes;
    private final LocalDate Prescription_Date;
    private final String userName;

    public Prescription(String userName, LocalDate Date, String Medicine_Name, int dosage, String Other_Notes) {
        this.dosage = dosage;
        this.Medicine_Name = Medicine_Name;
        this.Other_Notes = Other_Notes;
        this.userName = userName;
        this.Prescription_Date = Date;
    }

    public String getOther_Notes() {
        return Other_Notes;
    }

    public LocalDate getPrescription_Date() {
        return Prescription_Date;
    }

    public int getDosage() {

        return dosage;
    }

    public String getMedicine_Name() {
        return Medicine_Name;
    }

    public String getUserName() {

        return userName;
    }

    @Override
    public String toString() {

        return userName + ',' + Prescription_Date + ',' + Medicine_Name + ',' + dosage + ',' + Other_Notes;
    }

    public static Prescription fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid data format for Prescription.");
        }
        return new Prescription(parts[0],
                LocalDate.parse(parts[1],
                        DateTimeFormatter.ISO_LOCAL_DATE),
                parts[2],
                Integer.parseInt(parts[3]),
                parts[4]);
    }

}