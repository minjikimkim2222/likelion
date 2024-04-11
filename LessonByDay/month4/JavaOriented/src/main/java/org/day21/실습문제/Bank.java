package org.day21.실습문제;

public class Bank {
    private String bankName; // 은행 이름
    private Account[] accountList; // 은행에 등록된 통장 목록

    public Bank(String bankName, int capacity) {
        this.bankName = bankName;
        this.accountList = new Account[capacity];
    }

    // 통장 개설
    public Account openAccount(String accountNumber, String accountHolderName, int balance) throws BankCapacityExceededException{
        for (int i = 0; i < accountList.length; i++){
            if (accountList[i] == null){ // 배열 순회하다가 빈 배열 발견!
                accountList[i] = new Account(accountNumber, accountHolderName, balance);
                System.out.println("새로운 통장 개설을 성공했습니다!");

                return accountList[i];
            }
        }

        //System.out.println("새로운 통장 개설을 열 수 없습니다. 통장 용량이 가득 차 있습니다!");
        throw new BankCapacityExceededException("새로운 통장 개설을 열 수 없습니다. 통장 용량이 가득 차 있습니다!");

    }

    // 특정 통장 정보 조회
    public void getAccountInfo(String accountNumber) throws AccountNotFoundException{

        for (Account temp : accountList){
            if (temp != null && accountNumber.equals(temp.getAccountNumber())){
                System.out.println("계좌번호 : " + temp.getAccountNumber());
                System.out.println("예금주 이름 : " + temp.getAccountHolderName());
                System.out.println("잔액 : " + temp.getBalance());

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

    public Account[] getAccountList() {
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
