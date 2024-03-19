package test;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author yuxiang.chu
 * @date 2022/8/30 10:12
 **/
public class NormalTest {

    public static void main(String[] args) throws Exception {
        List<String> strings = Arrays.asList("1", "2");
        List<String> a = new ArrayList<>(strings);
        a.add("3");

    }

    /**
     * 多维度模糊音替换方案
     * @param text 替换文案
     * @param strTReplace 待替换内容
     * @param replacement 替换内容
     * @return
     */
    public static List<String> replaceAll(String text, String strTReplace, String replacement) {
        List<String> results = new ArrayList<>();
        replaceAllHelper(text, strTReplace, replacement, 0, new StringBuilder(), results);
        return results;
    }

    /**
     *
     * @param text 原始内容
     * @param strToReplace 待替换数据
     * @param replacement 替换数据
     * @param index 当前位置
     * @param current
     * @param results 结果
     */
    private static void replaceAllHelper(String text, String strToReplace, String replacement, int index,
                                         StringBuilder current, List<String> results) {
        // 所有内容都判断过 结束
        if (index >= text.length()) {
            results.add(current.toString());
            return;
        }

        int endIndex = index + strToReplace.length();
        if (endIndex <= text.length() && text.substring(index, endIndex).equals(strToReplace)) {
            // 找到匹配的子字符串，替换之
            current.append(replacement);
            replaceAllHelper(text, strToReplace, replacement, endIndex, current, results);
            // 回溯
            current.setLength(current.length() - replacement.length());
        }

        // 不替换当前字符
        current.append(text.charAt(index));
        replaceAllHelper(text, strToReplace, replacement, index + 1, current, results);
        // 回溯
        current.setLength(current.length() - 1);
    }



}
