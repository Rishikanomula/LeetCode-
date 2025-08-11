class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        int i=2;
        while((long)i*i<=x){
            i+=1;
        }
        int res = i-1;
        return Math.round(res);
    }
}