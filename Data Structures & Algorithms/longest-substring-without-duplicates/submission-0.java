class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i=0,j=0;
        int maxx = 0;

        while(i<n && j<n) {
            char curr = s.charAt(j);
            if(!set.contains(curr)) {
                set.add(curr);
                j++;
                maxx = Math.max(maxx, j-i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxx;
    }
}
