package com.sg;

public class Main {

    public static void main(String[] args){

        Bank bank=new Bank("National NZ Bank");
        bank.addBranch("Auckland");
        bank.addCustomer("Auckland","Tim", 50.05);
        bank.addCustomer("Auckland","Mike",175.34);
        bank.addCustomer("Auckland", "Percy", 220.12);
        bank.addCustomerTransaction("Auckland", "Tim",44.22);
        bank.addCustomerTransaction("Auckland","Tim",12.44);
        bank.addCustomerTransaction("Auckland","Mike",1.65);
        bank.listCustomers("Auckland", true);

        bank.addBranch("Wellington");
        bank.addCustomer("Wellington","Bob", 150.54);
        bank.listCustomers("Wellington",true);


        bank.addBranch("Christchurch");
        if(!bank.addCustomer("Christchurch","Brain",5.53)){
            System.out.println("\nError Christchurch branch does not exist");
        }

        if(!bank.addBranch("Auckland")){
            System.out.println("\nAuckland branch already exists");
        }

        if(!bank.addCustomerTransaction("Auckland","Fergus", 52.33)){
            System.out.println("\nCustomer does not exist at branch");
        }

        if(!bank.addCustomer("Auckland","Tim",12.21)){
            System.out.println("\nCustomer Tim already exists");
        }
    }
}
