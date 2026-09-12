class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        int n = s.length();

        while(start<=end) {
            if(s.charAt(start++)!=s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
    public void backtrack(String s, int ind, List<String> sub, List<List<String>> list) {
        //Base case
        if(ind==s.length()) {
            list.add(new ArrayList<>(sub));
            return;
        }

        for(int i=ind; i<s.length(); i++) {

            if(!isPalindrome(s,ind,i)) {
                continue;
            }
            sub.add(s.substring(ind,i+1));
            //Pass the left out substring to next recursion call
            backtrack(s, i+1, sub, list);
            sub.remove(sub.size()-1);
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), list);
        return list;
    }
}
