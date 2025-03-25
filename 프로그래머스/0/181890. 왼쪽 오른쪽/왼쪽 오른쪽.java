import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        ArrayList<String> list = new ArrayList<>();
        int lIndex = -1;
        int rIndex = -1;

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                lIndex = i;
                break;
            }
        }

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("r")) {
                rIndex = i;
                break;
            }
        }

        if (lIndex == -1 && rIndex == -1) return new String[]{};

        if (lIndex != -1 && (rIndex == -1 || lIndex < rIndex)) {
            for (int i = 0; i < lIndex; i++) {
                list.add(str_list[i]);
            }
        } else if (rIndex != -1) {
            for (int i = rIndex + 1; i < str_list.length; i++) {
                list.add(str_list[i]);
            }
        }

        return list.toArray(new String[0]);
    }
}
