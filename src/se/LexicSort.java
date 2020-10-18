package se;

import org.w3c.dom.ls.LSOutput;
import se.payment.Payment;

import java.util.ArrayList;

public class LexicSort {
    public  void sort(StringBuilder [] mystr, ArrayList<Payment> allInfo){
        for(int i=0;i<mystr.length-1;i++){
            for(int j=i+1 ;j<mystr.length;j++){
                if( mystr[i].compareTo(mystr[j]) > 0 ){
                    Payment tmp = allInfo.get(i);
                    allInfo.set(i, allInfo.get(j));
                    allInfo.set(j, tmp);
                }
            }
        }
        // print array
        for(int i=0;i<allInfo.size();i++){
            System.out.println(allInfo.get(i));
        }
    }
}
