package arrays;

import java.util.ArrayList;

public class ArrayAddElement {
    public static void main(String[] args) {
        ArrayAddElement arrayList  = new ArrayAddElement();
        int[] arr ={1,5,5,7,7,55};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = arrayList.addList(arr,7,0,list);
        System.out.println(arrayList.addList2(arr,7,0))  ;
    }
    public ArrayList<Integer> addList(int[] arr, int target, int index,ArrayList<Integer> list ){
        if (index == arr.length-1){
            return list;
        }
        if (target == arr[index]){
            list.add(index);
        }
        return addList(arr,target,index+1,list);
    }

    public ArrayList<Integer> addList2(int[] arr, int target, int index ){
        ArrayList<Integer>list = new ArrayList<>();
        if (index == arr.length-1){
            return list;
        }
        if (target == arr[index]){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = addList(arr,target,index+1,list);
        list.addAll(ansFromBelowCalls);
        return list;
    }

}
