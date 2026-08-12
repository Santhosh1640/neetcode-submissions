class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i=0,j=0,maxf=0,maxx=0;

        while(j<n) {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxf = Math.max(maxf, map.get(s.charAt(j)));
            while(j-i+1 - maxf > k) {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            maxx = Math.max(maxx, j-i+1);
            j++;
        }
        return maxx;
    }
}
