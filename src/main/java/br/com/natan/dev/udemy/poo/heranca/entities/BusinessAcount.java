package br.com.natan.dev.udemy.poo.heranca.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigInteger.TWO;

public class BusinessAcount extends Account {

    private Double loanLimit;

    public BusinessAcount() {
        super();
    }

    public BusinessAcount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount) {
        if(amount <= loanLimit && amount >= Double.valueOf(BigDecimal.TEN.doubleValue())) {
            deposit(amount - Double.valueOf(BigDecimal.TEN.doubleValue()));
        }
    }

    @Override
    public final void withdraw(Double amount) {
        super.withdraw(amount);
        balance -= TWO.doubleValue();
    }
}
