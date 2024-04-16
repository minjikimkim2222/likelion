package org.set_map;

import java.util.HashSet;

/*
    HashSet을 이용한 통장 목록 관리
        Bank 객체에서, Account(통장) 모음을 HashSet 자료구조로 관리해,
        중복된 통장 개설을 막고 + 빠른 검색 속도 제공

    - openAccount함수 : 이미 존재하는 계좌인지 확인할 예외처리클래스 추가
        - HashSet의 자료형인 Account에 accountName이 같다면 같은 객체로 취급하게끔 equals와 hashCode 메서드 오버라이딩!
 */
public class Bank {
    private String bankName; // 은행 이름

    private HashSet<Account> accountList; // 1개의 Bank 객체 - HashSet 자료구조

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accountList = new HashSet<>();
    }

    // 통장 개설
    public Account openAccount(String accountNumber, String accountHolderName, int balance) throws BankCapacityExceededException, AccountAlreadyExistsException {

        if (accountList.size() >= Integer.MAX_VALUE) {
            throw new BankCapacityExceededException("은행 통장 개설 용량을 초과했습니다.");
        }

        // 이미 존재하는 계좌인지 체크 - 예외 처리 확인
        for (Account account : accountList){
            if (account.getAccountNumber().equals(accountNumber)){
                throw new AccountAlreadyExistsException("계좌번호가 이미 존재합니다. 다른 계좌번호를 입력해주세요!");
            }
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

    public HashSet<Account> getAccountList() {
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

// 이미 존재하는 Account인지 체크
class AccountAlreadyExistsException extends Exception {
    public AccountAlreadyExistsException(String msg){
        super(msg);
    }
}