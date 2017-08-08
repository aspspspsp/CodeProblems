package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        
        //這個是用來存儲dna的數量
        HashMap<String, Integer> dna_seqs = new HashMap<>();
        
        //從前面開始掃描
        for(int i = 0; i <= s.length() - 10; i ++) {
            //10個dna片段的子序列
            String cur_dna_seq = s.substring(i, i + 10);            
            if(dna_seqs.get(cur_dna_seq) == null) {
                dna_seqs.put(cur_dna_seq, 1);
            } else {
                int dna_size = dna_seqs.get(cur_dna_seq);
                dna_seqs.put(cur_dna_seq, dna_size + 1);
            }
        }
        
        
        for(Map.Entry<String, Integer> entry : dna_seqs.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
}