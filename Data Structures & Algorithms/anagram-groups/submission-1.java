class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        List<List<String>> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if(map.containsKey(str)) {
                map.get(str).add(strs[i]);
            }
            else {
                map.put(str, new ArrayList<>(List.of(strs[i])));
            }
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()) {
            list.add(entry.getValue());


        }
        return list;
    }
}
