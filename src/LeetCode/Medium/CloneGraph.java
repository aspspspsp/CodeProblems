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
        
        //�@�����Á탦��clone�^�ĈD�ĽY��(Ҳ��clone�^�ĈD�ĵ�һ���Y�c)
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        
        //��һ��Map�����ѽ���¡���½Y�c
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(node.label, clone);
        
        //��һ����Ё���]���L���^�ĽY�c
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node); //�ѵ�һ���Y�c������Ю���(���Ȱ��L)
        
        while(queue.isEmpty() == false) {
            //���L�r���Ȍ�����еĵ�һ��ȡ����(ԭ���ĈD)
            UndirectedGraphNode originalNode = queue.remove();
            
            //���ڿ�¡���c
            UndirectedGraphNode cloneNode = map.get(originalNode.label);
            
            //���L�@���c����������
            for(int i = 0; i < originalNode.neighbors.size(); i ++) {
                //�����ڰ��L���c������ȡ��
                UndirectedGraphNode neighbor = originalNode.neighbors.get(i);
                
                //���ԓ���ӽY�c�ѽ�����¡
                if(map.get(neighbor.label) != null) {
                    //�����cԓ���c��߅
                    cloneNode.neighbors.add(map.get(neighbor.label));
                    //���M���������
                    continue;
                }
                
                //�����ӷ���queue��
                queue.add(neighbor);
                
                //��¡ԓ���ӽY�c
                UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                
                //���½Y�c����map��
                map.put(neighbor.label, newNode);
                
                //���½Y�c�������Ӽ���
                cloneNode.neighbors.add(newNode);
            }
        }
        
        //�����}�u�D�ĵ�һ���Y�c
        return clone;
    }
}