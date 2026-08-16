class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(String s:tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                if(s.equals("+")) {
                    st.push(a+b);
                    System.out.println(st.peek());
                }
                else if(s.equals("-")) {
                    st.push(b-a);
                    System.out.println(st.peek());
                }
                else if(s.equals("*")) {
                    st.push(a*b);
                    System.out.println(st.peek());

                }
                else if(s.equals("/")){
                    st.push(b/a);
                    System.out.println(st.peek());
                }
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
