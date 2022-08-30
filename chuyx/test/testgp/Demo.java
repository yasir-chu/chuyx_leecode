package test.testgp;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author yuxiang.chu
 * @date 2022/8/29 17:47
 **/
public interface Demo {

    static void main(String[] args) {
        List<String> test = test(1);
        System.out.println(test.get(0).getClass().toString());
        System.out.println(test);

    }

    static List<String> test(Integer test) {
        Function<Integer, String> intToStr = String::valueOf;
        Function<String, List<String>> strToList = Collections::singletonList;
        Function<Integer, List<String>> integerListFunction = intToStr.andThen(strToList);
        return integerListFunction.apply(test);
    }


}
