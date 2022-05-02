package Coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            if(!map.containsKey(target - numbers[i])){
                map.put(numbers[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("Two numbers not found");
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] numbers = { 2,3,5,1,3 };
        System.out.println(Arrays.toString(ts.twoSum(numbers, 7)));
    }
}
