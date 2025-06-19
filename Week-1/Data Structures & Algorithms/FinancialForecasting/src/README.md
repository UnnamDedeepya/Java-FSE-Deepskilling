# 🔄 1. Understand the Problem

🎯 Scenario:

You’re building a financial forecasting tool to predict future revenue (or value) based on:

A starting value

A fixed growth rate (percentage)

A number of periods (months/years)

For example:
"₹10,000 grows by 10% per year for 3 years → What is the forecasted value?"

🧠 Why Recursion?

Recursion is a method that calls itself to break problems into smaller parts.

Useful when future values depend on previous ones.

Easy to write but may cause stack overflows or inefficiencies for deep recursions.


# 📊 4. Analysis

| Method           | Time Complexity | Notes                                     |
| ---------------- | --------------- | ----------------------------------------- |
| Recursive        | O(n)            | Easy to implement, risk of stack overflow |
| Optimized (Math) | O(1)            | Fast and preferred for large inputs       |

⚠️ Recursive Risks:

Stack overflow on large n

Redundant calculations if not optimized


# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=65374" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Data Structures & Algorithms\FinancialForecasting\out\production\FinancialForecasting" app.ForecastApp

Enter starting amount (₹): 2000

Enter growth rate (%): 6

Enter number of periods (years): 10


📈 Forecasted Value (Recursive): ₹3581.70

⚡ Forecasted Value (Optimized): ₹3581.70

Process finished with exit code 0
