package Coding;

public class KadaneAlgorithm {
    public int maxSubArraySum(int[] arr){
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < arr.length; i++){
            // Math.max(currentMax + arr[i], arr[i]) is a shortcut for 1) and 2)
            currentMax = currentMax + arr[i]; // 1) should be part of sub-array?
            if(currentMax < arr[i]){ // 2) should form a new sub-array?
                currentMax = arr[i];
            }
            if(maxSoFar < currentMax){
                maxSoFar = currentMax;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        KadaneAlgorithm ka = new KadaneAlgorithm();
        int[] arr = {4,3,-2,6,-12,7,-1,6};
        System.out.println(ka.maxSubArraySum(arr));
    }
}
