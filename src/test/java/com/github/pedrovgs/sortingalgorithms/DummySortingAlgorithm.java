package com.github.pedrovgs.sortingalgorithms;

import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;

public class DummySortingAlgorithm extends SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        validateInput(numbers);
        // simple swap of first two elements if array length > 1
        if (numbers.length > 1) {
            swap(numbers, 0, 1);
        }
    }
}
