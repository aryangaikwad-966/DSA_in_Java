class Solution {
    public int maxVowels(String s, int k) {
       
        int count  = 0;
        int max = 0;
        for(int i = 0; i < k; i++){
            int c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                count++;
            }
            
        }
         max = count ;
     for ( int i =k ; i < s.length(); i++){
        char left= s.charAt(i-k);
        if (left == 'a' || left == 'e' || left == 'i' || left == 'o' || left == 'u') {
                count--;
            }
         
        char right = s.charAt(i);
            if (right == 'a' || right == 'e' || right == 'i' || right == 'o' || right == 'u') {
                count++;
            }
            max = Math.max(count,max);


     }
     return max;
        
    }
}