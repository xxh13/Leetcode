package sample;

import java.util.*;

/**
 *
 * Created by XXH on 2016/3/21.
 */
public class Sample {

    public static void main(String[] args) {
        Sample main = new Sample();
        int plan[][] = {
                {0,1,0,0,1,0,1},
                {1,0,0,1,0,1,0},
                {1,1,0,0,0,0,0},
                {0,0,0,1,1,0,0},
                {0,1,0,1,0,0,0},
                {1,0,1,0,0,0,0},
                {1,0,1,1,0,1,1}
        };
        main.getSchedule(plan);
    }

    public void getSchedule(int[][] plan) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            result.put(i + 1, new ArrayList<>());
            for (int j = 0; j < 7; j++) {
                if (plan[i][j] == 1) {
                    result.get(i + 1).add(j + 1);
                }
            }
        }

        List<Integer> schedule = new ArrayList<>();
        List<List<Integer>> schedules = new ArrayList<>();
        getSchedule(result, schedule, schedules, 1);
        schedules.stream().forEach(System.out::println);
    }

    /*
     * plan     : 记录每个和尚能够挑水的日期
     * schedule : 记录每个和尚的挑水顺序
     * map      : 记录所有方案的种类
     */

    private void getSchedule(Map<Integer, List<Integer>> plan, List<Integer> schedule,
                             List<List<Integer>> schedules, int date) {

        if (schedule.size() == 7) {
            schedules.add(new ArrayList<>(schedule));
            return;
        }

        for (int i : plan.keySet()) {
            List<Integer> list = new ArrayList<>(plan.get(i));
            if (list.contains(date)) {
                schedule.add(i);
                plan.get(i).clear();
                getSchedule(plan, schedule, schedules, date + 1);
                plan.put(i, list);
                schedule.remove(schedule.size() - 1);
            }
        }

    }

}
