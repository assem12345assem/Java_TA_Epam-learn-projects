## Prompt: Please help me as an AI mentor. Encouraging you to practice: Finally, as a mentor, I can encourage you to practice your Java skills regularly and provide feedback on your progress. With regular practice and feedback, you can become a more skilled and knowledgeable Java developer. Can generate practical tasks on any topics to improve your coding skills.

Absolutely — I’d be glad to act as your AI mentor! Here’s a plan to help you practice and improve your Java skills through **focused, practical tasks**, especially around the **Java Streams API** (with other topics available on request).

---

### 🧠 **Today's Focus: Java Streams — Practical Task Series**

#### 🧪 Task 1: Filter and Transform

**Goal**: Use `Stream.filter()` and `Stream.map()` to clean and convert a list of data.

```java
List<String> names = Arrays.asList("Alice", "", "Bob", "Charlie", "", "David");

List<String> cleaned = names.stream()
    .filter(name -> !name.isEmpty())
    .map(String::toUpperCase)
    .collect(Collectors.toList());

System.out.println(cleaned); // Output: [ALICE, BOB, CHARLIE, DAVID]
```

👉 **Modify this task** to:

* Remove null values.
* Add a name length filter (e.g., only include names with more than 4 letters).

---

#### 🔁 Task 2: Grouping and Counting

**Goal**: Use `Collectors.groupingBy()` to count how many times each word appears.

```java
List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");

Map<String, Long> wordCount = words.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println(wordCount); // Output: {orange=1, banana=3, apple=2}
```

👉 **Extend this task** by:

* Sorting the map by values (frequency).
* Ignoring case sensitivity (`"Apple"` and `"apple"` should be the same).

---

#### 🔄 Task 3: Flat Mapping Nested Data

**Goal**: Use `flatMap()` to process a list of lists.

```java
List<List<String>> nestedList = Arrays.asList(
    Arrays.asList("A", "B"),
    Arrays.asList("C", "D"),
    Arrays.asList("E")
);

List<String> flatList = nestedList.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());

System.out.println(flatList); // Output: [A, B, C, D, E]
```

👉 **Challenge**:

* Flatten a list of sentences into a list of unique words.
* Remove punctuation and convert to lowercase.

---

#### 📅 Weekly Project Suggestion: "Mini Library System"

**Design a console app** that:

* Accepts a list of books (title, author, genre, year).
* Uses streams to:

    * Filter by genre/year.
    * Sort by author or title.
    * Group by author or genre.
    * Count books per genre.

---

### ✅ How I Can Help as Your Mentor:

* 📋 Review your solutions and give feedback.
* 🔄 Suggest ways to refactor or improve.
* 🧩 Give you harder or real-world tasks as you improve.
* 💡 Explain tough concepts in simple ways, anytime you’re stuck.

Would you like to start with one of the tasks above, or focus on another topic (like OOP, concurrency, or file I/O)?
