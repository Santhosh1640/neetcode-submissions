class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i=0,j=0;
        Set<Character> set = new HashSet<>();
        int maxx = 0;

        while(j<n) {
            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            maxx = Math.max(maxx, j-i+1);
            set.add(s.charAt(j));
            j++;
        }
        return maxx;
    }
}
