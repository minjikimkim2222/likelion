package org.day24.실습코드.도시_인구_관리_시스템;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationManager {
    //알맞게 구현해 주세요. - key - value 쌍의 HashMap 사용
    private HashMap<String, Integer> populationManager;

    public PopulationManager(){
        populationManager = new HashMap<>();
    }

    public void addOrUpdateCity(String cityName, int population){
        populationManager.put(cityName, population);
    }
    private void removeCity(String cityName) {
        if (!isCityRemain(cityName)){
            System.out.println("해당 도시는 존재하지 않습니다.");
            return ;
        }
        populationManager.remove(cityName);
    }

    public boolean isCityRemain(String cityName){
        return populationManager.containsKey(cityName);
    }
    private void displayPopulation(String cityName) {
        if (!isCityRemain(cityName)){
            System.out.println("해당 도시는 존재하지 않습니다.");
            return ;
        }
        System.out.println("도시명 : " + cityName + ", 인구수 : " + populationManager.get(cityName));
    }

    private void displayAll() {
        if (populationManager.isEmpty()){
            System.out.println("어떤 도시도 존재하지 않습니다.");
            return ;
        }
        System.out.println("*******모든 도시와 인구*********");
        for (Map.Entry<String,Integer> entry : populationManager.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.println("명령을 입력하세요 (추가/수정, 삭제, 조회, 전체 조회, 종료): ");
            String command = scanner.nextLine(); // next() 대신 nextLine() 사용

            if (command.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case "추가/수정":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine(); // next() 대신 nextLine() 사용
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    scanner.nextLine(); // 버퍼 비우기
                    break;
                case "삭제":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine(); // next() 대신 nextLine() 사용
                    manager.removeCity(city);
                    break;
                case "조회":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine(); // next() 대신 nextLine() 사용
                    manager.displayPopulation(city);
                    break;
                case "전체 조회":
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();
    }



}
