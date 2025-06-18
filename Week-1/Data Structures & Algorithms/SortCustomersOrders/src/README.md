# 🧠 1. Understand the Problem

In an e-commerce platform:

You may need to sort orders by their total price to prioritize high-value orders.

Sorting allows better display, reporting, and business intelligence.

📌 Why compare sorting algorithms?
Bubble Sort is simple but inefficient → O(n²)

Quick Sort is efficient and widely used → average O(n log n)

Understanding both helps you:

Learn basic sorting logic

Decide which to use based on the dataset


# 📊 4. Analysis
Sorting Algorithm 	Time Complexity	    Stable	    In-place	         Notes

  Bubble Sort	           O(n²)	          Yes	         Yes	      Simple but slow
  
  Quick Sort	    O(n log n)avg case	    No	         Yes	   Fast but needs recursion

🚀 Why Quick Sort is Preferred:
Performs better with large data

More scalable

Less memory use compared to Merge Sort


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=63132" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Data Structures & Algorithms\SortingCustomerOrders\out\production\SortingCustomerOrders" app.OrderApp
Enter number of orders: 5

Enter details for Order 1
Order ID: 121
Customer Name: Dedeepya
Total Price: 120

Enter details for Order 2
Order ID: 122
Customer Name: Yamini
Total Price: 200

Enter details for Order 3
Order ID: 123
Customer Name: Akshaya
Total Price: 210

Enter details for Order 4
Order ID: 4
Customer Name: Kathyayini
Total Price: 160

Enter details for Order 5
Order ID: 5
Customer Name: Bhuvana
Total Price: 500

Sorted Orders by Bubble Sort:
[OrderID: 121, Customer: Dedeepya, Total: ₹120.0]
[OrderID: 4, Customer: Kathyayini, Total: ₹160.0]
[OrderID: 122, Customer: Yamini, Total: ₹200.0]
[OrderID: 123, Customer: Akshaya, Total: ₹210.0]
[OrderID: 5, Customer: Bhuvana, Total: ₹500.0]

Sorted Orders by Quick Sort:
[OrderID: 121, Customer: Dedeepya, Total: ₹120.0]
[OrderID: 4, Customer: Kathyayini, Total: ₹160.0]
[OrderID: 122, Customer: Yamini, Total: ₹200.0]
[OrderID: 123, Customer: Akshaya, Total: ₹210.0]
[OrderID: 5, Customer: Bhuvana, Total: ₹500.0]

Process finished with exit code 0
