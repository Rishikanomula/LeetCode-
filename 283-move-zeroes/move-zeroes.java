class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length-1;
        if(nums.length==1) return;
        int nonZero=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0){
                nums[nonZero]=nums[i];
                nonZero++;
            }
        }
        while(nonZero<nums.length){
            nums[nonZero]=0;
            nonZero++;
        }
    }
}