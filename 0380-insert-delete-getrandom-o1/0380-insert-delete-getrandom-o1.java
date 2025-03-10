class RandomizedSet {
    Random random;
    List<Integer>List;
    Map<Integer,Integer> map;

    public RandomizedSet() {
        random = new Random();
        List = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,List.size());
        List.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int index= map.remove(val);
        int element = List.remove(List.size()-1);
        if(index != List.size()){
            map.put(element,index);
            List.set(index,element);
        }
        return true;
        
    }
    
    public int getRandom() {
        return List.get(random.nextInt(List.size()));
        

        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */