public class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i=0;
        int j=0;
        int maxf=0;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(j<n) {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxf = Math.max(maxf, map.get(s.charAt(j)));
            while((j-i+1)-maxf > k) {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
