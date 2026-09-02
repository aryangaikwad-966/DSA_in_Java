class Solution {
    public double myPow(double x, int n) {
        long power  = n;
        if(n<0){
             double result = 1 / Math.pow(x,-power) ;
            return result;
        }
        
      double result = Math.pow(x,power) ;
       return result;
     
        
    }
 
   
}