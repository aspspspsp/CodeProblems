package src.LeetCode.Algorithms.Medium;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0)
            return 0;

        // ���Q��"\n"�����ΡA�N���|���Ҧ���Ƨ��Τ��ɦW�٤��ΥX��
        String[] lines = input.split("\n");

        int max_length = 0; // �O�����|�̤j����
        int[] dp = new int[input.length() + 1]; // �O���Ҧ��`�ת����|����

        // ���M�Ҧ���Ƨ��Τ���
        for(String line : lines) {
            /*
            lastIndexOf�O�O���Ӥ�r�̫�X�{�����ޡA
            �ڭ̧Q�γo�ӯS�ʨӰO���ثe���ɩҳB�󪺸�
            �|�`��
            */
            int level = line.lastIndexOf("\t") + 2; // �O����e�ؿ��`��
            int len = line.length() - (level - 1); // �O����e�ɮצW�٩άO��󧨦W�٪���

            // �Y��e�W�٬�"����"�A�ڭ̫h�}�l������O�_���̤j����
            if(line.contains(".") == true) {
                max_length = Math.max(max_length, dp[level - 1] + len);
            }
            // �Y���O���ɡA�h�O����e���|�W�٪���
            else {
                dp[level] = dp[level - 1] + len + 1; // +1�N��"/"������
            }
        }

        return max_length;
    }
}
