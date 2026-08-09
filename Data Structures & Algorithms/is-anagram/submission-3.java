class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2) {return false;}
        HashMap<Character,Integer> ms = new HashMap<>();
        HashMap<Character,Integer> mt = new HashMap<>();

        for(int i=0; i<n1; i++) {
            ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i),0)+1);
            mt.put(t.charAt(i), mt.getOrDefault(t.charAt(i),0)+1);
        }
        return ms.equals(mt);
    }
}
