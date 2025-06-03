# I have to roll back changes which cause issues and I still need to keep some new functionality. What is the best approach to do that with Git.

Great question. Rolling back **only the problematic changes** while **keeping desired new functionality** is a common situation in team development — and Git provides a few powerful ways to handle it, depending on your context.

---

## ✅ **Best Approach Overview**

| Goal                           | Recommended Tool                            |
| ------------------------------ | ------------------------------------------- |
| Undo specific commits          | `git revert`                                |
| Remove specific file changes   | `git checkout` or `git restore`             |
| Keep some parts, drop others   | Manual cherry-picking or interactive rebase |
| Reset branch to earlier commit | `git reset` (careful – destructive)         |

---

## 🧠 Common Scenario

You merged a feature branch or PR to `develop` or `main`, and now you realize:

* Some parts (e.g. buggy UI or logic) must be **rolled back**
* Some other parts (e.g. refactoring or logging) are **good and must stay**

---

## 🛠️ Recommended Approach: **Revert + Cherry-Pick (Safe & Targeted)**

### Step 1: Identify the commits

Use `git log` or a visual Git tool to identify the commits you want to **revert** and the ones to **keep**.

```bash
git log --oneline
```

---

### Step 2: Revert the problematic commits

Use `git revert` to safely **undo** changes without deleting commit history:

```bash
git revert <bad_commit_hash>
```

Repeat as needed for multiple commits. This creates new commits that **undo** the changes.

> ✅ Reverting is safe even on shared branches (`main`, `develop`).

---

### Step 3: If needed, cherry-pick good changes from another branch

If you rolled back a whole branch but want to keep parts:

```bash
git cherry-pick <good_commit_hash>
```

This will **replay** the commit onto your current branch.

---

## 🧪 Alternative: Manual Selective Revert via Diff Tool

1. Create a new branch off the current `main` or `develop`.
2. Use `git checkout <hash> -- path/to/file` to bring back older versions of specific files.
3. Stage and commit the changes.

Example:

```bash
git checkout abc123 -- src/main/java/com/example/BuggyService.java
```

---

## 🚨 Dangerous but Useful: `git reset`

If you're in a local-only situation and want to completely nuke the last few commits:

```bash
git reset --hard HEAD~2  # Danger: removes last 2 commits and working changes!
```

Then push with force:

```bash
git push origin branch-name --force
```

> ❌ **Avoid `reset --hard` on shared branches** unless you're *absolutely sure*.

---

## 🧩 Tip: Use Tags or Branches to Save States

Before doing complex rollback:

```bash
git tag pre-revert-backup
# or
git branch backup-before-revert
```

This way, you can always return to the previous state if needed.

---

## 📝 Example Workflow

```bash
# 1. See recent commits
git log --oneline

# 2. Revert bad commit
git revert a1b2c3d4

# 3. Cherry-pick good change from reverted branch
git cherry-pick d4e5f6a7

# 4. Push changes
git push origin develop
```

---

Would you like help identifying commits to keep vs revert from your Git history (if you can paste it)?
