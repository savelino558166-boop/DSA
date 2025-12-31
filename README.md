# House Robber — Dynamic Programming Problem

##  **Context**

John is a meticulous thief planning his next heist on a street where houses are lined up in a row. Each house contains a certain amount of money. However, adjacent houses are connected by a security system — robbing two neighboring houses triggers the alarm. Your task is to help John maximize the total loot **without robbing two adjacent houses**.

---

## **Problem Statement**

Given an array of non-negative integers where each element represents the amount of money in a house, determine the **maximum amount of money** that can be robbed **without robbing adjacent houses**.

---

## **Input Format**

A single line of **space-separated integers** representing the money in each house.

### Example Input

```
2 7 9 3 1
```

---

## **Output Format**

A **single integer** representing the maximum amount of money that can be robbed.

### Example Output

```
12
```

---

## **Examples**

| Input                 | Output |
| --------------------- | ------ |
| 1 2 3 1               | 4      |
| 2 7 9 3 1             | 12     |
| 2 1 4 5 3             | 9      |
| 1 2 3                 | 4      |
| 1                     | 1      |
| 5 1 1 5               | 10     |
| 4 1 2 6 8 1 3 9       | 24     |
| 0 0 0 0 0             | 0      |
| 10 5 2 8 15 7 3       | 35     |
| 11 1 1 1 1 1 1 1 1 11 | 22     |

---

## **Constraints**

* `1 <= nums.length <= 100`
* `0 <= nums[i] <= 400`
* All values are non-negative
* Adjacent houses **cannot** both be robbed

---

## **Solution Approach (Dynamic Programming)**

We use **dynamic programming** to ensure we always choose the best possible total at each step.

### **Core Idea**

Let `dp[i]` represent the maximum money that can be robbed **up to house i**.
For every house `i`, we have two choices:

 **Rob house i** → Add `nums[i]` + `dp[i-2]` (since we must skip the previous house)

 **Do NOT rob house i** → Take `dp[i-1]`

So the recurrence becomes:

```
dp[i] = max(nums[i] + dp[i-2], dp[i-1])
```

The answer will be stored in `dp[n-1]`.

---

## **Handling Edge Cases**

* If there are **no houses** → result is `0`
* If there is **only 1 house** → rob it

---

## Time & Space Complexity

* **Time Complexity:** `O(n)` — we traverse the list once
* **Space Complexity:** `O(n)` — due to DP array

 *Optimization:* Can be improved to `O(1)` space by only keeping the last two computed values.

---

## **Key Insights**

* Dynamic Programming is ideal for optimization problems built from overlapping subproblems.
* Identifying the recurrence relation is essential.
* Works similarly to resource allocation and scheduling problems.

---

## **Real-World Applications**

This logic applies to situations where adjacent selections are restricted, such as:

* Resource allocation
* Task scheduling with conflicts
* Choosing compatible investments or decisions

---

## Reference

Original problem context and explanation:
[https://www.dsaproblem.com/solution/dynamic-programming-problem/solve-the-house-robber-problem-where-adjacent-houses-cannot-be-robbed-and-you-need-to-maximize-the-loot](https://www.dsaproblem.com/solution/dynamic-programming-problem/solve-the-house-robber-problem-where-adjacent-houses-cannot-be-robbed-and-you-need-to-maximize-the-loot)

---
