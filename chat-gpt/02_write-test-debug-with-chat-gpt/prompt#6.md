# I've got empty string <empty string> and undefined.

If you’re getting `""` (empty string) or `undefined` when running the JS to get the input’s value, here are possible reasons and how to fix them:

---

### 1. Element not found (undefined)

* The XPath might be incorrect or the element does not exist.
* `document.evaluate(...).singleNodeValue` is `null`, so you get `undefined`.

### 2. Element found but `value` is empty string (`""`)

* The input exists but has no value set (empty input box).
* Or maybe the value is in a different attribute or a sibling element.

---

### How to debug:

Run this snippet in the console:

```js
let xpath = "(//label[text()='Degree information']/ancestor::div[2]//input)[2]";
let result = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);
let element = result.singleNodeValue;

if (!element) {
  console.log("No element found for XPath");
} else {
  console.log("Element found:", element);
  console.log("Value:", element.value);
  console.log("InnerText:", element.innerText);
  console.log("TextContent:", element.textContent);
}
```

---

### What to check next:

* If **No element found** appears, your XPath is wrong or the page hasn’t loaded the element yet.
* If element found but `value` is empty, check if the text you want is in:

    * `.placeholder`
    * `.getAttribute('value')` (sometimes)
    * Sibling or parent element’s text (not the input itself)

---

### Example if the text is in the placeholder:

```js
console.log("Placeholder:", element.getAttribute('placeholder'));
```

---

### If the input is a custom widget (like React-controlled input), value might be in other properties — let me know the HTML snippet and I can tailor the code.

---

Feel free to share the element’s HTML snippet if you want me to dig deeper!
