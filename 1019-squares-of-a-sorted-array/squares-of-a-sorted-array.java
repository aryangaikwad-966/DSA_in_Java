class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sq = new int[n];
    int i = 0;
    int j = nums.length-1;
    int k = n-1;
    while(i<=j){
       int left = nums[i]*nums[i];
       int right = nums[j]*nums[j];
        
        if(left>right){
           sq[k]=left;
           i++;
         }
        else{
            sq[k]=right;
            j--;
        }
        k--;
            

        }
       
    
     return sq;

        }
    }
    

       
    
        

        
