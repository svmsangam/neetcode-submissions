class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> memory = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];
        int index = 0;
        int[] result = new int[k];
        for (int num : nums) {
            if (memory.containsKey(num)) {
                int existingValue = memory.get(num);
                memory.put(num, existingValue + 1);
            } else {
                memory.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : memory.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }
        for (int freq = nums.length; freq >= 1; freq--) {
            if (buckets[freq] == null) {
                continue;
            }

            for (int num : buckets[freq]) {
                result[index] = num;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
