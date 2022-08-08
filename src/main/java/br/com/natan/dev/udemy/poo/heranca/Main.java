package br.com.natan.dev.udemy.poo.heranca;

import br.com.natan.dev.udemy.poo.heranca.entities.Account;
import br.com.natan.dev.udemy.poo.heranca.entities.BusinessAcount;
import br.com.natan.dev.udemy.poo.heranca.entities.SavingsAccount;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigDecimal.TEN;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(
                TWO.intValue(),
                "Account",
                TEN.doubleValue()
        );

        BusinessAcount businessAcount = new BusinessAcount(
                TEN.intValue(),
                "BusinessAcount",
                TEN.doubleValue(),
                TEN.doubleValue()
        );

        // Upcasting
        Account newAccount = businessAcount;

        Account savingsAccount = new SavingsAccount(
                ONE.intValue(),
                "SavingsAccount",
                TEN.doubleValue(),
                TEN.doubleValue()
        );

        // Downcasting
        BusinessAcount cast = (BusinessAcount) newAccount;

        if (savingsAccount instanceof SavingsAccount) {
            SavingsAccount instaceSavingsAccount = (SavingsAccount) savingsAccount;
            instaceSavingsAccount.updateBalance();
            System.out.println("Update!");
        }

        // After withdraw values
        System.out.println(account.getBalance());
        System.out.println(savingsAccount.getBalance());
        System.out.println(businessAcount.getBalance());

        account.withdraw(BigDecimal.ONE.doubleValue());
        savingsAccount.withdraw(TEN.doubleValue());
        businessAcount.withdraw(TEN.doubleValue());
        System.out.println("");

        // Before withdraw values
        System.out.println(account.getBalance());
        System.out.println(savingsAccount.getBalance());
        System.out.println(businessAcount.getBalance());
    }
}
