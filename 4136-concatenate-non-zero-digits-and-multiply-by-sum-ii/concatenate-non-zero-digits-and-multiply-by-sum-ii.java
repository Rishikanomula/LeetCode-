class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007L;
        
        // Precompute powers of 10 modulo 10^9 + 7
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        
        // Prefix arrays
        int[] prefixSum = new int[m + 1];
        int[] prefixCount = new int[m + 1];
        long[] prefixValue = new long[m + 1];
        
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            
            prefixSum[i + 1] = prefixSum[i] + digit;
            
            if (digit != 0) {
                prefixCount[i + 1] = prefixCount[i] + 1;
                prefixValue[i + 1] = (prefixValue[i] * 10 + digit) % MOD;
            } else {
                prefixCount[i + 1] = prefixCount[i];
                prefixValue[i + 1] = prefixValue[i];
            }
        }
        
        int numQueries = queries.length;
        int[] answer = new int[numQueries];
        
        for (int i = 0; i < numQueries; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            // 1. Calculate the sum of digits in the query window
            long sum = prefixSum[r + 1] - prefixSum[l];
            
            // 2. Count the number of non-zero digits in the query window
            int nonZeroDigits = prefixCount[r + 1] - prefixCount[l];
            
            // 3. Extract the integer 'x' formed within the window
            long x = prefixValue[r + 1] - (prefixValue[l] * pow10[nonZeroDigits]) % MOD;
            if (x < 0) {
                x += MOD; // Handle negative result from modular subtraction
            }
            
            // 4. Compute final answer for this query
            answer[i] = (int) ((x * sum) % MOD);
        }
        
        return answer;
    }
}
