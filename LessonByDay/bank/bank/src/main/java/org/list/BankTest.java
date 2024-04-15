package org.list;


public class BankTest {
    public static void main(String[] args) {

        // 1, Bank test
        Bank bank = new Bank("국민"); // 국민은행 -> 3개의 계좌를 등록할거다!
        Account account1 = null;
        Account account2 = null;
        Account newAccount = null;
        try {
            account1 = bank.openAccount("01-111", "minjiki2", 1000);
            account2 = bank.openAccount("01-222", "minjiki2", 3000);
            newAccount = bank.openAccount("012-111", "minjiki2", 1000);
            // capacity를 3으로 했던 array에서는 2개만 만들었지만,
            // 가변 크기의 ArrayList에서는 2개든 3개든, Integer.MAX_VALUE값만 안 넘기면 된다!
        } catch (BankCapacityExceededException e){
            System.out.println(e.getMessage());
        }


        try {
            bank.getAccountInfo("01-222");
            // 만일 없는 계좌 정보 조회했다면? - 예외 처리 잘 했는지
            bank.getAccountInfo("01-333");
        } catch (AccountNotFoundException e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

        System.out.println("*****************" + "\n");
        // 2. Account Test
        account1.deposit(500);
        System.out.println("account1의 계좌 잔액 : " + account1.getBalance());
        account2.deposit(100);
        System.out.println("account2의 계좌 잔액 : " + account2.getBalance());
        try {
            account1.withdrawal(1000);
            account2.withdrawal(4000); // 잔액보다 더 큰 금액을 인출한다면? 예외처리는?
        } catch(InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("*****************" + "\n");
        // 3. 은행원 Banker
        Banker banker = new Banker("siwon", 54);
        Account account3 = null;
        try{
            account3 = banker.approveOpenAccount(bank,"01-333", "minjiki2", 5000);
            // bank capacity가 3개인데, 그이상의 계좌를 할당하면 예외발생처리해줘야 함!!! (array) -> 가변 크기의 ArrayList에서는 계좌 개설 성공!
            banker.approveOpenAccount(bank, "01-444", "minjiki2", 1000);
        } catch (BankCapacityExceededException e){
            System.out.println(e.getMessage());
        }


        try {
            banker.approveWithdrawal(account3, 3000); // 5000에서 3000을 인출
            System.out.println(account3.getBalance()); // 남은 잔액 2000 이겠지
            banker.approveWithdrawal(account3, 3000); // 2000에서 3000 빼면 에외가 발생해야 해요!
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }

    }
}

