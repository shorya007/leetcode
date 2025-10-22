class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0, high=0;
        for(int w:weights){
            low=Math.max(low,w);
            high+= w;
        }
        int result=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canShippackages(weights,days,mid)){  //utna din mein mein kr diya ship
                result=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return result;
    }
    private static boolean canShippackages(int[] weights, int days, int capacity){
        int daysNeeded=1;
        int currentLoad=0;
        for(int w:weights){
            if((currentLoad+w)>capacity){
                daysNeeded++;
                currentLoad=w;
            } else{
                currentLoad+=w;
            }
        }
        return daysNeeded<=days;


    }
}