class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxFreq = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }

        int cnt = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                cnt++;
            }
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + cnt);
    }
}