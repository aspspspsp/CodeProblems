package LeetCode.Easy;

/*
atoi �ִ��D����
*/
public class StringToInteger {
    public int myAtoi(String str) {
        //1. ���ִ� �� null ��Y��
        if(str == null || str.length() == 0) {
            return 0;
        }
        
        //2. ȥ���հ�
        str = str.trim();
        
        //3.�����̖ؓ��̎��
        boolean positive = true; //�˔��Ƿ������
        int index = 0;
        if(str.charAt(0) == '+') {
            index = index + 1;
        } else if(str.charAt(0) == '-') {
            positive = false;
            index = index + 1;
        }
        
        //4. �_ʼ�����Ĕ����D�Q
        
        //���double�Ĺ�����int���󣬹�ʹ������������
        double resultForDouble = 0;
        
        //�քe��ÿһλ���M��̎��
        for(int i = index; i < str.length(); i ++) {
            int cur_digi = str.charAt(i) - '0'; //��char�D�Q��int
            
            if(cur_digi < 0 || cur_digi > 9) {
                break;
            }
            
            //̎��������ؓ���Ć��}
            //������̎��
            if(positive == true) {
                //һλһλ�ļ���ȥ
                //123 = 100 + 20 + 3
                resultForDouble = resultForDouble * 10 + cur_digi;
                
                //���˔����^��int���ֵ�t�������ֵ
                if(resultForDouble > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                    
            //ؓ����̎��
            } else {
                //һλһλ�Ĝp��ȥ
                //-123 = -100 - 20 - 3
                resultForDouble = resultForDouble * 10 - cur_digi;
                
                //���˔����^��int��Сֵ�t������Сֵ
                if(resultForDouble < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }
        
        int result = (int)resultForDouble;
        
        return result;
    }
}