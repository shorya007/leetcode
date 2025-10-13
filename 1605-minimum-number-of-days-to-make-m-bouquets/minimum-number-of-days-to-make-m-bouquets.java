class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k > bloomDay.length) return -1;

        //Find range of days
        int low= Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int day : bloomDay){
            low=Math.min(low,day);
            high = Math.max(high,day);
        }
        while(low<high){
                int mid = low+(high-low)/2;
                if(canMakeBouquets(bloomDay,m,k,mid)){
                    high=mid;

                }
                else{
                    low=mid+1;
                }
            }
        return low;
        
    }
    private boolean canMakeBouquets(int[] bloomDay,int m,int k,int day){
        int flower=0;  //// consecutive bloomed flowers
        int bouquet=0;  // total bouquets formed
        for(int bloom : bloomDay){
            if(bloom<=day){
                flower++;
                if(flower==k){
                    bouquet++;
                    flower=0;
                }
            } 
            else{
                flower=0;
            }
        }
        return bouquet>=m;


    }
}