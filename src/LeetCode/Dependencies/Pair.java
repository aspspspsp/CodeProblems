package src.LeetCode.Dependencies;

public class Pair implements Comparable<Pair> {
    public int row; //行
    public int column; //列
    public int value; //ֵ值

    public Pair(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        return this.value - other.value;
    }
}