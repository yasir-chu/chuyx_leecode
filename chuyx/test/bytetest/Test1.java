package test.bytetest;

/**
 * @author yuxiang.chu
 * @date 2022/8/15 17:59
 **/
public class Test1 {
    public static final int _1MB = 1024 * 1024;
    public static byte[] flags = new byte[ 512 * _1MB ];
    public static void main(String[] args) {
        int[] array = {255, 1024, 0, 65536, 255,6255, 511};

        int index = 0;
        for(int num : array) {
            if(!getFlag(num)) {
                //未出现的元素
                array[index] = num;
                index = index + 1;
                //设置标志位
                setFlag(num);
                System.out.println("set " + num);
            } else {
                System.out.println(num + " already exist");
            }
        }
    }
    public static void setFlag(int num) {
        //使用每个数的低三位作为byte内的映射
        //例如: 255 = (11111111)
        //低三位(也就是num & (0x07))为(111) = 7, 则byte的第7位为1, 表示255已存在
        flags[num >> 3] |= 0x01 << (num & (0x07));
    }

    public static boolean getFlag(int num) {
        return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
    }
}
