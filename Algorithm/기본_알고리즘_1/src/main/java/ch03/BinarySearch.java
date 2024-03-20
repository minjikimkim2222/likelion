package ch03;

public class BinarySearch {

    public static int binarySearch(int[] arr, int key){

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int middle = (low + high) / 2;

            if (arr[middle] == key)
                return middle;
            else if (arr[middle] < key)
                low = middle + 1;
            else // arr[middle] > key
                high = middle - 1;
        }
        return -1; // 찾는 키 값이 없다면
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 5, 8, 11, 12, 15};

        int idx = binarySearch(sortedArray, 12);

        System.out.println("12 key 값의 인덱스 : " + idx);

    }
}
