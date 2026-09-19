class Solution{
public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> dq = new LinkedList<>();
    
    int left = 0;

    for (int right = 0; right < n; right++) {

        // Remove smaller elements from back
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
            dq.pollLast();
        }

        dq.offerLast(right);

        // Remove out of window index from front
        if (dq.peekFirst() < left) {
            dq.pollFirst();
        }

        // When window size is k, record max
        if (right - left + 1 == k) {
            result[left] = nums[dq.peekFirst()];
            left++;
        }
    }

    return result;
}

}
