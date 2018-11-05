package src.LeetCode.Algorithms.Dependencies;

public class DoubledLinkedNode {
    public int val;
    public DoubledLinkedNode prev;
    public DoubledLinkedNode next;
    public DoubledLinkedNode child;

    public DoubledLinkedNode() {}

    public DoubledLinkedNode(
            int _val,
            DoubledLinkedNode _prev,
            DoubledLinkedNode _next,
            DoubledLinkedNode _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}