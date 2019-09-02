# Leetcode 之GO

|题号|题目|解法|时间|
----|----|---|---|
|[5](leetcode5.go)|最长回文字串|动态规划|2019-08-04|
|[9](leetcode9/leetcode9.go)|回文数|无|2019-08-05|
|[45](leetcode55/jump.go)|跳跃游戏II|贪心算法|2019-09-02|
|[46](leetcode46.go)|全排列|回溯法|2019-06-25|
|[55](leetcode55/canjump.go)|跳跃游戏|贪心算法|2019-09-02|
|[141](leetcode141.go)|环形链表|快慢指针|2019-07-04|
|[142](leetcode142.go)|环形链表II|快慢指针|2019-07-04|
|[146](leetcode146.go)|LRU缓存机制|链表|2019-07-05|
|[130](leetcode130.go)|被围绕的区域|dfs|2019-07-29|
|[135](leetcode135.go)|分发糖果|贪心算法|2019-09-02|
|[228](leetcode228.go)|汇总区间|无|2019-07-30|
|[232](leetcode232.go)|用栈实现队列|无|2019-07-06|
|[455](leetcode455/assign_cookies.go)|分配饼干|贪心|2019-08-25

###### 5 最长回文字串

动态规划的解法，dp[l][r] 表示字符串 l 到 r 的字串能组成一个回文串。

递推公式：

```
dp[l][r] = (s[l] == s[r] && (l - r >= -2 || dp[l + 1][r - 1]))
```

[参考链接](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/)

###### 6 回文数

###### 45 55 跳跃游戏 跳跃游戏II

每次跳跃到能跳到下次跳跃的最大的地方。贪心

利用数字转换成字符串求解，当然还有直接用数字的解法。

###### 135 分发糖果

如何判断 i 位置需要多少糖果，我们需要处理有三种情况:

ratings[i - 1] == ratings[i]，那么我们只需要 1 糖果

![](https://pic.leetcode-cn.com/b8a0cf64abf988bef3da02801e81cf1580a9a18b0e96d6ba6b47b2c5b06f8bae-1563430973450.png)

ratings[i - 1] < ratings[i]，那么我们只需要比前一个多一块糖果

![](https://pic.leetcode-cn.com/669cf8f3db923ebaf4aac369f579c2348c245862e7f649260c7c50146aa99dd4-1563431091961.png)

ratings[i - 1] > ratings[i]，和之前的情况相反，rating[i-1] 的糖果应该比 ratings[i] 多一颗。

可以先给每个人分一颗，从左向右依次判断递增，如果递增了，就给后面的糖果比前面的多一颗糖果，接下来再建立一个数组从右向左依次判断递增，如果出现递增的情况，就给前面的糖果比后面的糖果多一颗，接下来两个数组同一个位置中的最大值作为该处的值。这样既处理的递增的情况有处理了递减的情况。

###### 142 环形链表

由

![](https://pic.leetcode-cn.com/99987d4e679fdfbcfd206a4429d9b076b46ad09bd2670f886703fb35ef130635-image.png)

有 2(F + a) = F + a + b + a

得 F = b

###### 146 LRU 缓存机制

通过链表来进行操作

对于Get操作，首先查看是否存在，如果存在那个将那个节点移动到队首

对于Put操作，首先查看是否存在，如果存在，更新，然后将节点移动到队首，如果不存在，那么查看队列是否已经满了，如果满了，则产出队尾的元素

###### 147 用栈实现队列

入队的时候，总是把新元素压入s1的栈顶，同时把压入栈顶的第一个元素赋给队首元素的 front 变量。

```java
private Stack s1 = new Stack();
private Stack s2 = new Stack();
Integer front;

public void push(int x) {
    if (s1.isEmpty()) {
        front = x;
    }
    s1.push(x);
}
```

出队是算法的核心，出队的时候，把栈s1里面的元素弹出到栈s2中，然后从s2中弹出一个元素。s2里面记录栈顶的元素就是队首的元素，然后从栈s2里面弹出一个元素。

```java
public void pop() {
    if (s2.isEmpty()) {
        while(!s1.isEmpty() {
            s2.push(s1.pop());
        }
    }
}
```

获取队首元素就比较简单了，如果栈s2是空的，那么就是front，否则就是s2的栈顶元素。

```java
public int peek() {
    if (!s2.isEmpty()) {
        return s2.peek();
    }
    return front;
}
```

###### 130 被围绕的区域

这道题主要一个突破点在于，至于含边界的 `O` 才是不被围绕的。

