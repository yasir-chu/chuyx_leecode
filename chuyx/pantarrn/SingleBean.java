package pantarrn;

/**
 * 单例模式 恶汉
 * @author chuyx
 */
public class SingleBean {

    private volatile static Object a = new Object();

    private SingleBean(){

    }

    /**
     * 记得static synchronized
     * @return 单例对象
     */
    public static Object getA(){
        return a;
    }


    /**
     * 懒汉
     */
    public static class SingleBean2{

        private static Object a;

        private SingleBean2(){

        }

        public synchronized Object getA(){
            // 加 synchronized
            if (a == null){
                a = new Object();
            }
            return a;
        }


    }

    /**
     * 二次确认
     */
    public static class SingleBean3{

        // volatile保证了a变量被初始化Object时，   多个线程获取的是正确的a  主要是防止重排
        private volatile static Object a;

        private SingleBean3(){

        }

        public static Object getA(){
            // 加 synchronized
            if (a == null){
                synchronized (Object.class){
                    if (a == null){
                        a = new Object();
                    }
                }
            }
            return a;
        }


    }
}
