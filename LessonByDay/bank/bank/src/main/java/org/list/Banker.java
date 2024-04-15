package org.list;


public class Banker {
    private String bankerName; // 은행원 이름
    private int bankerId; // 은행원 ID

    public Banker(String bankerName, int bankerId) {
        this.bankerName = bankerName;
        this.bankerId = bankerId;
    }

    // 통장 개설 승인
    public Account approveOpenAccount(Bank bank, String accountNumber, String accountHolderName, int balance) throws BankCapacityExceededException {
        Account account = bank.openAccount(accountNumber, accountHolderName, balance);
        System.out.println("통장 개설 승인이 되었습니다. " + "통장 개설 담당자 : " + this.bankerName);

        return account;
    }

    // 출금 승인
    public void approveWithdrawal(Account account, int amount) throws InsufficientFundsException {
        account.withdrawal(amount);
        System.out.println("출금이 승인되었습니다. " + "출금 승인 담당자 : " + this.bankerName);
    }
}

