package se.payment;
import se.Organisation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TakeFromFile {
    static HashMap<String, Initialization> mmap = new HashMap<>();
    ArrayList<Payment> finalMass = new ArrayList<>();
    Organisation organisation = new Organisation();
    static {
        mmap.put("LegalPersonScore", new LegalPersonScore());
        mmap.put("PhysicalPersonScore", new PhysicalPersonScore());
        mmap.put("PlanA", new Person());
    }
    public void readFile(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String s = null;
        String s2[] = null;
        while ((s = in.readLine()) != null){
            s2 = s.split(" ");
            finalMass.add((Payment) mmap.get(s2[0]).init(s2));
        }
        organisation.showTabl(finalMass);
    }
}
