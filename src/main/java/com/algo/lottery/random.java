package com.algo.lottery;

import java.util.*;

/**
 * 【概率抽奖】 实现
 */
public class random {

   public static Map<String, Object> giftMap = new HashMap<>();

    private static Map<String, Object> setGift() {
        giftMap.put("p0", 0.8);
        giftMap.put("p1", 0.1);
        giftMap.put("p2", 0.2);
        giftMap.put("p3", 0.3);
        giftMap.put("p4", 0.5);
        return giftMap;
    }

   private static int lottery(List<Double> orignalRates) {
       if (orignalRates == null || orignalRates.isEmpty()) {
           return -1;
       }

       int size = orignalRates.size();

       // 计算总概率，这样可以保证不一定总概率是1
       double sumRate = 0d;
       for (double rate : orignalRates) {
           sumRate += rate;
       }

       // 计算每个物品在总概率的基础下的概率情况
       List<Double> sortOrignalRates = new ArrayList<>(size);
       Double tempSumRate = 0d;
       for (double rate : orignalRates) {
           tempSumRate += rate;
           sortOrignalRates.add(tempSumRate / sumRate);
       }

       // 根据区块值来获取抽取到的物品索引
       double nextDouble = Math.random();
       sortOrignalRates.add(nextDouble);
       Collections.sort(sortOrignalRates);

       return sortOrignalRates.indexOf(nextDouble);


   }

    public static void main(String[] args) {
        Map<String, Object> gifts = setGift();
        // 存储概率
        List<Double> orignalRates = new ArrayList<>(gifts.size());

        for (Map.Entry<String, Object> entry : gifts.entrySet()) {
            String key = entry.getKey();
            double probability = (double) entry.getValue();
            if (probability < 0) {
                probability = 0;
            }
            orignalRates.add(probability);

        }

        // 统计
        Map<Integer, Integer> count = new HashMap<>();

        // 测试次数
        double num = 10000;
        for (int i = 0; i < num; i++) {
            int orignalIndex = lottery(orignalRates);
            Integer value = count.get(orignalIndex);
            count.put(orignalIndex, value == null ? 1 : value + 1);
        }


        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            System.out.println(" 命中次数=" + entry.getValue() + ", 实际概率=" + entry.getValue() / num);
        }


    }
}
