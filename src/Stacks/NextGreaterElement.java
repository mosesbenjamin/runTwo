package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
        public int[] nextGreaterElement(int arr[]){
            int[] result = new int[arr.length];
            java.util.Stack<Integer> stack = new Stack<>();
            for (int i = arr.length - 1; i >=0; i--){
                if(!stack.isEmpty()){
                    while (!stack.isEmpty() && stack.peek() <= arr[i]){
                        stack.pop();
                    }
                }
                if(stack.isEmpty()){
                    result[i] = -1;
                }else {
                    result[i] = stack.peek();
                }
                stack.push(arr[i]);
            }
            return result;
        }

        public static void main(String[] args) {
            NextGreaterElement instance = new NextGreaterElement();
            int[] arr = {4, 7, 3, 4, 8, 1};
            int[] result = instance.nextGreaterElement(arr);
            System.out.println(Arrays.toString(result));
        }
}
