class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] row : matrix){
            for(int arr: row){
                pq.offer(arr);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
        
    }
}