# 📊 4. Analysis

| Role            | Class                                  |
| --------------- | -------------------------------------- |
| Strategy        | `SortStrategy`                         |
| Concrete Strats | `BubbleSort`, `MergeSort`, `QuickSort` |
| Context         | `SortContext`                          |
| Client          | `SortApp`                              |


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=51067" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\StrategyPattern\out\production\StrategyPattern" app.SortApp

Enter size of array: 5
Enter array elements:
12
14
16
22
65

Choose sorting strategy:
1. Bubble Sort
2. Merge Sort
3. Quick Sort
1
Using Bubble Sort...
Sorted Array: [12, 14, 16, 22, 65]


Enter size of array: 5
Enter array elements:
38
29
1
47
84

Choose sorting strategy:
1. Bubble Sort
2. Merge Sort
3. Quick Sort
2
Using Merge Sort...
Sorted Array: [1, 29, 38, 47, 84]

Enter size of array: 5
Enter array elements:
28
19
56
11
47

Choose sorting strategy:
1. Bubble Sort
2. Merge Sort
3. Quick Sort
3
Using Quick Sort...
Sorted Array: [1, 19, 28, 47, 56]

Process finished with exit code 0

