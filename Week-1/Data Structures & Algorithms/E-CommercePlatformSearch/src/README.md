# 🔍 1. Understand the Problem
📌 Why is Search Optimization Important?
In an e-commerce platform:

Users frequently search for products by name or category.

If you store thousands of products, a slow search will hurt user experience.

Choosing the right algorithm and structure makes searches faster and scalable.

🧠 Role of Asymptotic Notation (Big O)
Helps measure the efficiency of algorithms, especially as data grows.

Linear Search → O(n) → checks each item one-by-one

Binary Search → O(log n) → divides search space in half each time
🔸 Requires a sorted array to work

# 📊 4. Analysis

| Search Type   | Time Complexity | Requirement       | Suitability             |
| ------------- | --------------- | ----------------- | ----------------------- |
| Linear Search | O(n)            | No sorting needed | Best for small datasets |
| Binary Search | O(log n)        | Requires sorting  | Best for large datasets |


🔍 Which to use?
For smaller or unsorted product arrays → use Linear Search

For large sorted product arrays → Binary Search is much faster


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=50404" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Data Structures & Algorithms\E-CommercePlatformSearch\out\production\E-CommercePlatformSearch" app.SearchApp
Enter number of products: 3

Enter details for product 1
Product ID: 49291
Product Name: Pens
Category: Stationary

Enter details for product 2
Product ID: 58042
Product Name: Chips
Category: Hardware

Enter details for product 3
Product ID: 94820
Product Name: Clothes
Category: Fashion

Enter product name to search (Linear Search): clothes
Found using Linear Search: [ID: 94820, Name: Clothes, Category: Fashion]

Enter product name to search (Binary Search): chips
Found using Binary Search: [ID: 58042, Name: Chips, Category: Hardware]

Process finished with exit code 0
