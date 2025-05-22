class Solution {
    List<List<Integer>> ans ;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;
        fun(nums, n, new ArrayList<Integer>());
        return ans;
    }
        public void fun(int nums[] , int n , ArrayList<Integer>temp) {
        if(n==0){
            // add the temp to ans list
           ArrayList<Integer> subset = new ArrayList<>(); 
           for(Integer a : temp)
           subset.add(a);
           ans.add(subset);
           return;  
                   
           
        }
        // include
        temp.add(nums[n-1]);
        fun(nums, n-1, temp);
        temp.remove(temp.size()-1);

        // exclude
        fun(nums, n-1, temp);
        
    }
}