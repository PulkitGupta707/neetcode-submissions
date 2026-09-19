class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int remaining = n;

        for (int i = 0; i < m; i++) {
            int in = s2.charAt(i) - 'a';

            if (freq[in] > 0) {
                remaining--;
            }
            freq[in]--;

            if (i >= n) {
                int out = s2.charAt(i - n) - 'a';
                freq[out]++;

                if (freq[out] > 0) {
                    remaining++;
                }
            }

            if (remaining == 0) {
                return true;
            }
        }

        return false;
    }
}
