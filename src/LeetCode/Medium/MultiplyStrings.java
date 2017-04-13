package LeetCode.Medium;
/*
ֱ�ӳ˻����������ÿ�ζ�Ҫ����single digit��ˣ����81�����������
����385 * 97, ���Ǹ�λ=5 * 7��ʮλ=8 * 7 + 5 * 9 ����λ=3 * 7 + 8 * 9 ��
����ÿһλ��һ��Int��ʾ������һ��int[]���档
���������󳤶���num1.len + num2.len������99 * 99����󲻻ᳬ��10000������4λ�͹��ˡ�
���ָ�λ�ں���ģ���������10��0�η�����ϧ��Ӧλ������index����0����n-1����
���Ըɴ��Ȱ�string reverse�˴���������öࡣ
�����ǰ���0Ҫ�����
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		// �����ֵ���(����StringBuilder)
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();

		//�𰸵�λ��
		int digis[] = new int[num1.length() + num2.length()];

		//�քe��ÿһλ���
		for (int i = 0; i < num1.length(); i++) {
			//͸�^�p����char�D�Q��int(-'0'�������p�κΔ���)
			int n1 = num1.charAt(i) - '0';
			for(int j = 0; j < num2.length(); j ++) {
				//͸�^�p����char�D�Q��int(-'0'�������p�κΔ���)
				int n2 = num2.charAt(j) - '0';
				
				//����ѽ������ֶ����^���ˣ�����͸�^n1�cn2Ŀǰ��λ�������Եõ��µĔ���λ��
				digis[i + j] = digis[i + j] + n1 * n2;
				
				//�����ÿһλ����ˣ������Ĕ���81
			}
		}
		
		//��
		StringBuilder ans = new StringBuilder();
		
		//�����ĵ�0λ�_ʼ���؁�
		for(int i = 0; i < digis.length; i ++) {
			//�õ���λ�Ĕ�
			int digi = digis[i] % 10;
			
			//��Ҫ�Mλ�Ĕ�
			int carry = digis[i] / 10;
			
			//�M���Mλ
			if(i < digis.length - 1) {
				digis[i + 1] = digis[i + 1] + carry; 
			}
			
			//�����ֲ����sb.insert(0(offset), "Ҫ����Ė|��");
			ans.insert(0, digi);
		}
		
		//��ǰ������0ȥ��
		while(ans.length() > 0 && ans.charAt(0) == '0') {
			//�h����ǰ���cahr
			ans.deleteCharAt(0);
		}
		
		if(ans.length() == 0)
			return "0";

		return ans.toString();

	}

}
