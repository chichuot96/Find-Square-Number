package vn.topica.square.utils;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class Square {
    public boolean findOddSquare(int number){
        if(sqrt(number)==(int)sqrt(number)&&(int)sqrt(number)%2==1){
            return true;
        }else{
            return false;
        }
    }
//
//    public Map<Integer,Integer> findAllSquareInArr(ArrayList<Integer> list){
//        HashMap<Integer,Integer> mapNum = new HashMap<>();
//        for(int i=0;i<list.size();i++){
//            if(findOddSquare(list.get(i))){
//                mapNum.put(i,list.get(i));
//            }
//        }
//        return mapNum;
//    }
    public ArrayList<ArrayList<Obj>> getSubArr(Map<Integer,Integer> mapNum) {
        int count=0;
        ArrayList<ArrayList<Obj>> listReturn=new ArrayList<>();
        List<Map.Entry<Integer, Integer>> listNum = mapNum.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        for (int i = 1; i < listNum.size(); i++) {
            if(listNum.get(i-1).getValue()==listNum.get(i).getValue()-2){
                count++;
            }else{
                count=0;
            }
            if(count>=2){

//                for(int k=3;k<count+1;k++){
//                    ArrayList<Integer> listIndex=new ArrayList<>();
//                    ArrayList<Integer> listNumber=new ArrayList<>();
//                    for(int j=k-1;j>=0;j--){
//                        listIndex.add(listNum.get(i-j).getKey());
//                        listNumber.add(listNum.get(i-j).getValue());
//                    }
//                    mapReturn.put(listIndex,listNumber);
//                    System.out.println(listIndex+"===="+listNumber);
//                }

                for(int k=2;k<count+1;k++){
                    ArrayList<Obj> listMap=new ArrayList<>();
                    for(int j=k;j>=0;j--){
                        Obj o=new Obj(listNum.get(i-j).getKey(),listNum.get(i-j).getValue()*listNum.get(i-j).getValue());
                        listMap.add(o);
                    }
                    listReturn.add(listMap);
                }
            }

        }
        return listReturn;
    }
}
