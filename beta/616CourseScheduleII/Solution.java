public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisitess: a list of prerequisites pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Set<Integer> scheduled = new HashSet<>();
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            List<Integer> list = courseMap.get(prerequisites[i][0]);
            if (list == null)
                list = new ArrayList<>();
            list.add(prerequisites[i][1]);
            courseMap.put(prerequisites[i][0], list);
        }
        int index = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                result[index++] = i;
                scheduled.add(i);
            }
        }
        while (scheduled.size() < numCourses) {
            Iterator it = courseMap.entrySet().iterator();
            boolean in = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Integer course = (Integer) entry.getKey();
                List<Integer> list = courseMap.get(course);
                if (!list.isEmpty()) {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (scheduled.contains(list.get(i))) {
                            list.remove(i);
                            degree[course]--;
                        }
                    }
                }
                if (degree[course] == 0) {
                    scheduled.add(course);
                    in = true;
                    result[index++] = course;
                    it.remove();
                }
            } 
            if (!in) {
                return new int[0];
            }
        }
        return result;
    }
}