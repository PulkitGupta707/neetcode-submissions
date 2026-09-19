class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int right = 0;
        while(right < nums.length){
           sum+=nums[right];
           while(sum>=target){
               ans=Math.min(ans,right-left+1);
               sum-=nums[left++];
           }
           right++;
        }
        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        return ans;
    }
}