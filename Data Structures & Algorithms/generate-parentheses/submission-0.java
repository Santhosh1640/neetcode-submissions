class Solution {
    List<String> list = new ArrayList<>();
    public void backtrack(int open, int close, StringBuilder sb) {
        if(open>close) {
            return;
        }

        if(open==0 && close==0) {
            StringBuilder s = new StringBuilder(sb);
            list.add(s.toString());
            return;
        }

        if(open>0) {
            sb.append('(');
            backtrack(open-1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close>0) {
            sb.append(')');
            backtrack(open, close-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }


    }
    public List<String> generateParenthesis(int n) {
        backtrack(n,n,new StringBuilder());
        return list;
        
    }
}
