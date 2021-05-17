package HashMapPractice;

import java.util.HashMap;

public class HashMap_001 {

    private static HashMap<Character, Integer> getFrequencyMap(String str) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            if(frequencyMap.containsKey(str.charAt(i))){
                frequencyMap.put(str.charAt(i), frequencyMap.get(str.charAt(i) + 1));
            }
            else{
                frequencyMap.put(str.charAt(i), 1);
            }
        }
        return frequencyMap;
    }

    private static void longestConsecutiveSeq(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int val: arr) {
            map.put(val, true);
        }
        for(int val: arr) {
            if (map.containsKey(val - 1))
                map.put(val, false);
        }
        int maxLength = Integer.MIN_VALUE;
        int startElement = 0;
        for(int val: arr) {
            if(map.get(val)){
                int resultLength = 1;
                while(map.containsKey(val+resultLength)){
                    resultLength++;
                }
                if(resultLength > maxLength){
                    maxLength = resultLength;
                    startElement = val;
                }
            }
        }

        for(int i = 0; i<maxLength; i++){
            System.out.println(startElement+i);
        }
    }

    public static void main(String[] args) {
        getFrequencyMap("aaabbbbccccaaaadddbbbbsss");

        int arr[] = {10,5,9,1,11,8,6,15,3,12,2};
        longestConsecutiveSeq(arr);

    }




}
