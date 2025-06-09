package leetcode1_100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode8 {


    public static void main(String[] args) {
        System.out.println(myAtoi("-042"));
    }

    // 48 开始
    public static List<String> numberStringArr= Arrays.asList("0","1","2","3","4","5","6","7","8","9");
    public static String[] symbolArr= {"-","+"};

    public static int myAtoi(String str) {
        str = str.trim();
        String pattern = "[+-]?[0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        if(m.lookingAt()){
            str = str.substring(0,m.end());
            try{
                return Integer.parseInt(str);
            }catch(Exception e){
                return str.charAt(0) == '-'? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }



}
