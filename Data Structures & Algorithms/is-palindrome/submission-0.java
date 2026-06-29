class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length/2; i++){
            if (!(ch[i] == ch[ch.length-i-1])){
                return false;
            }
        }

        return true;
    }
}
