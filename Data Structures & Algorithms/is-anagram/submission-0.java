class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n!=m) return false;
        int[] map = new int[26];

        for(int i = 0;i<n;i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }

       for(int i = 0;i<26;i++){
        if(map[i]!=0) return false;
       }
       return true;
    }
}
