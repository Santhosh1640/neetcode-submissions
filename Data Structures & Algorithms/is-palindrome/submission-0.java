class Solution {
    public boolean isPalindrome(String s) {
        String str1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder strb = new StringBuilder(str1);
        String str2 = strb.reverse().toString();
        boolean ans = str1.equals(str2) ?true : false;

        return ans;
    }
}
