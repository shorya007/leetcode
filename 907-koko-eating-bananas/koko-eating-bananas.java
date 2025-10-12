class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;  //minimum ith=na hee kha paya koko 1 kth hour mein 
        int high=0;
        for(int pile:piles){
            if(pile>high){
                high=pile;
            }
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(kokoCanEat(piles,h,mid)){
                high=mid;   //mid se ho gaya hai kaam smaller k dhundo
            }
            else{
                low=mid+1;  //mid bhut chota hai larger k dhundo
                //iske baad = 2 dhu;
            }
        }
        return low;


    }
    private boolean kokoCanEat(int[] piles,int h,int k){
        int hoursPerPile=0;
        for(int pile:piles){
            hoursPerPile+=(pile+k-1)/k;
        }
        return hoursPerPile<=h;

        

    }
}