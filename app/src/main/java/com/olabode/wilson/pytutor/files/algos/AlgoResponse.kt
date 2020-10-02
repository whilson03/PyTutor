package com.olabode.wilson.pytutor.files.algos

import com.olabode.wilson.pytutor.models.remote.algorithm.AlgorithmResponse

/**
 *   Created by OLABODE WILSON on 9/29/20.
 */

fun listOfAlgorithms() = listOf(
    AlgorithmResponse(
        id = "",
        title = "Bubble Sort",
        description = "It is a comparison-based algorithm in which each pair of adjacent elements is compared and the elements are swapped if they are not in order.",
        body = "def bubblesort(items):\n" +
            "\n" +
            "# Swap the elements to arrange in order\n" +
            "    for iter_num in range(len(items)-1,0,-1):\n" +
            "        for idx in range(iter_num):\n" +
            "            if items[idx]>items[idx+1]:\n" +
            "                temp = items[idx]\n" +
            "                items[idx] = items[idx+1]\n" +
            "                items[idx+1] = temp\n"
    ),

    AlgorithmResponse(
        id = "",
        title = "Merge Sort",
        description = "Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.",
        body = "def merge_sort(unsorted_list):\n" +
            "    if len(unsorted_list) <= 1:\n" +
            "        return unsorted_list\n" +
            "    # Find the middle point and devide it\n" +
            "    middle = len(unsorted_list) // 2\n" +
            "    left_list = unsorted_list[:middle]\n" +
            "    right_list = unsorted_list[middle:]\n" +
            "\n" +
            "    left_list = merge_sort(left_list)\n" +
            "    right_list = merge_sort(right_list)\n" +
            "    return list(merge(left_list, right_list))\n" +
            "\n" +
            "\n" +
            "# Merge the sorted halves\n" +
            "\n" +
            "def merge(left_half, right_half):\n" +
            "    res = []\n" +
            "    while len(left_half) != 0 and len(right_half) != 0:\n" +
            "        if left_half[0] < right_half[0]:\n" +
            "            res.append(left_half[0])\n" +
            "            left_half.remove(left_half[0])\n" +
            "        else:\n" +
            "            res.append(right_half[0])\n" +
            "            right_half.remove(right_half[0])\n" +
            "    if len(left_half) == 0:\n" +
            "        res = res + right_half\n" +
            "    else:\n" +
            "        res = res + left_half\n" +
            "    return res\n"
    ),
    AlgorithmResponse(
        id = "",
        title = "Insertion Sort",
        description = "Insertion sort involves finding the right place for a given element in a sorted list. So in beginning we compare the first two elements and sort them by comparing them. Then we pick the third element and find its proper position among the previous two sorted elements. This way we gradually go on adding more elements to the already sorted list by putting them in their proper position.",
        body = "def insertion_sort(mList):\n" +
            "    # We start from 1 since the first element is trivially sorted\n" +
            "    for index in range(1, len(mList)):\n" +
            "        currentValue = mList[index]\n" +
            "        currentPosition = index\n" +
            "\n" +
            "        # As long as we haven't reached the beginning and there is an element\n" +
            "        # in our sorted mList larger than the one we're trying to insert - move\n" +
            "        # that element to the right\n" +
            "        while currentPosition > 0 and mList[currentPosition - 1] > currentValue:\n" +
            "            mList[currentPosition] = mList[currentPosition - 1]\n" +
            "            currentPosition = currentPosition - 1\n" +
            "\n" +
            "        # We have either reached the beginning of the mList or we have found\n" +
            "        # an element of the sorted mList that is smaller than the element\n" +
            "        # we're trying to insert at index currentPosition - 1.\n" +
            "        # Either way - we insert the element at currentPosition\n" +
            "        mList[currentPosition] = currentValue"
    ),
    AlgorithmResponse(
        id = "",
        title = "Shell Sort",
        description = "Shell Sort involves sorting elements which are away from ech other. We sort a large sublist of a given list and go on reducing the size of the list until all elements are sorted. The below program finds the gap by equating it to half of the length of the list size and then starts sorting all elements in it. Then we keep resetting the gap until the entire list is sorted.",
        body = "def shellSort(input_list):\n" +
            "    gap = len(input_list) // 2\n" +
            "    while gap > 0:\n" +
            "\n" +
            "        for i in range(gap, len(input_list)):\n" +
            "            temp = input_list[i]\n" +
            "            j = i\n" +
            "            # Sort the sub list for this gap\n" +
            "\n" +
            "            while j >= gap and input_list[j - gap] > temp:\n" +
            "                input_list[j] = input_list[j - gap]\n" +
            "                j = j - gap\n" +
            "            input_list[j] = temp\n" +
            "\n" +
            "        # Reduce the gap for the next element\n" +
            "\n" +
            "        gap = gap // 2\n"
    ), AlgorithmResponse(
        id = "",
        title = "Selection Sort",
        description = "In selection sort we start by finding the minimum value in a given list and move it to a sorted list. Then we repeat the process for each of the remaining elements in the unsorted list. The next element entering the sorted list is compared with the existing elements and placed at its correct position. So at the end all the elements from the unsorted list are sorted.",
        body = "def selectionSort(mList):\n" +
            "    n = len(mList)\n" +
            "    for i in range(n):\n" +
            "        # Initially, assume the first element of the unsorted part as the minimum.\n" +
            "        minimum = i\n" +
            "\n" +
            "        for j in range(i + 1, n):\n" +
            "            if mList[j] < mList[minimum]:\n" +
            "                # Update position of minimum element if a smaller element is found.\n" +
            "                minimum = j\n" +
            "\n" +
            "        # Swap the minimum element with the first element of the unsorted part.     \n" +
            "        temp = mList[i]\n" +
            "        mList[i] = mList[minimum]\n" +
            "        mList[minimum] = temp\n" +
            "\n" +
            "    return mList\n"
    ), AlgorithmResponse(
        id = "",
        title = "Linear Search",
        description = "In this type of search, a sequential search is made over all items one by one. Every item is checked and if a match is found then that particular item is returned, otherwise the search continues till the end of the data structure.",
        body = "# If you want to implement Linear Search in python \n" +
            "  \n" +
            "# Linearly search x in arr[] \n" +
            "# If x is present then return its location \n" +
            "# else return -1 \n" +
            "  \n" +
            "def search(arr, x): \n" +
            "  \n" +
            "    for i in range(len(arr)): \n" +
            "  \n" +
            "        if arr[i] == x: \n" +
            "            return i \n" +
            "  \n" +
            "    return -1"
    ), AlgorithmResponse(
        id = "",
        title = "Quick Sort",
        description = "Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting.",
        body = "def QuickSort(mList):\n" +
            "    elements = len(mList)\n" +
            "\n" +
            "    # Base case\n" +
            "    if elements < 2:\n" +
            "        return mList\n" +
            "\n" +
            "    current_position = 0  # Position of the partitioning element\n" +
            "\n" +
            "    for i in range(1, elements):  # Partitioning loop\n" +
            "        if mList[i] <= mList[0]:\n" +
            "            current_position += 1\n" +
            "            temp = mList[i]\n" +
            "            mList[i] = mList[current_position]\n" +
            "            mList[current_position] = temp\n" +
            "\n" +
            "    temp = mList[0]\n" +
            "    mList[0] = mList[current_position]\n" +
            "    mList[current_position] = temp  # Brings pivot to it's appropriate position\n" +
            "\n" +
            "    left = QuickSort(mList[0:current_position])  # Sorts the elements to the left of pivot\n" +
            "    right = QuickSort(mList[current_position + 1:elements])  # sorts the elements to the right of pivot\n" +
            "\n" +
            "    mList = left + [mList[current_position]] + right  # Merging everything together\n" +
            "\n" +
            "    return mList\n"
    ), AlgorithmResponse(
        id = "",
        title = "Binary Search",
        description = "Binary Search is a search algorithm that finds the position of a target value within a sorted array.[4][5] Binary search compares the target value to the middle element of the array. If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half, again taking the middle element to compare to the target value, and repeating this until the target value is found. If the search ends with the remaining half being empty, the target is not in the array.",
        body = "def binary_search(mList, element):\n" +
            "    mid = 0\n" +
            "    start = 0\n" +
            "    end = len(mList)\n" +
            "    step = 0\n" +
            "\n" +
            "    while start <= end:\n" +
            "        print(\"SubmList in step {}: {}\".format(step, str(mList[start:end + 1])))\n" +
            "        step = step + 1\n" +
            "        mid = (start + end) // 2\n" +
            "\n" +
            "        if element == mList[mid]:\n" +
            "            return mid\n" +
            "\n" +
            "        if element < mList[mid]:\n" +
            "            end = mid - 1\n" +
            "        else:\n" +
            "            start = mid + 1\n" +
            "    return -1\n"
    ), AlgorithmResponse(
        id = "",
        title = "",
        description = "",
        body = ""
    )
)