# does assert ng have a check that two List<String> have string equal checks for each entry?

Yes! **TestNG assertions** provide ways to check collections, but they don't have a built-in one-liner specifically for comparing two `List<String>` element-wise with nice messages. However, you can do this easily with:

### 1. `Assert.assertEquals(list1, list2)`

TestNG’s `assertEquals` for lists checks that:

* Both lists are the same size
* Corresponding elements are equal (using `equals()`)

So if you just want to verify two `List<String>` are exactly equal (same order, same strings), this works out of the box:

```java
Assert.assertEquals(list1, list2);
```

If they differ, it will throw an `AssertionError` showing expected and actual lists.

---

### 2. Custom message for better debugging (optional):

```java
Assert.assertEquals(list1, list2, "Lists are not equal!");
```

---

### 3. If order doesn't matter:

If order doesn't matter and you want to check that two lists have the same strings but possibly in different orders, you’d have to do something like:

```java
Assert.assertEqualsNoOrder(list1.toArray(), list2.toArray());
```

---

### Summary

* For element-wise equality in order:

  ```java
  Assert.assertEquals(list1, list2);
  ```
* For unordered equality:

  ```java
  Assert.assertEqualsNoOrder(list1.toArray(), list2.toArray());
  ```

---

Let me know if you want me to help with more detailed checks or custom assertions!
