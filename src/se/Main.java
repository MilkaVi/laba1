package se;

import se.payment.Initialization;
import se.payment.LegalPersonScore;
import se.payment.TakeFromFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new TakeFromFile().readFile("file.txt");


    }
}
