package org.day24;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBookEx {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("철수", "010-1234-5678");
        phoneBook.put("영희", "010-8765-4321");
        phoneBook.put("민지", "010-5566-7788");

        // 특정 키를 이용해 전화번호 검색
        String minjiPN = phoneBook.get("민지");
        System.out.println("minji phone number : " + minjiPN);

        // 전체 전화번호 목록 출력 - Map 인터페이스의 내부 인터페이스인 entrySet 이용
        System.out.println("전체 전화번호 목록 : ");
        for (Map.Entry<String,String> entry : phoneBook.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
            /*
                Entry<K,V> 인터페이스는 HashMap에서 implments하고 있다!
             */
        // 데이터 삭제
        phoneBook.remove("민지");

        System.out.println("전체 전화번호 목록 : ");
        Set<String> keySet = phoneBook.keySet();

        for (String key : keySet){
            System.out.print("key : " + key);
            System.out.print(" value : " + phoneBook.get(key));
            System.out.println();
        }

        // 특정 key 존재 여부 확인
        if (phoneBook.containsKey("민지") == false){
            System.out.println("키 값인 민지는 존재하지 않습니다.");
        }

        // 특정 value 값 존재 여부 확인
        if (phoneBook.containsValue("010-1234-5678")){
            System.out.println("철수 key에 대응되는 value 값은 " + phoneBook.get("철수") + "입니다!");
        }

        // 비었는지 확인
        System.out.println("비었나요? " + phoneBook.isEmpty());

        // Map 크기 확인
        System.out.println(phoneBook.size());
    }
}
