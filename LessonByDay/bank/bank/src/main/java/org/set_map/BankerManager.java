package org.set_map;

import java.util.HashMap;
/*
    HashMap을 이용해 Bank 관리 (BankerManager 클래스 추가)

    - Banker 객체의 bankerId를 키로 사용해 Banker객체를 HashMap으로 관리!
    - addBanker, findBanker, deleteBanker 기능 추가

 */
public class BankerManager {
    private HashMap<Integer, Banker> bankerManager;

    public BankerManager() {
        bankerManager = new HashMap<>();
    }

    public void addBanker(Banker banker){
        System.out.println("새로운 banker가 bankerManager에 추가되었습니다.");
        bankerManager.put(banker.getBankerId(), banker);
    }

    public void findBanker(int bankerId) throws BankerNotFoundException{
        if (!bankerManager.containsKey(bankerId)){
            throw new BankerNotFoundException("해당 banker는 존재하지 않습니다.");
        }

        Banker banker = bankerManager.get(bankerId);
        System.out.print("banker id : " + banker.getBankerId());
        System.out.print(" ,banker name : " + banker.getBankerName());
        System.out.println();
    }

    public void deleteBanker(int bankerId) throws BankerNotFoundException{
        if (!bankerManager.containsKey(bankerId)){
            throw new BankerNotFoundException("해당 banker는 존재하지 않습니다.");
        }
        bankerManager.remove(bankerId);
    }

    public void printAllBanker(){
        if (bankerManager.isEmpty()){
            System.out.println("어떠한 banker list도 존재하지 않습니다.");
            return ;
        }
        System.out.println("*****모든 banker의 정보를 출력합니다.*******");
        for (Banker banker : bankerManager.values()){
            System.out.print("banker id : " + banker.getBankerId());
            System.out.print(" , banker name : " + banker.getBankerName());
            System.out.println();
        }
    }

}

class BankerNotFoundException extends Exception {
    public BankerNotFoundException(String msg){
        super(msg);
    }
}