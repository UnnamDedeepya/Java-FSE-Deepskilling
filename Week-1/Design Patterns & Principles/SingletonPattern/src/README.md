# 🔄 1. Understand the Problem

🎯 Why Singleton?

You need one consistent Logger instance (e.g., shared log file, consistent output).

Avoid creating multiple Logger objects, which can lead to duplicated or inconsistent logs.

✅ Key Rules of Singleton:

Private static instance of the class

Private constructor

Public static method that returns the same instance

# 📊 4. Analysis

| Feature         | Value                               |
| --------------- | ----------------------------------- |
| Design Pattern  | Singleton                           |
| Ensures         | Only one object ever exists         |
| Use Case        | Logging, config management, caching |
| Time Complexity | O(1) for access                     |
| Limitation      | Not thread-safe (in basic version)  |


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=49482" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\SingletonPattern\out\production\SingletonPattern" app.LoggerTestApp

Logger initialized.

[LOG] Application started

[LOG] Database connection opened

Checking if both loggers are same: true

Process finished with exit code 0
