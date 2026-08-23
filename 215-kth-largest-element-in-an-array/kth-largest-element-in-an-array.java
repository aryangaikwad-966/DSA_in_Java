class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int arr:nums){
            pq.offer(arr);
            if(pq.size()>k){
                pq.poll();
            }
            
        }
        int kthLargest = pq.peek();
        return kthLargest;
        
    }
}