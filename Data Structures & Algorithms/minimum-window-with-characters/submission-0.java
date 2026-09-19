class Solution {
    public String minWindow(String s, String t) {
        
        int[] freq = new int[128];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }
        int left=0,right=0,startIndex=0,minLen = Integer.MAX_VALUE;
        int count = t.length();
        while(right<s.length()){
            if(freq[s.charAt(right++)]-- > 0){
                count--;
            }
            while(count==0){
                if(right-left < minLen){
                    minLen=right-left;
                    startIndex = left;
                }
                if(freq[s.charAt(left++)]++ == 0){
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE? new String():new String(s.toCharArray(),startIndex,minLen);
    }
}
