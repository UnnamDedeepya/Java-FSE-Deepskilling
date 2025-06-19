# 🔄 1. Understand the Problem

🎯 Why Decorator Pattern?

You have a base feature (Email notification).

You want to add features dynamically (like SMS or Slack).

Instead of subclassing, you wrap existing objects with new functionality.


# 📊 4. Analysis

| Component           | Class                                            |
| ------------------- | ------------------------------------------------ |
| Interface           | `Notifier`                                       |
| Base Implementation | `EmailNotifier`                                  |
| Decorators          | `SMSNotifierDecorator`, `SlackNotifierDecorator` |
| Use Case            | Dynamically extend behavior                      |

✅ Why Use Decorator?

Follows Open/Closed Principle: open for extension, closed for modification

Combine features at runtime

Easy to add new channels (e.g., WhatsAppNotifierDecorator)


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=50385" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\DecoratorPattern\out\production\DecoratorPattern" app.NotificationApp

Choose additional channels:

1. Email only
2. Email + SMS
3. Email + Slack
4. Email + SMS + Slack
1

Enter message to send: Hello I'm Dedeepya

Sending Notification...

📧 Sending Email: Hello I'm Dedeepya

Process finished with exit code 0

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=50452" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Design Patterns & Principles\DecoratorPattern\out\production\DecoratorPattern" app.NotificationApp

Choose additional channels:

1. Email only
2. Email + SMS
3. Email + Slack
4. Email + SMS + Slack
2

Enter message to send: Hello Cognizant!!

Sending Notification...

📧 Sending Email: Hello Cognizant!!

📲 Sending SMS: Hello Cognizant!!

Process finished with exit code 0
