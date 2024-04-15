package org.list;

import java.util.ArrayList;

/*
배열 -> 가변 크기의 ArrayList는 capacity가 필요없다!!
 */

public class Bank {
    private String bankName; // 은행 이름
    private ArrayList<Account> accountList; // 은행에 등록된 통장 목록

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accountList = new ArrayList<>(); // ArrayList는 가변크기 배열이기에, int capacity 필요없음!
    }

    // 통장 개설
        // 배열에서는 capacity가 정해져있어, 정해진 배열 크기가 넘으면, 사용자 예외처리(BankCapacityExceededException)를 해줬지만,
        // ArrayList는, Integer의 MAX_VALUE만 안 넘으면 된다!!
    public Account openAccount(String accountNumber, String accountHolderName, int balance) throws BankCapacityExceededException {

        if (accountList.size() >= Integer.MAX_VALUE) {
            throw new BankCapacityExceededException("은행 통장 개설 용량을 초과했습니다.");
        }

        Account account = new Account(accountNumber, accountHolderName, balance);
        accountList.add(account);
        System.out.println("새로운 통장 개설을 성공했습니다!");

        return account;
    }

    // 특정 통장 정보 조회
    public void getAccountInfo(String accountNumber) throws AccountNotFoundException {

        for (Account temp : accountList){
            if (temp != null && accountNumber.equals(temp.getAccountNumber())){
                System.out.print("계좌번호 : " + temp.getAccountNumber());
                System.out.print(", 예금주 이름 : " + temp.getAccountHolderName());
                System.out.print(", 잔액 : " + temp.getBalance());
                System.out.println();
                return;
            }
        }

        // 여기에 온 경우 -> accountList == null
        //System.out.println("해당 은행에 등록된 어떠한 계좌 정보도 찾을 수 없습니다!");
        throw new AccountNotFoundException("해당 은행에 등록된 어떠한 계좌 정보도 찾을 수 없습니다!");

    }


    // getters
    public String getBankName() {
        return bankName;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String msg){
        super(msg);
    }
}

class BankCapacityExceededException extends Exception { // bank capacity 넘는 경우
    public BankCapacityExceededException(String msg){
        super(msg);
    }

}

