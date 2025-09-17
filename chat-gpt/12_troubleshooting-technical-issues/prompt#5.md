# globally, I am using a version I want, but when I check version in IDE project, it says  asem@Asems-MacBook-Air Java_TA_Epam-learn-projects % java -version
openjdk version "17.0.15" 2025-04-15
OpenJDK Runtime Environment Homebrew (build 17.0.15+0)
OpenJDK 64-Bit Server VM Homebrew (build 17.0.15+0, mixed mode, sharing)

Ah, you're seeing a **discrepancy between your global `jenv` setting and the Java version being used in your IDE/project terminal.** This is very common, especially when tools like Homebrew or the IDE are bypassing your shell environment.

Let’s break down what’s happening and how to fix it.

---

## 🔍 Why you're seeing this:

* You set Java globally via `jenv`, but...
* You're inside a **project or shell where Homebrew-installed Java (17.0.15)** is taking precedence.
* Your shell or IDE might **not be sourcing `jenv` correctly**, or might be launching with a **non-login shell** (ignoring your `.zshrc`, `.bash_profile`, etc.).

---

## ✅ Step-by-step Fix

### 🔹 1. **Check what's being used in that terminal/project**

Run:

```bash
which java
```

If it returns:

```
/opt/homebrew/bin/java
```

That means you're using the Homebrew-installed Java, not one managed by `jenv`.

---

### 🔹 2. **Check environment variables**

Run this to see what's being exported:

```bash
echo $JAVA_HOME
```

If it's set to something like `/opt/homebrew/opt/openjdk@17`, it confirms Homebrew is overriding.

---

### 🔹 3. **Fix it: Ensure `jenv` is properly initialized**

Make sure your shell config (`~/.zshrc` or `~/.bash_profile`) contains:

```bash
export PATH="$HOME/.jenv/bin:$PATH"
eval "$(jenv init -)"
```

Then restart your terminal or run:

```bash
source ~/.zshrc  # or ~/.bash_profile
```

---

### 🔹 4. **Enable `jenv export` plugin (critical!)**

This ensures `JAVA_HOME` is correctly set when switching versions.

```bash
jenv enable-plugin export
```

Then rehash and verify:

```bash
jenv rehash
jenv versions
java -version
```

Now it should reflect your `jenv global` version.

---

### 🔹 5. **Fixing in IDE (e.g., IntelliJ, VSCode)**

IDE terminals might not load your shell config properly.

#### 👉 IntelliJ:

* Go to **Preferences > Tools > Terminal**

* Set “Shell path” to something like:

  ```bash
  /bin/zsh -l
  ```

  (The `-l` makes it a login shell, which loads `.zshrc`)

* Restart the terminal in the IDE

#### 👉 VSCode:

* Set terminal to use login shell in `settings.json`:

```json
"terminal.integrated.defaultProfile.osx": "zsh",
"terminal.integrated.profiles.osx": {
  "zsh": {
    "path": "/bin/zsh",
    "args": ["-l"]
  }
}
```

---

## ✅ Optional: Remove Homebrew Java if unnecessary

If you don’t need the Homebrew version:

```bash
brew uninstall openjdk@17
```

And relink any other installed versions.

---

Let me know which IDE you're using if you want help adjusting its terminal settings.
