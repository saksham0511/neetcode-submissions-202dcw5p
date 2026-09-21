class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.get(key) == null) {
            map.put(key, new ArrayList<>());
        }
        List<Data> data = map.get(key);
        data.add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (map.get(key) == null) {
            return "";
        }
        List<Data> data = map.get(key);
        int low = 0;
        int high = data.size()-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (data.get(mid).timestamp == timestamp) {
                return data.get(mid).value;
            } else if (data.get(mid).timestamp < timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0) {
            return "";
        }
        return data.get(high).value;
    }

    class Data {
        int timestamp;
        String value;
        public Data(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
