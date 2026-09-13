class TimeMap {

    Map<String, TreeMap<Integer,String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        TreeMap<Integer, String> treeMap = map.get(key);
        Integer value = treeMap.floorKey(timestamp);
        if(value==null) return "";
        return treeMap.get(value);
    }
}
