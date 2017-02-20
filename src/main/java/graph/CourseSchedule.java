package graph;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]

 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * Created by XXH on 2016/8/27.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = {
                {5,8},
                {3,5},
                {1,9},
                {4,5},
                {0,2},
                {1,9},
                {7,8},
                {4,9}
        };
        System.out.println(courseSchedule.canFinish(10, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> pretMap = getAdjacentMap(numCourses, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        pretMap.keySet().stream().filter(e -> pretMap.get(e).size() == 0)
                .forEach(q::add);

        int counter = 0;
        while (!q.isEmpty()) {
            int v = q.remove();
            counter ++;
            for (Integer key : pretMap.keySet()) {
                List<Integer> list = pretMap.get(key);
                if (list.contains(v)) {
                    list.remove((Integer) v);
                    if (list.size() == 0){
                        q.add(key);
                    }
                        pretMap.put(key, list);
                }
            }
        }

        System.out.println(counter);

        return counter == numCourses;
    }

    private Map<Integer, List<Integer>> getAdjacentMap(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> pretMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (pretMap.get(prerequisites[i][0]) == null) {
                List<Integer> pre = new LinkedList<>();
                pre.add(prerequisites[i][1]);
                pretMap.put(prerequisites[i][0], pre);
            } else if (!pretMap.get(prerequisites[i][0]).contains(prerequisites[i][1])){
                pretMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        for (int i = 0; i < numCourses; i++){
            if (!pretMap.keySet().contains(i)) {
                pretMap.put(i, new LinkedList<>());
            }
        }

        System.out.println(pretMap);

        return pretMap;
    }
}
