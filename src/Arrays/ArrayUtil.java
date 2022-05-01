package Arrays;

public class ArrayUtil {
    public void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo(){
        int[] someArray = new int[5];

        someArray[0] = 5;
        someArray[1] = 10;
        someArray[2] = 15;
        someArray[3] = 20;
        someArray[4] = 25;

        //someArray[7] = 19;
        printArray(someArray);

        int[] arr = {1, 6, 9, 10};
        printArray(arr);
    }

    public static void main(String[] args) {
        ArrayUtil arrUtil = new ArrayUtil();
        arrUtil.arrayDemo();
    }
}
