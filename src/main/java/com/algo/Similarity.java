package com.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 余弦相似度算法
 * 匹配两段文字是否相似，可用于机器人问答、论文检索等
 *
 * Created by dai on 2022/3/22
 */
public class Similarity {

    public static void main (String[] args){
        // 兴趣：吃饭、逛街、打游戏、睡觉、唱歌
        ArrayList list1 = new ArrayList();
        list1.add(4.5);
        list1.add(5.0);
        list1.add(5.0);
        list1.add(5.0);
        list1.add(0.0);
        ArrayList list2 = new ArrayList();
        list2.add(3.5);
        list2.add(5.0);
        list2.add(5.0);
        list2.add(5.0);
        list2.add(0.0);

        System.out.println(similarity(list1, list2));
    }

    public static double similarity(ArrayList va, ArrayList vb) {
        if (va.size() > vb.size()) {
            int temp = va.size() - vb.size();
            for (int i = 0; i < temp; i++) {
                vb.add(0);
            }
        } else if (va.size() < vb.size()) {
            int temp = vb.size() - va.size();
            for (int i = 0; i < temp; i++) {
                va.add(0);
            }
        }

        int size = va.size();
        double simVal = 0;


        double num = 0;
        double den = 1;
        double powa_sum = 0;
        double powb_sum = 0;
        for (int i = 0; i < size; i++) {
            double a = Double.parseDouble(va.get(i).toString());
            double b = Double.parseDouble(vb.get(i).toString());

            num = num + a * b;
            powa_sum = powa_sum + Math.pow(a, 2);
            powb_sum = powb_sum + Math.pow(b, 2);
        }
        double sqrta = Math.sqrt(powa_sum);
        double sqrtb = Math.sqrt(powb_sum);
        den = sqrta * sqrtb;

        simVal = num / den;

        return simVal;
    }


}
