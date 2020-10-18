package se.payment;

import se.LexicSort;
import se.payment.createPayment.CreatePerson;
import se.payment.createPayment.CreatePhysicalPersonScore;

import java.util.ArrayList;
import java.util.Scanner;

/**наличными физическим лицам (назначение платежа,
 *  сумма платежа, номер чека, фамилия, имя,
 *  отчество, серия паспорта, номер паспорта);
 */
public class Person extends Payment implements Initialization{
    private int check_number;
    private String first_name;
    private String second_name;
    private String third_name;
    private String pasport_series;
    private int pasport_number;
    private static int index = 0;
    private static ArrayList<Payment> allInfo = new ArrayList<Payment>();
    private LexicSort lexicSort = new LexicSort();
    private CreatePerson createPerson = new CreatePerson();
    private Person l;
    @Override
    public Person init(String[] file) {
        if(file[0].equals("Person")){
            numberOfPayment++;
            set(file, 0);
        }
        return l;
    }
    public Person set(String[] file, int key){
        l = createPerson.create();
        if(key == 1){
            l.name_payment = file[0];
            l.payment = Integer.parseInt(file[1]);
            l.check_number = Integer.parseInt(file[2]);
            l.first_name = (file[3]);
            l.second_name = file[4];
            l.third_name = file[5];
            l.pasport_series = file[6];
            l.pasport_number = Integer.parseInt(file[7]);
        }
        else{
            l.name_payment = file[1];
            l.payment = Integer.parseInt(file[2]);
            l.check_number = Integer.parseInt(file[3]);
            l.first_name = (file[4]);
            l.second_name = file[5];
            l.third_name = file[6];
            l.pasport_series = file[7];
            l.pasport_number = Integer.parseInt(file[8]);
        }
        return l;
    }

    @Override
    public void view() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n назначение платежа(1), сумма платежа(2),\n" +
                " номер чека(3), фамилия(4), имя(5),\n" +
                " отчество(6), серия паспорта(7),\n" +
                " номер паспорта(8)");
        int i = sc.nextInt();
        controller(i);
    }

    @Override
    public void setInfo(String s) {
        String[] s2 = s.split(" ");
        allInfo.add(set(s2,1));
        System.out.println(allInfo.get(index));
        index++;    }

    @Override
    public void controller(int command) {
        int a = 0;
        StringBuilder [] field = new StringBuilder[allInfo.size()];
        for (int i1 = 0; i1 < field.length; i1++) {
            field[i1] = new StringBuilder("");
        }
        Person person;
        for(Payment p: allInfo){
            person = (Person) p;
            switch(command){
                case 1:
                    field[a++].append(person.name_payment);
                    break;
                case 2:
                    field[a++].append(person.payment);
                    break;
                case 3:
                    System.out.println("--"+person.check_number);
                    field[a++].append(person.check_number);
                    break;
                case 4:
                    field[a++].append(person.first_name);
                    break;
                case 5:
                    field[a++].append(person.second_name);
                    break;
                case 6:
                    field[a++].append(person.third_name);
                    break;
                case 7:
                    field[a++].append(person.pasport_series);
                    break;
                case 8:
                    field[a++].append(person.pasport_number);
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
                this.check_number + " " +
                this.first_name + " " +
                this.second_name + " " +
                this.third_name + " "+
                this.pasport_series + " " +
                this.pasport_number );
    }
}
