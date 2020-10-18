package se.payment;

public interface Initialization <T extends Payment>{
    String name = null;
    String sum_payment= null;
    T init(String [] file);
    void view();
    void setInfo(String s);
    void controller(int command);
}
