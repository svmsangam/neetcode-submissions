class Solution {
    public int longestConsecutive(int[] nums) {
        int sequenceCount = 0;
        int longest = 0;
        Set<Integer> numbers = new HashSet<>();

        for (int n : nums) {
            numbers.add(n);
        }

        for (int num : numbers) {
            if (!numbers.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (numbers.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
