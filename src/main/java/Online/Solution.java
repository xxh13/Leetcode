package Online;

import java.util.*;

public class Solution {
    int count;
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            int i = 0;
            int[] array = new int[number];
            while (i < number) {
                array[i] = scanner.nextInt();
                i++;
            }
            System.out.println(solution.solve7(array));
        }
//        test1();
    }


    private static void test1() {
        int[] array = {1, 2, 3, 33, 4};
        Solution solution = new Solution();
        int result = solution.solve7(array);
        System.out.println(result);
    }

    private String solve1(int sum) {
        StringBuilder sb = new StringBuilder();
        // if the sum is odd, then the last machine is 1
        while(sum != 0) {
            if (sum % 2 == 1) {
                sb.insert(0, '1');
                sum = (sum - 1) / 2;
            } else{
                sb.insert(0, '2');
                sum = (sum - 2) / 2;
            }
        }
        return sb.toString();
    }

    private int solve2(int num) {
        int result = 0;
        int init = num;
        while (num > 0) {
            result =result * 10 + (num % 10);
            num = num / 10;
        }
        return init + result;
    }

    private double solve3(String s) {
        char[] array = s.toCharArray();
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        int count = 0;
        //init value map
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                if (array[i] == array[i - 1]) {
                    count ++;
                } else {
                    if (countMap.containsKey(array[i - 1] - 'a')) {
                        List<Integer> list = countMap.get(array[i - 1] - 'a');
                        list.add(count);
                        countMap.put(array[i - 1] - 'a', list);
                    } else {
                        List<Integer> list = new LinkedList<>();
                        list.add(count);
                        countMap.put(array[i - 1] - 'a', list);
                    }
                    count = 1;
                }
            } else {
                count ++;
            }
        }
        //handle the last char
        if (countMap.containsKey(array[array.length - 1] - 'a')) {
            List<Integer> list = countMap.get(array[array.length - 1] - 'a');
            list.add(count);
            countMap.put(array[array.length - 1] - 'a', list);
        } else {
            List<Integer> list = new LinkedList<>();
            list.add(count);
            countMap.put(array[array.length - 1] - 'a', list);
        }

        List<Integer> countList = new LinkedList<>();
        for (Map.Entry entry : countMap.entrySet()) {
            List<Integer> list = (List<Integer>) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                countList.add(list.get(i));
            }

        }
        OptionalDouble avg = countList.stream().mapToDouble(a -> a).average();
        return avg.isPresent() ? avg.getAsDouble() : 0;
    }

    private int solve4(String line1, String line2) {
        String[] args1 = line1.split(" ");
        String[] args2 = line2.split(" ");
        int cityNum = Integer.parseInt(args1[0]);
        int steps = Integer.parseInt(args1[1]);
        int[] parent = new int[args2.length];
        for (int i = 0; i< parent.length; i++) {
            parent[i] = Integer.parseInt(args2[i]);
        }
        int i = 0;
        int count = 1;
        while (steps > 0 && parent[i] >= 0 && parent[i] <= i) {
            i = parent[i];
            count++;
            steps--;
        }
        return count;
    }

    private void treasure(int[] parent,int i, int[] visited, int steps) {
        if (steps == 0) {
            int city = 0;
            for (int j = 0; j < visited.length; j++) {
                if (visited[i] == 1)
                    city++;
            }
            if (city > count) {
                count = city;
            }
        };

        visited[i] = 1;
        treasure(parent, parent[i], visited, steps--);
    }

    private boolean solve5(int[] array) {
        int dividedBy4 = 0;
        int dividedBy2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 4 == 0) {
                dividedBy4++;
            }else if (array[i] % 2 == 0) {
                dividedBy2++;
            }
        }
        //cannot divided by 4 nor 2
        int remain = array.length - dividedBy4 - dividedBy2;
        if (dividedBy4 * 2 + 1 >= array.length) return true;
        if (remain > dividedBy4 + 1) return false;
        return true;
    }

    private int solve6(String seq) {
        int length = seq.length();
        return 0;
    }

    private int solve7(int[] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2  = new ArrayList<>();
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int difficulty = 0;
            int diff = array[i];
            for (int j = 0; j < array.length; j++) {
                if (array[j] <= diff) {
                    list1.add(array[j]);
                } else {
                    list2.add(array[j]);
                }
            }
            for (int m = 0; m < list1.size() - 1; m++) {
                difficulty += Math.abs(list1.get(m) - list1.get(m + 1));
            }
            for (int n = 0; n < list2.size() - 1; n++) {
                difficulty += Math.abs(list2.get(n) - list2.get(n + 1));
            }
            sum = difficulty < sum ? difficulty : sum;
            list1.clear();
            list2.clear();
        }
        return sum;
    }
}
