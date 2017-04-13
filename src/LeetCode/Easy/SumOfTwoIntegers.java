package LeetCode.Easy;

public class SumOfTwoIntegers {	
	// a ^ b ֱ�����a + b ÿλ��mod 2��Ľ���� ��λ�Ļ�����ֱ�� (a & b)<<1�õ���ֻ������λ��Ϊ1�Ż��λ����Ʊ�ʾ������һλ����
	//�@�}�����ö��Mλ�ķ�ʽ���M���\��
	public int getSum(int a, int b) {
		
		//�\�е�b == 0 ��ֹ(�Զ��M�Ʒ�ʽ����ÿһλ���M�мӜp)
		while(b != 0) {
			//a mod b(�Mλ��Ĕ�)
			int c = a & b; 
			
			//��a�cb�M��xor�\��(�ӷ�)
			a = a ^ b;
			
			//��a mod b �ĽY������һλ(�Mλ)����a mod b�ĽY����0�t���Mλ
			b = c << 1;
		}
		
		return a;
	}
}
