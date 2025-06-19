# 🔄 1. Understand the Problem

🎯 Why Factory Method?

You want to encapsulate object creation logic.

Clients don’t need to know how the object is created—just use the factory.

Makes it easy to add new types without changing existing logic.


# 📊 4. Analysis

| Component            | Role                       |
| -------------------- | -------------------------- |
| `Document`           | Product Interface          |
| `WordDocument`, etc. | Concrete Products          |
| `DocumentFactory`    | Creator (Abstract Factory) |
| `WordFactory`, etc.  | Concrete Factories         |
| `DocumentApp`        | Client code using factory  |

Benefits:

Loose coupling between client and concrete document types

Easy extensibility (add PowerPointFactory, etc.)

Single Responsibility Principle – each class does one thing


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=50222" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\AdapterPattern\out\production\AdapterPattern" app.PaymentApp

Enter amount to pay: ₹2000

Choose payment method:
1. PayPal
2. Stripe
   
1
Payment of ₹2000.0 made via PayPal.

Process finished with exit code 0

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=50247" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\AdapterPattern\out\production\AdapterPattern" app.PaymentApp

Enter amount to pay: ₹3500

Choose payment method:
1. PayPal
2. Stripe
   
2
Payment of ₹3500.0 made via Stripe.

Process finished with exit code 0
