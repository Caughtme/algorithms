package Fundamentals.AnalysisOfAlgorithms;

import java.util.Arrays;

public class E15_TwoSumFaster {
    public static int TwoSumFaster(int[] arr)
    {
        int cnt = 0;
        int N = arr.length;
        Arrays.sort(arr);
        int begin = 0;
        int end = N-1;
        while (begin < end)
        {
            if(arr[begin] + arr[end] > 0)
                end--;
            else if(arr[begin] + arr[end] < 0)
                begin++;
            else
            {
                cnt++;
                end--;
            }
        }
        return cnt;
    }

    private static int twoSumFaster2(int[] array) {
        int start = 0;
        int end = array.length - 1;

        int count = countZeroMatches(array);

        if ((array[start] > 0 && array[end] > 0) || (array[start] < 0 && array[end] < 0)) {
            return 0;
        }

        while (start < end) {
            if (array[start] + array[end] > 0) {
                end--;
            } else if (array[start] + array[end] < 0) {
                start++;
            } else {
                if (array[start] == 0 && array[end] == 0) {
                    start++;
                    end--;
                    continue;
                }

                int startElement = array[start];
                int equalStartElements = 1;

                // Compare all following elements with startElement
                while (start + 1 < end && array[start + 1] == startElement)
                {
                    equalStartElements++;
                    start++;
                }

                int endElement = array[end];
                int equalEndElements = 1;

                // Compare all previous elements with endElement
                while (end - 1 > start && array[end - 1] == endElement)
                {
                    equalEndElements++;
                    end--;
                }

                count += equalStartElements * equalEndElements;

                start++;
                end--;
            }
        }
        return count;
    }

    private static int countZeroMatches(int[] array) {
        int count = 0;

        for (int value : array) {
            if (value == 0) {
                count++;
            }
        }
        return handleZerosEdgeCase(count);
    }

    private static int handleZerosEdgeCase(int numberOfZeros) {
        return (numberOfZeros * (numberOfZeros - 1)) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0};
        int cnt = twoSumFaster2(arr);
        System.out.println(cnt);
    }
}
