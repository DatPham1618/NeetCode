/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.topkfrequencyelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author minec
 */
public class TopKFrequencyElements {

    public static void main(String[] args) {
        int[] testCase1 = {1, 3, 3, 3, 4};
        
        Solution solution = new Solution();
        
        int[] result = solution.topKFrequent(testCase1, 1);
        
        System.out.println("Result:");
        
        for (int num : result){
            System.out.println(num);
        }
        
    }
    
}
    

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        List<List<Integer>> buckets = new ArrayList<>();

        int bucket_count = nums.length;

        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= bucket_count; i++){
            buckets.add(new ArrayList<>());
        }

        for (int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            buckets.get(frequency).add(key);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = bucket_count; i >= 0 && result.size() < k; i--){
            List<Integer> currentBucket = buckets.get(i);
            for (int num : currentBucket) 
            { 
                result.add(num); 
                if (result.size() == k) { 
                    break;
                }
            }
            if (result.size() == k) { 
                break;
            }
        }

        int[] finalResult = new int[result.size()];

        for (int i = 0; i < k; i++){
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }
}
    

