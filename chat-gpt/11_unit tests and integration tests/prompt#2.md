# I've heard about Test-Driven Development (TDD) and want to try it in my Java project. Can you explain the process and provide an example of how to apply TDD in practice?

Absolutely! Test-Driven Development (TDD) is a powerful software development approach that helps improve code quality and design. It’s widely used in Java and fits very well with frameworks like **JUnit** and **Mockito**.

---

## ✅ What is TDD?

**Test-Driven Development (TDD)** is a development process where you:

1. **Write a failing test first** (based on requirements).
2. **Write the minimum code** to make the test pass.
3. **Refactor** the code while keeping tests green.

This cycle is often called **Red-Green-Refactor**:

```
1. Red     → Write a test that fails (no code yet)
2. Green   → Write just enough code to pass the test
3. Refactor→ Clean up the code, keep all tests passing
```

---

## 🛠️ Tools You Need for Java TDD

* **JUnit 5** – for writing and running tests
* **Mockito** – for mocking dependencies
* **Your build tool (Maven or Gradle)**

---

## 🔍 Example: TDD in a Simple Java Project

Let’s say you're building a service that calculates discounts.

### Step 1: Write a Failing Test (Red)

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    @Test
    void shouldReturn10PercentDiscountForPremiumCustomers() {
        DiscountService service = new DiscountService();

        double discount = service.calculateDiscount("premium", 100.0);

        assertEquals(10.0, discount);  // expecting 10% of 100
    }
}
```

At this point, `DiscountService` doesn’t even exist yet — the test fails to compile or run.

---

### Step 2: Make the Test Pass (Green)

Create just enough code to make the test pass:

```java
public class DiscountService {

    public double calculateDiscount(String customerType, double amount) {
        if ("premium".equalsIgnoreCase(customerType)) {
            return amount * 0.10;
        }
        return 0.0;
    }
}
```

Now the test passes ✅

---

### Step 3: Refactor

* Clean up code if needed (naming, constants, etc.)
* Add more tests to handle other customer types:

```java
@Test
void shouldReturn0DiscountForRegularCustomers() {
    DiscountService service = new DiscountService();
    double discount = service.calculateDiscount("regular", 100.0);
    assertEquals(0.0, discount);
}
```

Update your production code accordingly, still following the Red-Green-Refactor cycle.

---

## 🧠 Benefits of TDD

* **Better design** (forces modular, testable code)
* **Fewer bugs** (catches issues early)
* **Safer refactoring**
* **Better documentation** (tests describe expected behavior)

---

## 🚀 Tip: Use TDD With Spring Boot

In a Spring Boot app, you can:

* Use `@WebMvcTest` for controller tests
* Use `@MockBean` to inject mocks
* Write tests first, drive the development of services, controllers, and repositories

---

Would you like a TDD example using **Spring Boot** and REST APIs?
