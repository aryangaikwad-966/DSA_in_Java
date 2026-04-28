class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] array = nums.clone();
        Arrays.sort(array);
        int i =0; 
        int j = nums.length-1;
        while(i<nums.length && array[i]==nums[i])
        {
            i++;
        }
        if(i==nums.length)
        return 0;
        while (j >i && nums[j] == array[j]) 
        {
            j--;
        }
       return j-i+1;
    }
}