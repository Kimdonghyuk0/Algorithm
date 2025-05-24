import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
       
        HashMap<String,Integer> rank = new HashMap<>();
        for(int i = 0; i<players.length; i++){
            rank.put(players[i],i);
        }
        for(String str:callings){
            int inx = rank.get(str);
            String front = players[inx-1];
            String back = players[inx];
            players[inx-1] = back;
            players[inx] = front;
            rank.put(front,inx);
            rank.put(back,inx-1);
        }
        
        
        return players;
    }
}