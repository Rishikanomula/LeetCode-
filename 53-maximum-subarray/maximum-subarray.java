class Solution {
    public int maxSubArray(int[] nums) {
        int st[] = new int[nums.length];
        int max = nums[0];
        st[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            st[i]=Math.max(st[i-1]+nums[i], nums[i]);
            if(st[i]>max){
                max=st[i];
            }
        }
        return max;
    }
}