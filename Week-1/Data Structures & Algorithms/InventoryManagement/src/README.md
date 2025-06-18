# 1.Understand the Problem

Q: Why are data structures and algorithms essential for handling large inventories?

Efficient storage: A proper data structure like HashMap or ArrayList allows quick access, updates, and deletion of inventory items.

Faster retrieval: Algorithms help retrieve and manage data quickly, crucial when inventory has thousands of products.

Optimization: With the right data structure, you avoid unnecessary time and space usage, improving system scalability.

Q: Suitable Data Structures

ArrayList: Good for dynamic size, easy traversal.

HashMap: Best for quick search/update/delete using productId as the key.

TreeMap: Maintains sorted order based on keys.


# 📈 3. Analysis

Time Complexity (HashMap-based):

addProduct – O(1)

updateProduct – O(1)

deleteProduct – O(1)

displayInventory – O(n)

Optimization Discussion:

If productId is always numeric and sequential, using an ArrayList may suffice.

Use a database for persistence if data grows beyond in-memory limits.

# Output of the code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=49726" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Data Structures & Algorithms\InventoryManagement\out\production\InventoryManagement" app.InventoryApp

--- Inventory Menu ---
1. Add Product
2. Update Product
3. Delete Product
4. View Inventory
5. Exit
Select option: 1
Product ID: 39019
Product Name: Stationary
Quantity: 20
Price: 10
Product added.

--- Inventory Menu ---
1. Add Product
2. Update Product
3. Delete Product
4. View Inventory
5. Exit
Select option: 4
[ID: 39019, Name: Stationary, Qty: 20, Price: ₹10.0]

--- Inventory Menu ---
1. Add Product
2. Update Product
3. Delete Product
4. View Inventory
5. Exit
Select option: 5
Exiting system.

Process finished with exit code 0

