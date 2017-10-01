public class TwoSum {

    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        list.add(number);
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Integer i : list) {
            int source = i;
            int target = value - source;
            if (map.containsKey(target)) {
                if (source == target && map.get(source) > 1)
                    return true;
                if (source != target)
                    return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);