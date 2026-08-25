class LRUCache {
    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        list.remove((Integer) key);
        list.addLast(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            list.remove((Integer) key);
        }
        else if(map.size()==capacity) {
            int lru = list.removeFirst();
            map.remove(lru);
        }
        map.put(key,value);
        list.addLast(key);
    }
}
