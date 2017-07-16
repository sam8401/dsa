package com.sam8401.company;

/**
 * Created by suman on 16/07/17.
 */


public class Sorter {

    private void merge(int[] input, int start, int mid, int end) {
        int leftSize = mid-start+1;
        int rightSize = end-mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for(int i =start; i<=mid; i++)
            left[i-start] = input[i];
        for(int i =mid+1; i<=end; i++)
            right[i-mid-1] = input[i];

        int li, ri; li = ri = 0;
        int inputIndex = start;

        while(inputIndex <= end) {
            if (li == leftSize) {
                input[inputIndex] = right[ri++];
            }
            else if (ri == rightSize) {
                input[inputIndex] = left[li++];
            }
            else {
                if (left[li] <= right[ri]) {
                    input[inputIndex] = left[li++];
                    input[++inputIndex] = right[ri++];
                } else {
                    input[inputIndex] = right[ri++];
                    input[++inputIndex] = left[li++];
                }
            }

            inputIndex++;
        }

    }


    private void mergeSort(int[] input, int start, int end) {

        if(start >= end)
            return;

        int mid = (start + end)/2;
        mergeSort(input, start, mid);
        mergeSort(input, mid+1, end);
        merge(input, start, mid, end);
    }


    public void sort(int[] numbers) {

        if (numbers.length > 0) {
            mergeSort(numbers, 0, numbers.length - 1);
        }
    }
}
