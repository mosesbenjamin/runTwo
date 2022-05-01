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

    public int[] removeEvenIntegers(int[] arr){
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

    public int[] reverseArray(int[] numbers, int start, int end){
        while(start < end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
        return numbers;
    }

    public static void main(String[] args) {
        ArrayUtil arr = new ArrayUtil();
        int[] newArray = arr.createArray();
        arr.printArray(newArray);
        int start = 0;
        int end = newArray.length-1;
        int[] result = arr.reverseArray(newArray, start, end );
        arr.printArray(result);
    }
}
