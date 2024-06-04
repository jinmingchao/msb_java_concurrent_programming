package algorithm.algorithem;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> storage = new HashMap<>();
    Deque<Integer> lruQueue = new LinkedList<>();
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(storage.containsKey(key)) {
            lruQueue.remove(key);
            lruQueue.offerLast(key);
            return storage.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (storage.containsKey(key)) {
            lruQueue.remove(key);
            lruQueue.offerLast(key);
            storage.put(key, value);
        } else {
            lruQueue.offerLast(key);
            while (lruQueue.size() > capacity) {
                storage.remove(lruQueue.pollFirst());
            }
            storage.put(key, value);
        }
    }

}
