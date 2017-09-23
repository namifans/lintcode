/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param records a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] records) {
        Map<Integer, Double> result = new HashMap<>();
        if (records == null || records.length == 0) 
            return result;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            if (!map.containsKey(records[i].id)) {
                map.put(records[i].id, new PriorityQueue<Integer>(5, new Comparator<Integer>() {
                    public int compare(Integer i1, Integer i2) {
                        return i2 - i1;
                    }
                }));
            }
            PriorityQueue<Integer> queue = map.get(records[i].id);
            queue.add(records[i].score);
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> queue = entry.getValue();
            double average = 0;
            for (int i = 0; i < 5; i++) {
                average += queue.poll();
            }
            result.put(entry.getKey(), average / 5.0);
        }
        return result;
    }
}