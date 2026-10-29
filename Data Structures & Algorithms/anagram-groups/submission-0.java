class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String word : strs) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int frequency : count) {
                keyBuilder.append(frequency).append('#');
            }

            String key = keyBuilder.toString();
            if (group.containsKey(key)) {
                group.get(key).add(word);
            } else {
                group.put(key, new ArrayList<>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(group.values());
    }
}
