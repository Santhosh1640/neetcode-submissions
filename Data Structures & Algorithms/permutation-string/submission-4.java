class Solution {
    public boolean isSubstring(String s1, String s2) {
        int n = s1.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<n; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
        }
        return map1.equals(map2);
    }
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        // Edge case
        if(n1>n2) {return false;}
        int i = 0;

        while(i<n2-n1+1) {
            String sub = s2.substring(i, i+n1);
            System.out.println(sub);
            if(isSubstring(s1,sub)) {return true;}
            i++;
        }
        return false;
    }
}
