class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return calculate(nums,result,new ArrayList<>(),0);

    }
    private List<List<Integer>> calculate(int[] nums,List<List<Integer>>result,List<Integer> current,int start){
        result.add(new ArrayList<>(current));
        for(int i = start ; i<nums.length;i++){
            current.add(nums[i]);
            calculate(nums,result,current,i+1);
            current.remove(current.size()-1);
        }
        return result;
    }
}
