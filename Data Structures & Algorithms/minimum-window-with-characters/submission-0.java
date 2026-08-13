class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character, Integer> map = new HashMap<>();
        int i=0,j=0,cnt=0;

        for(int x = 0; x < m; x++) {
            if(map.containsKey(t.charAt(x))) {
                map.put(t.charAt(x), map.get(t.charAt(x)) + 1);
            }
            else {
                map.put(t.charAt(x), 1);
                cnt++;
            }
        }

        int min = Integer.MAX_VALUE;
        StringBuilder ans = new StringBuilder();

        while(j<n) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) cnt--;
            }

            if(cnt==0) {
                while(cnt==0) {
                    if(map.containsKey(s.charAt(i))) {
                        if(map.get(s.charAt(i))<0) {
                            map.put(s.charAt(i), map.get(s.charAt(i))+1);
                        }
                        else if(map.get(s.charAt(i))==0) {
                            if(j-i+1 < min) {
                                min = j-i+1;
                                ans.setLength(0);
                                for(int x=i; x<j+1; x++) {
                                    ans.append(s.charAt(x));
                                }
                            }
                            map.put(s.charAt(i), map.get(s.charAt(i))+1);
                            if(map.get(s.charAt(i))==1) {
                                cnt++;
                            }
                        }
                    }
                    i++;
                }
            } 
            j++;
        }
        return ans.toString();
    }
}
