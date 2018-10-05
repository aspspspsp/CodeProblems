package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();

        if(cpdomains == null || cpdomains.length == 0)
            return result;

        Map<String, Integer> map = new HashMap<>();
        // �C�@�ӿ�J�i��sĶ
        for(String cpdomain : cpdomains) {
            String[] _ = cpdomain.split(" ");
            int visit = Integer.parseInt(_[0]);
            String domain = _[1];
            String[] __ = domain.split("\\.");

            // �̧ǳB�z�l����(ex: www.google.com -> google.com -> com)
            for(int i = 0; i < __.length; i ++) {
                StringBuilder sb = new StringBuilder(); //�Q��StringBuilder�[�t
                for(int j = i; j < __.length; j ++) {
                    sb.append(__[j]);
                    if(j < __.length - 1)
                        sb.append(".");
                }

                String subDomain = sb.toString();
                if(map.containsKey(subDomain) == false)
                    map.put(subDomain, 0);

                map.put(subDomain, map.get(subDomain) + visit);
            }
        }

        // ��X���G
        for(String domain : map.keySet()) {
            Integer visit = map.get(domain);
            String r = visit + " " + domain;
            result.add(r);
        }

        return result;
    }
}
