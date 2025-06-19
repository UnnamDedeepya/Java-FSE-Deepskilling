# 🔄 1. Understand the Problem

🎯 Real-World Scenario:
In a digital library, users need to find books by title. You want to:

Search efficiently in unsorted and sorted book data

Know when to use Linear Search (O(n)) vs Binary Search (O(log n))


# 📊 4. Analysis

| Algorithm     | Time Complexity | Best Use Case              |
| ------------- | --------------- | -------------------------- |
| Linear Search | O(n)            | Small or unsorted datasets |
| Binary Search | O(log n)        | Sorted datasets            |

⚠️ Binary Search Caveat:
You must sort the data first

Comparison must be consistent and case-insensitive

# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=65113" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Data Structures & Algorithms\LibraryManagement\out\production\LibraryManagement" app.LibraryApp
Enter number of books: 4

Enter details for Book 1
Book ID: 2901
Title: Linear Algebra & Differentiation Equations
Author: K.Ramakrishnan

Enter details for Book 2
Book ID: 2903
Title: VLSN
Author: Acharya Chaterjii

Enter details for Book 3
Book ID: 8920
Title: Data Structures & Algorithms
Author: Ramesh Varma

Enter details for Book 4
Book ID: 2838
Title: Data Analysis
Author: Praveen Kumar

Enter book title to search (Linear Search): Data ANalysis
Found using Linear Search: [ID: 2838, Title: Data Analysis, Author: Praveen Kumar]

Enter book title to search (Binary Search): Data Structures & ALgorithms
Found using Binary Search: [ID: 8920, Title: Data Structures & Algorithms, Author: Ramesh Varma]

Process finished with exit code 0
