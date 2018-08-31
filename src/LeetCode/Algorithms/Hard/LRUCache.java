package src.LeetCode.Algorithms.Hard;

import java.util.HashMap;

public class LRUCache {
    /*
    為了使查找、插入與刪除都有較高性能，這題的關鍵是使用一個雙向鏈表和一個HashMap，因為：
    1. HashMap保存每個節點的地址，可以基本保證在O(1)的時間內查找節點
    2. 雙向鏈表能夠在O(1)時間內添加和刪除節點，單鏈表不行
    */
    
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private final HashMap<Integer, Node> map;
    private Node head;
    private Node end;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    //題目會直接操作到
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        
        return -1;
    }
    
    //題目會直接操作到
    public void put(int key, int value) {
        //此節點已經存在
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }
        //此節點不存在
        else {
            Node created = new Node(key, value);
            if(map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            
            map.put(key, created);
        }
    }
    
    public void remove(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        
        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }
    
    private void setHead(Node node) {
        node.next = head;
        node.prev = null;
        
        if(head != null) {
            head.prev = node;
        }
        
        head = node;
        
        if(end == null) {
            end = head;
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */