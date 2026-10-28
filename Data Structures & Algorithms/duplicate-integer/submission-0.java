class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> memory = new HashSet<>();
        for(int num: nums){
            if(!memory.add(num)){
                return true;
            }
        }
        return false;
    }
}