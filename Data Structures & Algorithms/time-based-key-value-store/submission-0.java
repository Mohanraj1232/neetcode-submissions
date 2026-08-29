class TimeMap {

    HashMap<String ,List<Element>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, list -> new ArrayList<>()).add(new Element(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Element> cur = timeMap.get(key);

        if(cur == null) return "";

        int left = 0;
        int right = cur.size() - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(cur.get(mid).timeStamp <= timestamp){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return (ans == -1) ? "" : cur.get(ans).value;

    }
}

class Element{
    String value;
    int timeStamp;
    Element(String value ,int timeStamp){
        this.value = value;
        this.timeStamp = timeStamp;
    }
}