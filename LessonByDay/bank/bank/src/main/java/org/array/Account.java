package org.array;

public class Account {
    private String accountNumber; // 계좌번호; "123-456-789"
    private String accountHolderName; // 예금주 이름
    private int balance; // 잔액

    public Account(String accountNumber, String accountHolderName, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // 임금 기능
    public void deposit(int amount){
        balance += amount;
        System.out.println("입금이 성공적으로 완료되었습니다!");
    }

    // 출금 기능
    public void withDrawal(int amount) throws InsufficientFundsException{
        if (balance < amount) {
            //System.out.println("잔액이 부족합니다!");
            throw new InsufficientFundsException(this.accountNumber + " 의 잔액 "+ (amount - balance) +"만큼 부족합니다!");
        } else {
            balance -= amount;
            System.out.println("인출에 성공했습니다!");
        }
    }

    // getters

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg){
        super(msg);
    }
}
