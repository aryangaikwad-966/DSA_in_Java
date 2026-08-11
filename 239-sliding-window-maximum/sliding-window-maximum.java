import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque <Integer> deque = new ArrayDeque<>(); 
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        for(int i =0 ; i<nums.length;i++)  {
            while(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.removeFirst();

            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=k-1)  {
            result[resultIndex]=nums[deque.peekFirst()];
            resultIndex++;
        }  
        } 
        return result;
        
    }
}