package test.annotationtest;

/**
 * @author yuxiang.chu
 * @date 2022/8/29 11:35
 **/
public class Demo {

    public static void main(String[] args) {
        One one = new One();
        Two two = new Two();
        TestAnnotation annotation = two.getClass().getAnnotation(TestAnnotation.class);
        System.out.println(annotation.value());
        TestAnnotation oneannotation = one.getClass().getAnnotation(TestAnnotation.class);
        System.out.println(oneannotation.value());
    }
}
