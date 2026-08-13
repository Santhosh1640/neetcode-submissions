class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n==1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()) {
            if(map.containsKey(c)) {
                if(!st.isEmpty() && st.peek()==map.get(c)) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
            else {
                st.push(c);
            }
        }

        return st.isEmpty();
    }
}
