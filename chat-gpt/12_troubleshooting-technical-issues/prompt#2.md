# when I click ls no jdks are displayed


If you ran:

```bash
cd /Library/Java/JavaVirtualMachines
ls
```

and **nothing was listed**, that likely means:

1. **There are no JDKs installed in the global `/Library/Java/JavaVirtualMachines` directory**, or
2. **Your JDKs are installed in your user directory instead**.

Let’s investigate further.

---

### ✅ Step 1: Check where JDKs are actually installed

Run:

```bash
/usr/libexec/java_home -V
```

This will output something like:

```
Matching Java Virtual Machines (2):
    17.0.2 (x86_64) "Oracle Corporation" - "/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home"
    11.0.10 (x86_64) "AdoptOpenJDK"     - "/Users/yourname/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home"
```

This shows the **exact install paths** of each JDK.

---

### ✅ Step 2: Delete JDKs from their actual location

If a JDK is in your user directory (e.g., `~/Library/Java/JavaVirtualMachines`), you can remove it like this:

```bash
cd ~/Library/Java/JavaVirtualMachines
ls
```

Then delete any unused ones:

```bash
rm -rf <jdk-folder-name>
```

For example:

```bash
rm -rf adoptopenjdk-11.jdk
```

If it’s in the **system directory** (`/Library/...`), you’ll need `sudo`:

```bash
sudo rm -rf /Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk
```

---

### ✅ Step 3: Verify

After deletion, re-run:

```bash
/usr/libexec/java_home -V
```

---

Let me know what output you see from `java_home -V` and I can guide you on what to safely remove.

