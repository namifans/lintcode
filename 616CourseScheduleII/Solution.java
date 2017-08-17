public class Solution {
    class Course {
        public List<Integer> advCourses = new ArrayList<>();
    }
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            List<Integer> current = courses.get(prerequisite);
            current.add(course);
            courses.set(prerequisite, current);
            degree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0)
                queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[count] = course;
            count++;
            List<Integer> currentCourse = courses.get(course);
            for (Integer i : currentCourse) {
                degree[i]--;
                if (degree[i] <= 0) {
                    queue.add(i);
                }
            }
        }
        if (count == numCourses)
            return result;
        return new int[0];
    }
}