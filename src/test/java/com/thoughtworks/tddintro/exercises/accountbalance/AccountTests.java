package com.thoughtworks.tddintro.exercises.accountbalance;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTests {
    private Account account;
    @Before
    public void setup(){
        account = new Account();
        account.deposit(100);
    }
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        account.deposit(50);
        assertBalance(150);
    }

    private void assertBalance(double expectedBalance) {
        assertEquals(expectedBalance,account.getBalance(),0);
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        account.withdraw(50.0);
        assertBalance(50.0);
    }



    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        account.withdraw(200);
        assertBalance(100);
    }
}
