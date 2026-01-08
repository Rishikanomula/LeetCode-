class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0'){
            return 0;
        }
        // if((s.length()==1 && s.charAt(0)=='1')) return 1;
        int n=s.length();
        // int[] dp = new int[n+1];
        // dp[0]=1;
        int a=1;
        // dp[1]=s.charAt(0) != '0' ? 1 : 0;
        int b=1;
        int c=0;
        for(int i=2; i<= n; i++){
            c=0;
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));

            if(first>=1 && first<=9){
                // dp[i]+=dp[i-1];
                c+=b;
            }
            if(second>=10 && second<=26){
                // dp[i]+=dp[i-2];
                c+=a;
            }
            a=b;
            b=c;
        }
        // return dp[n];
        return b;
    }
}