//��λ����
public class ShiftingBits {
	public static void main(String args[]) {
		
		int a = 1;
		System.err.println(a << 1);

	}
	
	//���g��λ����n�����Ƅ�iλ(�Ƅ�һλ���ǳ�2����λ��4)����ؓ��׃
	static int rightArthmeticShifting(int n, int i) {
		return n >> i;
	}
	
	//���g��λ����n�����Ƅ�iλ������׃��ؓ׃��(�Ƅӕr������1λ�a0)
	static int rightLogicalShifting(int n, int i) {
		return n >>> i;
	}
	
	//���g��λ����n�����Ƅ�iλ(�Ƅ�һλ���ǳ�2����λ��4)����ؓ��׃
	static int leftArthmeticShifting(int n, int i) {
		return n << i;
	}
		
	//�K�]�Ќ�n�����Ƅ�(߉݋��λ)
}
