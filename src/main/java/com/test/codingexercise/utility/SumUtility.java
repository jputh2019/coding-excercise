package com.test.codingexercise.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SumUtility {
    private static final int MAX_LIMIT = 100;
    private static final int MIN_LIMIT = 1;
    private static final int MAX_NUM_NUMBERS_FOR_SUM = 5;

    public SumUtility() {

    }

    public String getQuestion() {
        int num = ThreadLocalRandom.current().nextInt(2, MAX_NUM_NUMBERS_FOR_SUM + 1);
        ArrayList<String> numberList = new ArrayList<String>();
        for (int counter = 0; counter < num; counter++) {
            int randomNum = ThreadLocalRandom.current().nextInt(MIN_LIMIT, MAX_LIMIT + 1);
            numberList.add(String.valueOf(randomNum));
        }
        return "Here you go, solve the question: \"Please sum the numbers " + String.join(",", numberList) + "\".";
    }

    public boolean validateAnswer(String answer) {
        String modifiedMsg = answer.replaceAll("[^0-9]", " ").replaceAll("\\s+", " ");
        String[] numArr = modifiedMsg.split(" ");
        List<Integer> nums = new ArrayList<Integer>();
        for (String str : numArr) {
            if (str.equals(""))
                continue;
            nums.add(Integer.parseInt(str));
        }
        if (nums.size() < 3)
            return false;

        int trueSum = 0;

        for (int k = 0; k < nums.size() - 1; k++)
            trueSum += nums.get(k);

        int ansSum = nums.get(nums.size() - 1);

        if (trueSum == ansSum)
            return true;
        else
            return false;
    }
}
