# 🔄 1. Understand the Problem

🎯 Why Linked Lists?
Arrays have fixed size and shifting costs (O(n) for delete).

Linked Lists:

Grow/shrink dynamically

Add/delete in O(1) if pointer is known

Suitable for task lists, queues, etc.

🧠 Types of Linked Lists:
Singly Linked List (this task)

Doubly Linked List

Circular Linked List

# 📊 4. Analysis

| Operation      | Time Complexity |
| -------------- | --------------- |
| Add Task       | O(n) (at end)   |
| Search Task    | O(n)            |
| Delete Task    | O(n)            |
| Traverse Tasks | O(n)            |

🧠 Linked List Advantages over Array:
Dynamically resizable

No need to shift elements during delete

Good for insertion/deletion at start/middle

# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=64257" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Data Structures & Algorithms\TaskManagement\out\production\TaskManagement" app.TaskApp

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 1
Task ID: 1
Task Name: assignments
Status: 50% done
Task added.

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 1
Task ID: 2
Task Name: exam revision
Status: 70% done
Task added.

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 1
Task ID: 3
Task Name: project
Status: 85% done
Task added.

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 2
Enter Task ID to search: 2
Task found: [ID: 2, Name: exam revision, Status: 70% done]

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 4
[ID: 1, Name: assignments, Status: 50% done]

[ID: 2, Name: exam revision, Status: 70% done]

[ID: 3, Name: project, Status: 85% done]

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 3
Enter Task ID to delete: 1
Task deleted.

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 4
[ID: 2, Name: exam revision, Status: 70% done]

[ID: 3, Name: project, Status: 85% done]

--- Task Menu ---
1. Add Task
2. Search Task
3. Delete Task
4. View All Tasks
5. Exit
Choose option: 5
Exiting...

Process finished with exit code 0
