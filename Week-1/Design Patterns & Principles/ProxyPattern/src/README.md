# 🔄 1. Understand the Problem

🎯 Why Proxy Pattern?

Some objects (like high-res images or remote data) are resource-heavy to load.

You want a lightweight placeholder (proxy) that loads the real object only on demand.

Promotes lazy loading, access control, and performance.

# 📊 4. Analysis

| Role         | Class            |
| ------------ | ---------------- |
| Interface    | `Image`          |
| Real Object  | `RealImage`      |
| Proxy Object | `ProxyImage`     |
| Client       | `ImageViewerApp` |

✅ Benefits of Proxy Pattern

Lazy initialization: only loads image when needed

Improves performance

Protects access to costly resources

# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=50593" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\ProxyPattern\out\production\ProxyPattern" app.ImageViewerApp

--- Image Viewer ---
1. View Image 1
2. View Image 2
3. Exit
Choose option: 1
Loading image: pic1.jpg
Displaying image: pic1.jpg

--- Image Viewer ---
1. View Image 1
2. View Image 2
3. Exit
Choose option: 2
Loading image: pic2.jpg
Displaying image: pic2.jpg

--- Image Viewer ---
1. View Image 1
2. View Image 2
3. Exit
Choose option: 3
Exiting viewer.

Process finished with exit code 0
