package LeetCode.Medium;

import java.util.HashMap;
import java.util.LinkedList;

import LeetCode.Dependencies.UndirectedGraphNode;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        
        //這個是用來儲存clone過的圖的結果(也是clone過的圖的第一個結點)
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        
        //用一個Map來保存已經克隆的新結點
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(node.label, clone);
        
        //用一個隊列來保存沒有訪問過的結點
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node); //把第一個結點放入隊列當中(首先拜訪)
        
        while(queue.isEmpty() == false) {
            //拜訪時都先將隊列中的第一個取出來(原本的圖)
            UndirectedGraphNode originalNode = queue.remove();
            
            //正在克隆的點
            UndirectedGraphNode cloneNode = map.get(originalNode.label);
            
            //拜訪這個點的所有鄰居
            for(int i = 0; i < originalNode.neighbors.size(); i ++) {
                //將正在拜訪的點的鄰居取出
                UndirectedGraphNode neighbor = originalNode.neighbors.get(i);
                
                //如果該鄰居結點已經被克隆
                if(map.get(neighbor.label) != null) {
                    //加入與該節點的邊
                    cloneNode.neighbors.add(map.get(neighbor.label));
                    //不進行下面動作
                    continue;
                }
                
                //把鄰居放入queue中
                queue.add(neighbor);
                
                //克隆該鄰居結點
                UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                
                //把新結點放入map中
                map.put(neighbor.label, newNode);
                
                //把新結點加入鄰居集中
                cloneNode.neighbors.add(newNode);
            }
        }
        
        //返回複製圖的第一個結點
        return clone;
    }
}