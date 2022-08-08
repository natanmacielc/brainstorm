package br.com.natan.dev.udemy.poo.polimorfismo;

import br.com.natan.dev.udemy.poo.heranca.entities.Account;
import br.com.natan.dev.udemy.poo.heranca.entities.SavingsAccount;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigInteger.TWO;

public class Main {
    public static void main(String[] args) {

        Account account = new Account(
                ONE.intValue(),
                "Account",
                TEN.doubleValue()
        );

        Account savingsAccount = new SavingsAccount(
                TWO.intValue(),
                "savingsAccount",
                TEN.doubleValue(),
                ONE.doubleValue()
        );

        account.withdraw(ONE.doubleValue());
        savingsAccount.withdraw(ONE.doubleValue());

        System.out.println(account.getBalance());
        System.out.println(savingsAccount.getBalance());
    }
}
