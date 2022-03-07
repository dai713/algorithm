package com.algo.other;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 重复数字计算
 * 可用作计数排序
 *
 * Created by dai on 2021/12/28
 */
public class RepetitionNumber {

    public static void main(String[] args) throws IOException {
        String path = "/Users/dai/Downloads/test.txt";
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        String len;
        int total = 0;
        int[] arr = new int[100];
        while((len = reader.readLine()) != null) {
            arr[Integer.parseInt(len)]++;
            total++;
        }
        System.out.println("total: " + total);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " - " +arr[i]);
        }


    }
}
