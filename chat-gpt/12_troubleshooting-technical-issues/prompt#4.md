# how to remove jdk from jenv? is it enough to delete globally?

Great question. Removing a JDK from `jenv` involves a bit more than just deleting the system JDK directory — because `jenv` uses **symlinks** to manage the versions, you should also clean up those links to keep it tidy.

---

## ✅ To remove a JDK from `jenv` properly:

### 🔹 Step 1: Find the installed JDKs in `jenv`

```bash
jenv versions
```

Example output:

```
  11.0.25
  11.0.27
* 24.0.1 (set by /Users/asem/.jenv/version)
```

These versions are stored in:

```bash
~/.jenv/versions/
```

---

### 🔹 Step 2: Remove the JDK from `jenv`

You can safely remove the version like this:

```bash
rm -rf ~/.jenv/versions/11.0.25
```

Do the same for any other version you want to remove.

---

### 🔹 Step 3: (Optional) Delete the actual JDK from disk

You can also remove the physical JDK install (to free up space):

```bash
rm -rf /Users/asem/Library/Java/JavaVirtualMachines/corretto-11.0.25
```

> ⚠️ Be 100% sure you're removing the correct directory — double-check with `/usr/libexec/java_home -V`.

---

### ✅ Summary

| Task                          | Command                                            |
| ----------------------------- | -------------------------------------------------- |
| Remove from jenv              | `rm -rf ~/.jenv/versions/<version>`                |
| Remove from system (optional) | `rm -rf /path/to/JavaVirtualMachines/<jdk-folder>` |
| Refresh jenv                  | `jenv rehash`                                      |

---

Let me know if you'd like a script to list and remove multiple unused versions safely.

