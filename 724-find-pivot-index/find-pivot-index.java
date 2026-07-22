class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int [] prefix = new int[n];
        int [] suffix = new int[n];
         prefix[0]= nums[0];

        for( int i = 1; i<n ; i ++){
            prefix[i] = prefix[i-1]+ nums[i];
        }
        suffix[n-1]= nums[n-1];
            for( int j = n-2; j>=0 ; j --){
            suffix[j] = suffix[j+1] + nums[j];

        }
        for(int i = 0 ; i<n; i++){
            int left = (i==0) ? 0 : prefix[i-1];
            int right = (i==n-1) ? 0 : suffix [i+1];

      
        if(left==right){
            return i;
        }
        }

        return -1;
        
        
    }
}