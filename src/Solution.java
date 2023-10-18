import java.util.List;

import dataStrcutures.list.SingleLinkedList;

public class Solution {
    public static void main(String[] args){
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addAll(List.of(1,2,3,4));
        for(Integer i : list){
            System.out.println(i);
        }
    }
}
