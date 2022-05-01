package Arrays;

public class ArrayUtil {
    public void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] createArray(){
        int[] arr = {2, 5, 7 ,3, 9, 15, 32, 0};
        return arr;
    }

    public static int[] removeEvenIntegers(int[] arr){
        int n = arr.length;
        int oddCount = 0;
        for (int i = 0; i < n; i++){
            if(arr[i] % 2 != 0){
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < n; i++){
            if(arr[i] % 2 !=0 ){
                result[idx++] = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayUtil arr = new ArrayUtil();
        int[] result = arr.removeEvenIntegers(arr.createArray());
        arr.printArray(result);
    }
}
