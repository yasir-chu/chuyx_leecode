package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author yuxiang_chu
 * @date 2022/9/27 10:17
 */
public class Test0102 {

    public static void main(String[] args) {
        Solution solution = new Test0102().new Solution();
        System.out.println(solution.CheckPermutation2("abc", "acb"));
    }

    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null || s2==null||s1.length() != s2.length()){
                return false;
            }
            Map<Character, Integer> mapS1 = new HashMap<>(s1.length());
            Map<Character, Integer> mapS2 = new HashMap<>(s1.length());
            for (int i = 0; i < s1.length(); i++) {

                Integer orDefault = mapS1.getOrDefault(s1.charAt(i), 0);
                orDefault += 1;
                mapS1.put(s1.charAt(i), orDefault);

                orDefault = mapS2.getOrDefault(s2.charAt(i), 0);
                orDefault += 1;
                mapS2.put(s2.charAt(i), orDefault);

            }
            AtomicBoolean result = new AtomicBoolean(true);
            mapS1.forEach((k,v) -> {
                if (!mapS2.containsKey(k) || !mapS2.getOrDefault(k,0).equals(v)) {
                    result.set(false);
                }
            });
            return result.get();
        }

        public boolean CheckPermutation2(String s1, String s2) {
            if (s1 == null || s2==null||s1.length() != s2.length()){
                return false;
            }
            Map<Character, Integer> map = new HashMap<>(s1.length());
            for (int i = 0; i < s1.length(); i++) {
                Integer charNum = map.getOrDefault(s1.charAt(i), 0);
                if ((charNum += 1) == 0) {
                    map.remove(s1.charAt(i));
                } else {
                    map.put(s1.charAt(i), charNum);
                }
                charNum = map.getOrDefault(s2.charAt(i), 0);
                if ((charNum -= 1) == 0) {
                    map.remove(s2.charAt(i));
                } else {
                    map.put(s2.charAt(i), charNum);
                }
            }
            return map.size() == 0;
        }
    }
}
