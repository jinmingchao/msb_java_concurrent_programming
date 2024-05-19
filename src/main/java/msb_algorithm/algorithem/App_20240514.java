package msb_algorithm.algorithem;

public class App_20240514 {

    public static void main(String[] args) {
        char[] arr = new char[10];
        int left = 0, cnt = 0, idx = 0;
        while (idx < arr.length) {
            while (left < arr.length && arr[left] != 'B') left++;
            if (left == arr.length) break;
            while (idx < arr.length && arr[left] != 'G') ;
            if (idx == arr.length) break;
            cnt += idx - left;
            swap(arr,idx, left++);
        }
    }

    static void swap(char[] arr, int i1, int i2){
        char tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
