package src.LeetCode.Algorithms.Easy;

public class DesignLinkedList {
    class Entry {
        int val;
        Entry next;
        public Entry() {}
        public Entry(int val) {
            this.val = val;
        }
    }

    Entry head = null;
    int size;

    /** Initialize your data structure here. */
    public DesignLinkedList() {
        head = new Entry();
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0)
            return -1;

        Entry cur = head;
        for(int i = 0; i <= index; i ++)
            cur = cur.next;

        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Entry _new = new Entry(val);
        if(head.next == null)
            head.next = _new;
        else {
            _new.next = head.next;
            head.next = _new;
        }

        size ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Entry _new = new Entry(val);
        Entry cur = head;
        while(cur.next != null)
            cur = cur.next;

        cur.next = _new;
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size || index < 0)
            return;
        if(size == index) {
            addAtTail(val);
            return;
        }

        // 將指標移到要加入的位置之前
        Entry cur = head;
        for(int i = 0; i < index; i ++)
            cur = cur.next;

        // 將要加入節點插入
        Entry _new = new Entry(val);
        _new.next = cur.next;
        cur.next = _new;

        size ++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0)
            return;

        // 將指標移到要刪除的節點之前
        Entry cur = head;
        for(int i = 0; i < index; i ++)
            cur = cur.next;

        // 刪除節點(將要刪除的節點之前的節點與之後的節點連起來)
        Entry del = cur.next;
        cur.next = del.next;

        // 斷掉預刪除結點與之後結點
        del.next = null;

        size --;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
