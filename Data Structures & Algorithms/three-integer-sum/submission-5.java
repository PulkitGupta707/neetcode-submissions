class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if(sum<0) left++;
                else right--;
            }

        }
        return ans;
    }
}
