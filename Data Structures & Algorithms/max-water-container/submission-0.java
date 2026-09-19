class Solution {
    public int maxArea(int[] heights) {
    int n = heights.length;
    int left =0;
    int right = n-1;
    int max = 0;
    while (left < right) {
        max = Math.max(max,
            Math.min(heights[right],heights[left])*(right-left));
            if(heights[left] <= heights[right]) left++;
            else right--;
        }
        return max;
    }
}
