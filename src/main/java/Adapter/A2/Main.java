package Adapter.A2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("C:\\Users\\42130\\Desktop\\learning\\00.source_code\\gof_23\\src\\main\\java\\Adapter\\A2\\file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("C:\\Users\\42130\\Desktop\\learning\\00.source_code\\gof_23\\src\\main\\java\\Adapter\\A2\\newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
