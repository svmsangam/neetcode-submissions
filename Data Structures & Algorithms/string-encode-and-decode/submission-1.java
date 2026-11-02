class Solution {
    public String encode(List<String> strs) {
        StringBuilder encodedValue = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            String identifier = "#";
            encodedValue.append(len).append(identifier).append(s);
        }

        return encodedValue.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int identifierIndex = i;

            while (str.charAt(identifierIndex) != '#') {
                identifierIndex++;
            }

            int len = Integer.parseInt(str.substring(i, identifierIndex));

            result.add(str.substring(identifierIndex + 1, identifierIndex + 1 + len));

            i = identifierIndex + 1 + len;
        }

        return result;
    }
}
