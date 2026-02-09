class Solution {
    public void duplicateZeros(int[] arr) {
        int target = 0;
        
        int[] newArr = new int[arr.length];
        int j = 0;
        for(int i=0;i<arr.length && j<newArr.length;i++){
            newArr[j++]=arr[i];
           
            if(arr[i]==target && j<newArr.length){
                newArr[j++]=arr[i]; 
              
            }
        }
        for(int i =0;i<arr.length;i++){
            arr[i]=newArr[i];
        }
        
    }
}