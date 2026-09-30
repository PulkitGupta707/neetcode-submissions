class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        calculate(nums,result,new ArrayList<>(),0);
        return result;
    }
    private void calculate(int[] nums,List<List<Integer>>result,List<Integer> current,int start){
        if(result.contains(current)) return;
        result.add(new ArrayList<>(current));
        for(int i = start ; i<nums.length;i++){
            current.add(nums[i]);
            calculate(nums,result,current,i+1);
            current.remove(current.size()-1);
        }
    }
}
