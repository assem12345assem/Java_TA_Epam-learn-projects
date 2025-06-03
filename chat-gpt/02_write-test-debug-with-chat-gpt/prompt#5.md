# can you write a js function that gets text? (//label[text()='Degree information']/ancestor::div[2]//input)[2] in the console of firefox I would like to test

Absolutely! You want a JavaScript snippet you can paste into Firefox’s console that will:

* Find the element using the XPath `(//label[text()='Degree information']/ancestor::div[2]//input)[2]`
* Get the `value` (text) of that input element

Here’s a JS function for that:

```js
function getInputValueByXPath(xpath) {
  let result = document.evaluate(
    xpath,
    document,
    null,
    XPathResult.FIRST_ORDERED_NODE_TYPE,
    null
  );
  let element = result.singleNodeValue;
  return element ? element.value : null;
}

// Usage
let xpath = "(//label[text()='Degree information']/ancestor::div[2]//input)[2]";
console.log(getInputValueByXPath(xpath));
```

---

### How it works:

* `document.evaluate` runs the XPath query.
* `XPathResult.FIRST_ORDERED_NODE_TYPE` gets the first matching node.
* We check if the node exists; if yes, return its `value` (the text inside input).
* Otherwise return `null`.

---

### Paste the above into your Firefox console and it will print the input’s value!

If you want the **visible text content** (like for `<div>` or `<span>`), you’d use `.textContent` instead of `.value`.

---

If you want me to write a version that returns the element’s text content or innerText, just say!
