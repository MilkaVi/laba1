package se.payment;

import se.LexicSort;
import se.payment.createPayment.CreateLegalPersonScore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * по счетам юридическим лицам (назначение платежа, сумма платежа,
 * название банка, номер счета, название юридического лица,
 * номер государственной регистрации, фамилия руководителя,
 * имя руководителя, отчество руководителя)
 */
public class LegalPersonScore extends Payment implements Initialization{
    private String bank_name;
    private String score_number;
    private String legal_name;
    private String reg_number;
    private String director_first_name;
    private String director_second_name;
    private String director_third_name;
    private static int index = 0;
    private static ArrayList<Payment> allInfo = new ArrayList<Payment>();
    private LexicSort lexicSort = new LexicSort();
    private CreateLegalPersonScore createLegalPersonScore = new CreateLegalPersonScore();
    private LegalPersonScore l;
    @Override
    public LegalPersonScore init(String[] file) {
        if(file[0].equals("LegalPersonScore")){
            numberOfPayment++;
            set(file, 0);
        }
        return l;
    }

    public LegalPersonScore set(String[] file, int key){
        l = createLegalPersonScore.create();
        if(key == 1){
            l.name_payment = file[0];
            l.payment = Integer.parseInt(file[1]);
            l.bank_name = file[2];
            l.score_number = file[3];
            l.legal_name = file[4];
            l.reg_number = file[5];
            l.director_first_name = file[6];
            l.director_second_name = file[7];
            l.director_third_name = file[8];
        }
        else{
            l.name_payment = file[1];
            l.payment = Integer.parseInt(file[2]);
            l.bank_name = file[3];
            l.score_number = file[4];
            l.legal_name = file[5];
            l.reg_number = file[6];
            l.director_first_name = file[7];
            l.director_second_name = file[8];
            l.director_third_name = file[9];
        }
        return l;
    }
    @Override
    public void view() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n назначение платежа(1), сумма платежа(2),\n" +
                " название банка(3), номер счета(4), название юридического лица(5),\n" +
                " номер государственной регистрации(6), фамилия руководителя(7),\n" +
                " имя руководителя(8), отчество руководителя(9)");
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
        LegalPersonScore legalPersonScore;
        for(Payment p: allInfo){
            legalPersonScore = (LegalPersonScore) p;
            switch(command){
                case 1:
                    field[a++].append(legalPersonScore.name_payment);
                    break;
                case 2:
                    field[a++].append(legalPersonScore.payment);
                    break;
                case 3:
                    field[a++].append(legalPersonScore.bank_name);
                    break;
                case 4:
                    field[a++].append(legalPersonScore.score_number);
                    break;
                case 5:
                    field[a++].append(legalPersonScore.legal_name);
                    break;
                case 6:
                    field[a++].append(legalPersonScore.reg_number);
                    break;
                case 7:
                    field[a++].append(legalPersonScore.director_first_name);
                    break;
                case 8:
                    field[a++].append(legalPersonScore.director_second_name);
                    break;
                case 9:
                    field[a++].append(legalPersonScore.director_third_name);
                    break;
            }
        }
        lexicSort.sort(field,allInfo);
    }


    @Override
    public String toString(){
        return (
                this.name_payment + " " +
                this.payment + " " +
                this.bank_name + " " +
                this.score_number+ " " +
                this.legal_name + " " +
                this.reg_number + " " +
                this.director_first_name + " " +
                this.director_second_name + " " +
                this.director_third_name + " ");
    }
}
