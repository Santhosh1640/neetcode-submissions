class Solution {
    public void backtrack(String digits, StringBuilder sb, int ind, List<String> list, String[] map) {
        if(ind==digits.length()) {
            list.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(ind)-'0'];

        for(char ch:letters.toCharArray()) {
            sb.append(ch);
            backtrack(digits, sb, ind+1, list, map);
            sb.deleteCharAt(sb.length()-1);

        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0) {
            return list;
        }
        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, new StringBuilder(), 0, list, map);
        return list;
    }
}
