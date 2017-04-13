package LeetCode.Medium;
/*
���޿����Ȿ������һ������ͼ
������ͼ�޻�:���ǿ��Ը�������������������нڵ�
������ͼ�л�:�����������޷���ɣ��������Ľڵ㽫�����ܽڵ�������Ϊ�еĽڵ��ǹµ���

���E:
1.�ȸ��ݱߵĹ�ϵ����һ��ͼ��������ÿ���ڵ����ȣ������õ�����������ͼ��
2.�����Ϊ0�Ľڵ㣬Ҳ������ڿ�ʼ��������������������������˳�����
3.���������Ľڵ������ܽڵ����Ĺ�ϵ�����ˡ�
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    //�����n��(prerequisites[i][0])
    //�����n�̵������n��(prerequisites[i][1])
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //�D
        ArrayList[] graph = new ArrayList[numCourses];
        //���ָ����ͼ��ĳ����Ϊͼ�бߵ��յ�Ĵ���֮�͡�
        //(��ĳ�c����K�c�ĴΔ�֮��)
        //��Ȕ��M
        int[] inDegrees = new int[numCourses];
        
        //�ȳ�ʼ���D��ÿ���x����б�
        for(int i = 0; i < numCourses; i ++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        //����߅�����D���KӋ��ÿ�������n�̵����
        for(int i = 0; i < prerequisites.length; i ++) {
            //�������n�̵������n���c�����n���B������
            //[0,1]Ҫ��0�������1����1->0
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            
            //Ӌ��ÿ�������n�̵����
            //���:1->0����
            //0���: 1(����K�c)
            //1���: 0
            inDegrees[prerequisites[i][0]] ++;
        }
        
        //�ҵ�����D�����(���кܶ����)�����D�е�ÿ���c��(pair)��һ�����B
        Queue<Integer> entrances = new LinkedList<Integer>();
        for(int i = 0; i < inDegrees.length; i ++) {
            //���Ϊ0ָ����ͼ�еĵ㲻��Ϊ�καߵ��յ㣬
            //Ҳ����˵����һ�������ӵı߶�����һ����Ϊ��㡣
            if(inDegrees[i] == 0) {
                entrances.add(i);
            }
        }
        
        //�ؘ����򷽷�:
        /*
        1.�� DAG ͼ��ѡ��һ�� û��ǰ���������Ϊ0���Ķ��㲢�����
        2.��ͼ��ɾ���ö������������Ϊ��������ߡ�
        3.�ظ� 1. �� 2. ֱ����ǰ�� DAG ͼΪ�ջ�ǰͼ�в�������ǰ���Ķ���Ϊֹ��
        ��һ�����˵������ͼ�б�Ȼ���ڻ���
        
        * �������潲�ķ��������ǹؼ���Ҫά��һ�����Ϊ0�Ķ���ļ��ϡ�
        */
        
        //�������������˳�򣬽��й����������
        int counter = 0;
        while(entrances.isEmpty() == false) {
            //�� DAG ͼ��ѡ��һ�� û��ǰ���������Ϊ0���Ķ���
            Integer cur = entrances.poll();
            counter ++;
            
            //��ͼ��ɾ���ö������������Ϊ��������ߡ�
            ArrayList<Integer> nexts = graph[cur];
            for(int i = 0; i < nexts.size(); i ++) {
                // ������curָ������ж������ȼ�1
                int next = nexts.get(i);
                inDegrees[next] --;
                
                // ������ȼ�Ϊ0�Ķ�����ջ
                //(���Ҫ�_���D�в�������ǰ���Ķ��㣬�ʌ�ԓ�c�뗣�M����һ�εĚv��)
                if(inDegrees[next] == 0) {
                    entrances.offer(next);
                }
            }
        }
        
        // û�����ȫ�����㣬����ͼ���л�·
        if(numCourses > counter) {
            return false;
            
        // ��������ɹ�
        } else {
            return true;
        }
    }
}