package ch03;

public class SequentialSearch {

    public static int sequentialSearch(int[] arr, int key){

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == key)
                return i;
        }

        return -1; // 키를 못 찾으면, -1 리턴
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,66,44,3,22};

        int idx = sequentialSearch(arr, 44);

        if (idx == -1){
            System.out.println("찾고자 하는 데이터는 배열에 존재하지 않습니다.");
        }
        else {
            System.out.println("찾고자 하는 데이터는 " + idx + "번째 인덱스에 존재합니다.");
        }
    }

}
