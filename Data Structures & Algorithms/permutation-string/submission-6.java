class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int[] freq = new int[26];

        for(char c:s1.toCharArray()) {
            freq[c-'a']++;
        }

        for(int i=0; i<n2; i++) {
            char c = s2.charAt(i);
            freq[c-'a']--;

            if(i>=n1) {
                freq[s2.charAt(i-n1)-'a']++;
            }

            if(allZero(freq)) return true;

        }
        return false;
    }

    public boolean allZero(int[] freq) {
        for(int n:freq) {
            if(n!=0) {
                return false;
            }
        }
        return true;
    }
}
