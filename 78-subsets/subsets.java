class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generateSubset(new ArrayList<>(),0,nums,result);
        return result;


    }
    private void generateSubset(List<Integer> current,int index,int[] nums,List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;


        }
        //lets take numms as [1,2]
        current.add(nums[index]);  //idhar banega [1,2]
        generateSubset(current,index+1,nums,result); // sidha recurse kar rhe hain isme w/o anything
        current.remove(current.size()-1); //isse banega [1],[2]
        generateSubset(current,index+1,nums,result);


    //total banega [[1],[2],[1,2]]
        

    }
}