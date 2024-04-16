package org.set_map;

public class BankTest {
    public static void main(String[] args) {

        // 1. Bank test
            // HashSet으로 변경한 만큼, 1개의 Bank 객체에 동일한 Account 객체 개설 못하는 것 확인하기
        Bank bank = new Bank("신한");
        Account account1 = null;
        Account account2 = null;
        Account account3 = null;

        try {
            // 계좌 개설 시도
            account1 = bank.openAccount("111", "minjiki2", 1000);
            account2 = bank.openAccount("222", "minjiki2", 2000);

            // 중복된 계좌번호로 개설 시도 (예외 발생)
            account3 = bank.openAccount("111", "mk", 2000);

        } catch (BankCapacityExceededException | AccountAlreadyExistsException e) {
            System.out.println("예외 발생: " + e.getMessage()); // 예외 메시지 출력
        } finally {
            // finally 블록은 항상 실행됨
            System.out.println("모든 작업 완료"); // 마무리 메시지 출력
        }


        // 특정 통장 정보 조회 시도
        try {
            bank.getAccountInfo("111"); // 존재하는 계좌번호 조회
            bank.getAccountInfo("333"); // 존재하지 않는 계좌번호 조회
        } catch (Exception e){
            e.printStackTrace();
        }

        // 2. BankerManager 테스트
        BankerManager bankerManager = new BankerManager();

        // addBanker
        bankerManager.addBanker(new Banker("minjiki2", 1));
        bankerManager.addBanker(new Banker("yong", 2));
        bankerManager.addBanker(new Banker("hyun", 3));

        // findBanker
        try {
            bankerManager.findBanker(1);
            bankerManager.findBanker(4);
        } catch (Exception e){
            e.printStackTrace();
        }

        // deleteBanker

        try {
            bankerManager.deleteBanker(1);
        } catch (Exception e){
            e.printStackTrace();
        }

        bankerManager.printAllBanker();

    }
}

