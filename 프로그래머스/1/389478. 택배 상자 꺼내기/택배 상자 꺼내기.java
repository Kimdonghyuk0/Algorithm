class Solution {
    private boolean isOdd(int n){ //홀수면 true
        if(n%2==0)return false;
        else return true;
    }
    public int solution(int n, int w, int num) {
        int allH = n%w>0?n/w+1:n/w;
        int topOrd = n%w==0?w:n%w; //몇번째 인지
        int numOrd = num%w==0?w:num%w;
        int numH = num%w>0?num/w+1:num/w;
        System.out.println("allH :"+allH+" numH:"+numH);
        System.out.println("topOrd :"+topOrd+" numOrd:"+numOrd);
        int ans = allH-numH;
        System.out.println(ans);
        if(isOdd(allH)){
            if(isOdd(numH)){
                if(topOrd<numOrd)ans--;
            }
            else{
                if(w-topOrd>=numOrd)ans--;
            }
        }
       
        else{
             if(isOdd(numH)){
                if(w-topOrd>=numOrd)ans--;
            }
            else{
                if(topOrd<numOrd)ans--;
            }
        }
       
        
      return ++ans;
    }
}