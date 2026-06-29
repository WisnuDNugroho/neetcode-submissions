class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            if (map.containsKey(new String(ch))){
                map.get(new String(ch)).add(strs[i]);
            } else {
                map.put(new String(ch), new ArrayList<>(List.of(strs[i])));
            }
        }

        result.addAll(map.values());
        
        return result;
    }
}
