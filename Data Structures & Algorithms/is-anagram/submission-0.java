class Solution {
    public boolean isAnagram(String s, String t) {
        int fre1[] = new int[26];
        int fre2[] = new int[26];

        for(char ch : s.toCharArray()){
            fre1[ch - 'a']++;
        }
        
        for(char ch : t.toCharArray()){
            fre2[ch - 'a']++;
        }

        return Arrays.equals(fre1 ,fre2);
    }
}
