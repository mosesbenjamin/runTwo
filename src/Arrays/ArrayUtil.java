package Arrays;

public class ArrayUtil {
    public void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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

    public int findMinimum(int[] arr){
        int n = arr.length;
        if(arr == null || n == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        int min = arr[0];
        for (int i = 1; i < n; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public int findSecondMax(int[] arr){
        int n = arr.length;
        if(arr == null || n==0){
            throw new IllegalArgumentException("Invalid input");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if( arr[i]> secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public int[] moveZeroes(int[] arr){
        int n = arr.length;
        if(arr == null || n==0){
            throw new IllegalArgumentException("Invalid input");
        }
        int j = 0;
        for (int i = 0; i < n; i++){
            if(arr[i] !=0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] !=0){
                j++;
            }
        }
        return  arr;
    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] arr = {0, 35, 0, 6, 6, 0, 8, 23};
        arrayUtil.printArray(arr);
        int[] result = arrayUtil.moveZeroes(arr);
        arrayUtil.printArray(result);
    }
}
