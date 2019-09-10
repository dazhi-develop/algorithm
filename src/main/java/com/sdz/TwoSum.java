package com.sdz;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : songdezhi
 * @date : 2019/9/10
 */
public class TwoSum {
    public static Integer[] getIntegerArray(Integer length) {
        Random random = new Random();
        Integer[] integers = new Integer[length];
        for (int i = 0; i < length; i++) {
            integers[i] = random.nextInt(10);
        }

        return integers;
    }

    public static Integer[] getIndex(Integer[] integers, Integer sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < integers.length; i++) {
            int rest = sum - integers[i];
            if (map.containsKey(rest)) {
                return new Integer[]{
                        i, map.get(rest)
                };
            }
            map.put(integers[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Integer[] integers = getIntegerArray(20);
        System.out.println("IntegerArray:");
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
        Integer[] result = getIndex(integers, 10);
        String resultStr = result != null ? result[0] + " " + result[1] : "no data";
        System.out.println("result:" + resultStr);

    }
}
