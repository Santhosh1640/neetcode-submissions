class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i=0,j=0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        while(j<n) {
            char c = s.charAt(j);
            if(!set.contains(c)) {
                set.add(c);
                j++;
                ans = Math.max(ans, j-i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
            
        }
        return ans;
    }
}
