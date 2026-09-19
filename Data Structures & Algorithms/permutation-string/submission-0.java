class Solution {
    public boolean checkInclusion(String s, String l) {
        // l = long string, s = short string

        int sLen = s.length(), lLen = l.length();

        if (sLen > lLen) return false;

        int[] smap = new int[26];
        int[] lmap = new int[26];

        for (char c : s.toCharArray()) {
            smap[c - 'a']++;
        }

        for (int i = 0; i < lLen; i++) {
            // adding to the right of window
            lmap[l.charAt(i) - 'a']++;

            // removing from left of window
            if (i >= sLen) {
                lmap[l.charAt(i - sLen) - 'a']--;
            }

            if (Arrays.equals(smap, lmap)) return true;
        }

        return false;
        
    }
}

