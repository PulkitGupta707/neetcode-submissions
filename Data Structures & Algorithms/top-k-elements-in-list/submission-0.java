class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] result = new int[k];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] list = new ArrayList[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int num = entry.getKey();
            int count = entry.getValue();

            if (list[count] == null) {
                list[count] = new ArrayList<>();
            }
            list[count].add(num);
        }
        int index=0;
        for (int count = nums.length; count >= 1 && index < k; count--) {

            if (list[count] == null) {
                continue;
            }

            for (int num : list[count]) {
                result[index++] = num;

                if (index == k) {
                    break;
                }
            }
        }
        return result;
    }
}
