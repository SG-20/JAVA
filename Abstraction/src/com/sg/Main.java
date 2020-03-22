package com.sg;

public class Main {

    public static void main(String[] args){
        Dog dog= new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("NZ Parrot");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin= new Penguin("Emperor");
        penguin.fly();
    }
}
