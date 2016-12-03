package leetcode;

import java.util.*;

/**
 * Created by ZhengHy on 2016/12/3 0003.
 */
public class Majority_Element_II {

    /**
     * 这个方法用来找到所有在一个数组中出现次数超过  arr.lemgth / k  的数
     * 核心思路：
     * 一次在数组中删除 k 个不同的数，不停的删除，知道剩下数的种类不足 k 种的时候，
     * 剩下的 数组成的数组中 ，肯定包含了 符合要求的数，这时候再去判断剩下的数在数
     * 组中出现的次数是否真的超过 arr.lemgth / k  次即可
     * @param arr
     * @param k
     */
    public void printKMajor(int[] arr,int k ){
        if(k<2){
            System.out.println("k值非法,必须大于等于2");
            return ;
        }
        HashMap<Integer,Integer> cands = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i ++){
            if(cands.containsKey(arr[i])){
                cands.put(arr[i],cands.get(arr[i])+1);
            }else{
                if(cands.size() == k-1){
                    aliCandsMinusOne(cands);
                }else{
                    cands.put(arr[i],1);
                }
            }
        }

        HashMap<Integer,Integer> reals = getReals(arr,cands);
        boolean hasPrint = false ;
        //判断剩下的数中，是否有不需要的数，即出现次数不够的数
        for (Map.Entry<Integer,Integer> set :cands.entrySet()){
            Integer key = set.getKey();
            if(reals.get(key) > arr.length / k ){
                hasPrint = true;
                System.out.println(key +"");
            }
        }
        System.out.println(hasPrint ? "" : "没有这样的数");
    }

    /**
     * 当侯选组的个数满了，需要对每个侯选组的数的次数减一，再去除次数为0的数
     * @param cands
     */
    private void aliCandsMinusOne(HashMap<Integer, Integer> cands) {
        List<Integer> removeList = new LinkedList<>();
        for(Map.Entry<Integer,Integer> set : cands.entrySet()){
            Integer key = set.getKey();
            Integer value = set.getValue();
            if(value == 1){
                removeList.add(key);
            }
            cands.put(key,value-1);
        }
        for(Integer removeKey : removeList){
            cands.remove(removeKey);
        }
    }

    /**
     * 对于 剩下的数 去统计他们真正出现的次数，再返回
     * @param arr
     * @param cands
     * @return
     */
    private HashMap<Integer,Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer,Integer> reals = new HashMap<>();
        for(int i = 0 ; i <arr.length ; i++){
            int curNum = arr[i];
            if(cands.containsKey(curNum)){
                if(reals.containsKey(curNum)){
                    reals.put(curNum,reals.get(curNum)+1);
                }else{
                    reals.put(curNum,1);
                }
            }
        }
        return reals;
    }


    public static void main(String[] args){

    }
}
