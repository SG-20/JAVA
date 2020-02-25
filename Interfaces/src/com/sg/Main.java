package com.sg;

public class Main {

    public static void main(String[] args){
        ITelephone sgPhone;
        sgPhone=new DeskPhone(123456);
        sgPhone.powerOn();
        sgPhone.callPhone(123456);
        sgPhone.answer();

        sgPhone=new MobilePhone(34567);
        sgPhone.powerOn();
        sgPhone.callPhone(34567);
        sgPhone.answer();


    }

}
