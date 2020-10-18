package se;

import se.payment.LegalPersonScore;
import se.payment.Payment;
import se.payment.Person;
import se.payment.PhysicalPersonScore;

import java.util.ArrayList;
import java.util.Scanner;

public class Organisation {
    Scanner sc = new Scanner(System.in);
    Payment payment = new Payment();
    LegalPersonScore legalPersonScore = new LegalPersonScore();
    PhysicalPersonScore physicalPersonScore = new PhysicalPersonScore();
    Person person = new Person();
    public void showTabl(ArrayList<Payment> payments){
        System.out.println("показать всё (1)\n" +
                "по счетам юридическим лицам (2)\n"+
                "по счетам физическим лицам (3)\n"+
                "наличными физическим лицам (4)\n");
        int i = sc.nextInt();
        int index = 0;
        switch (i){
            case 1:
                for(Payment e: payments)
                    System.out.println(e);
                break;
            case 2:
                while(index < payments.size()){
                    if(payments.get(index) instanceof LegalPersonScore){
                        legalPersonScore = (LegalPersonScore)payments.get(index);
                        legalPersonScore.setInfo(legalPersonScore.toString());
                    }
                    ++index;
                }
                legalPersonScore.view();
                break;
            case 3:
                while(index < payments.size()){
                    if(payments.get(index) instanceof PhysicalPersonScore){
                        physicalPersonScore = (PhysicalPersonScore)payments.get(index);
                        physicalPersonScore.setInfo(physicalPersonScore.toString());
                    }
                    ++index;
                }
                physicalPersonScore.view();
                break;
            case 4:
                while(index < payments.size()){
                    if(payments.get(index) instanceof Person){
                        person = (Person) payments.get(index);
                        person.setInfo(person.toString());
                    }
                    ++index;
                }
                person.view();
                break;
        }
    }
}
