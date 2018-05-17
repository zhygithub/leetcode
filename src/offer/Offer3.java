package offer;

/**
 * Created by ZhengHongyi on 2018/4/24.
 *
 * 在一个二维数组中查找某一个数，返回布尔值
 * 该数组有如下的特征：
 * 从左到右：数字增大
 * 从上到下：数字增大
 */
public class Offer3 {

    public static void main(String[] args){
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {3,7,10,13},
                {6,8,11,15}
        };

        boolean hasFind = findNum2(array, 6);
        System.out.print("hasFind = " + hasFind);
    }

    public static boolean findNum2(int[][] arrays, int num){
        if(arrays == null || arrays.length == 0){
            return false;
        }

        int y = 0;
        int x = arrays[0].length - 1;

        for(; x >= 0 && y<= arrays.length-1;){

            if(arrays[y][x] == num){
               return true;
            }else if(arrays[y][x] < num){
                y++;
            }else{
                x--;
            }
        }

        return false;
    }

    public static boolean findNum(int[][] arrays, int num){
        if(arrays == null || arrays.length == 0){
            return false;
        }

        int y = 0;
        int x = arrays[0].length - 1;

        for(; x >= 0; x--){

            if(arrays[y][x] == num){
                return true;
            }else if(arrays[y][x] < num){
                for(; y <= arrays.length-1; y++){
                    if(arrays[y][x] == num){
                        return true;
                    }
                }
            }else{
                for(; y <= arrays.length-1; y++){
                    if(arrays[y][x] == num){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
