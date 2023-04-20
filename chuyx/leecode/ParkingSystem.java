package leecode;

/**
 * @author yuxiang_chu
 * @date 2023/4/20 14:35
 */
public class ParkingSystem {

    int big = 0;
    int medium = 0;
    int small = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.big += big;
        this.medium += medium;
        this.small += small;
    }

    public boolean addCar(int carType) {
        boolean res = true;
        if (carType == 1 && big > 0) {
            big--;
        } else if (carType == 2 && medium > 0) {
            medium--;
        }else if (carType == 3 && small > 0){
            small--;
        }else {
            res = false;
        }
        return res;
    }
}
