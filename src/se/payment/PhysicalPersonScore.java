package se.payment;

import se.LexicSort;
import se.payment.createPayment.CreateLegalPersonScore;
import se.payment.createPayment.CreatePhysicalPersonScore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * по счетам физическим лицам (назначение платежа,
 * сумма платежа, название банка, номер счета,
 * фамилия, имя, отчество, серия паспорта, номер паспорта)*/
public class PhysicalPersonScore extends Payment  implements Initialization {
    private String bank_name;
    private int score_number;
    private String first_name;
    private String second_name;
    private String third_name;
    private String pasport_series;
    private int pasport_number;
    private static int index = 0;
    private static ArrayList<Payment> allInfo = new ArrayList<Payment>();
    private LexicSort lexicSort = new LexicSort();
    private CreatePhysicalPersonScore createPhysicalPersonScore = new CreatePhysicalPersonScore();
    private PhysicalPersonScore l;

    @Override
    public Payment init(String[] file) {
        if(file[0].equals("PhysicalPersonScore")){
            numberOfPayment++;
            set(file, 0);
        }
        return l;
    }

    public PhysicalPersonScore set(String[] file, int key){
        l = createPhysicalPersonScore.create();
        if(key == 1){
            l.name_payment = file[0];
            l.payment = Integer.parseInt(file[1]);
            l.bank_name = file[2];
            l.score_number = Integer.parseInt(file[3]);
            l.first_name = file[4];
            l.second_name = file[5];
            l.third_name = file[6];
            l.pasport_series = file[7];
            l.pasport_number = Integer.parseInt(file[8]);
        }
        else{
            l.name_payment = file[1];
            l.payment = Integer.parseInt(file[2]);
            l.bank_name = file[3];
            l.score_number = Integer.parseInt(file[4]);
            l.first_name = file[5];
            l.second_name = file[6];
            l.third_name = file[7];
            l.pasport_series = file[8];
            l.pasport_number = Integer.parseInt(file[9]);
        }
        return l;
    }



    @Override
    public void view() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n назначение платежа(1), сумма платежа(2),\n" +
                " название банка(3), номер счета(4), фамилия(5),\n" +
                " имя(6), отчество(7),\n" +
                " серия пастпорта(8), номер паспорта(9)");
        int i = sc.nextInt();
        controller(i);
    }

    @Override
    public void setInfo(String s) {
        String[] s2 = s.split(" ");
        allInfo.add(set(s2,1));
        System.out.println(allInfo.get(index));
        index++;
    }

    @Override
    public void controller(int command) {
        int a = 0;
        StringBuilder [] field = new StringBuilder[allInfo.size()];
        for (int i1 = 0; i1 < field.length; i1++) {
            field[i1] = new StringBuilder("");
        }
        PhysicalPersonScore physicalPersonScore;
        for(Payment p: allInfo){
            physicalPersonScore = (PhysicalPersonScore) p;
            switch(command){
                case 1:
                    field[a++].append(physicalPersonScore.name_payment);
                    break;
                case 2:
                    field[a++].append(physicalPersonScore.payment);
                    break;
                case 3:
                    field[a++].append(physicalPersonScore.bank_name);
                    break;
                case 4:
                    field[a++].append(physicalPersonScore.score_number);
                    break;
                case 5:
                    field[a++].append(physicalPersonScore.first_name);
                    break;
                case 6:
                    field[a++].append(physicalPersonScore.second_name);
                    break;
                case 7:
                    field[a++].append(physicalPersonScore.third_name);
                    break;
                case 8:
                    field[a++].append(physicalPersonScore.pasport_series);
                    break;
                case 9:
                    field[a++].append(physicalPersonScore.pasport_number);
                    break;
            }
        }
        lexicSort.sort(field,allInfo);
    }

    @Override
    public String toString(){
        return (
                this.name_payment + " " +
                this.payment+ " " +
                this.bank_name + " " +
                this.score_number + " " +
                this.first_name + " " +
                this.second_name + " " +
                this.third_name + " "+
                this.pasport_series + " " +
                this.pasport_number );
    }
}
