# 🔄 1. Understand the Problem

🎯 Why Builder Pattern?

When creating complex objects with optional parameters.

Prevents a telescoping constructor (i.e., multiple overloaded constructors).

Ensures readable, flexible, and safe object creation.


# 📊 4. Analysis

| Feature            | Description                                     |
| ------------------ | ----------------------------------------------- |
| Pattern            | Builder                                         |
| Strength           | Constructs objects with **optional attributes** |
| Constructor safety | Prevents misuse (e.g., wrong order/overloads)   |
| Extensibility      | Easy to add more parts (add cooling, PSU, etc.) |
| Clean client code  | Fluent and readable (`.os("Ubuntu").build()`)   |


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=49990" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\BuilderPattern\out\production\BuilderPattern" app.ComputerBuilderTestApp

🖥️ Basic Configuration:

Computer [CPU=Intel i5, RAM=8GB, Storage=null, Graphics Card=null, OS=null]

🎮 Gaming Configuration:

Computer [CPU=Intel i9, RAM=32GB, Storage=1TB SSD, Graphics Card=NVIDIA RTX 4080, OS=Windows 11 Pro]

💻 Developer Workstation:

Computer [CPU=AMD Ryzen 9, RAM=64GB, Storage=2TB SSD, Graphics Card=Integrated, OS=Ubuntu 24.04 LTS]

Process finished with exit code 0
