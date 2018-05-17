package offer;

/**
 * Created by ZhengHongyi on 2018/4/25.
 *
 * 给出一个字符数组，将其中的空格替换成%20
 *
 */
public class Offer4 {

    public static void main(String[] args){
        char[] array = new char[]{'W','e',' ','a','r','e',' ','h','a','p','p','y','!'};

        System.out.print("old :" + toStr(array));

        System.out.print("\nnew :" + toStr(replace(array)));

    }

    public static String toStr(char[] chars){

        return new String(chars);
    }

    public static char[] replace(char[] array){
        if(array == null || array.length <= 0){
            return array;
        }

        int count = 0;
        for(char c : array){
            if(c == ' '){
                count ++;
            }
        }

        int newLength = count * 2 + array.length;

        char[] newArray = new char[newLength];

        int x = array.length - 1;
        int y = newLength -1;

        while(x >= 0){
            if(array[x] == ' '){
                newArray[y--] = '0';
                newArray[y--] = '2';
                newArray[y--] = '%';
            }else{
                newArray[y--] = array[x];
            }
            x--;
        }

        return newArray;
    }
}
