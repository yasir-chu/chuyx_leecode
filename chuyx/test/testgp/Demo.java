package test.testgp;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * @author yuxiang.chu
 * @date 2022/8/29 17:47
 **/
public interface Demo {

    static void main(String[] args) {
        Date beginDate = new Date(1679622710000L);
        Date endTime = new Date(1679644733000L);
        Long betweenNum = endTime.getTime() - beginDate.getTime();
        Long days = betweenNum / (60 * 60 * 24 * 1000L);
        Long a = betweenNum % (60 * 60 * 24 * 1000L) != 0L ? days + 1 : days;
        System.out.println(a);


    }

    static List<String> test(Integer test) {
        Function<Integer, String> intToStr = String::valueOf;
        Function<String, List<String>> strToList = Collections::singletonList;
        Function<Integer, List<String>> integerListFunction = intToStr.andThen(strToList);
        return integerListFunction.apply(test);
    }


}
