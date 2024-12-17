package OOP;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.io.*;
import java.util.*;
public class Prescription {
    private int dosage;
    private String Medicine_Name;
    private String Other_Notes;
    private LocalDate Prescription_Date;
    private String U_Name;

    public Prescription(String U_Name, LocalDate Date , String Medicine_Name, int dosage, String Other_Notes) {
        this.dosage = dosage;
        this.Medicine_Name = Medicine_Name;
        this.Other_Notes = Other_Notes;
        this.U_Name = U_Name;
        this.Prescription_Date = Date;
    }


}

