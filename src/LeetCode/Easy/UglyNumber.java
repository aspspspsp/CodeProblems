package LeetCode.Easy;
public  class UglyNumber {
	public boolean isUgly(int num) {
	    
	    //��num>=2�t�^�m����ֱ��num < 2
	    while(num >= 2) {
	        //���˔���2�N����0
	        if(num % 2 == 0) {
	            //���˔���2
	            num = num / 2;
	        }
	        //���˔���3�N����0
	        else if(num % 3 == 0) {
	            //���˔���3
	            num = num / 3;
	        }
	        //���˔���5�N����0
	        else if(num % 5 == 0) {
	            //���˔���3
	            num = num / 5;
	        }
	        //���˔����������������N���Բ���0(��ʾ�ɱ�����������)�t����ugly number
	        else {
	            return false;
	        }
	    }
	    
	    //���˔������������t��true
	    if(num == 1) {
	        return true;
	    } 
	    //���]���������|���r(����ؓ���r�����ugly numberֻ������)
	    else {
	    	return false;
	    }
	}
}
