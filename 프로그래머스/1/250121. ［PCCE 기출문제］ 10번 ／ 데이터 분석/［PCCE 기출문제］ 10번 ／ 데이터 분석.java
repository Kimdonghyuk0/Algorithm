import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> list = new ArrayList<>();
        int index;
        if(ext.equals("code"))index = 0;
        else if(ext.equals("date"))index = 1;
        else if(ext.equals("maximum"))index = 2;
        else index = 3;
        for(int i = 0; i<data.length; i++){
            if(data[i][index]<val_ext){
                list.add(data[i].clone());
            }

        }
        if(sort_by.equals("code"))index = 0;
        else if(sort_by.equals("date"))index = 1;
        else if(sort_by.equals("maximum"))index = 2;
        else index = 3;
        final int sortIndex = index; 
        Collections.sort(list,(arr1,arr2)->{
            return arr1[sortIndex]-arr2[sortIndex];
        });
        return list.toArray(new int[list.size()][]);
    }
}