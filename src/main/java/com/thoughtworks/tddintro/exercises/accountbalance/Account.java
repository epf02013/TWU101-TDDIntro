package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    private double balance;
    public Account(){
        balance=0;
    }
    public void deposit(double amount) {
        balance+=amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if(amount<=balance){
            balance-=amount;
        }
    }
}
