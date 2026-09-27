class Solution {
    public int lengthOfLongestSubstring(String str) {
        int N = str.length();
		
		HashMap<Character ,Integer> map = new HashMap<>();
		
		int prev = 0;
		int max = -1;
		
		for(int i = 0; i < N; i++){
		    char ch = str.charAt(i);
		    
		    if(map.get(ch) == null || map.get(ch) < prev){
		        map.put(ch ,i);
		    }else{
		        int len = i - prev;
		        if(len > max){
		            max = len;
		        }
                prev = map.get(ch) + 1;
                map.put(ch ,i);
		    }
		}
	    if(N - prev > max){
	        max = N - prev;
	    }
        return max;
    }
}