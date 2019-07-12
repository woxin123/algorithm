# Leetcode 之GO

|题号|题目|解法|时间|
----|----|---|---|
|[46](leetcode46.go)|全排列|回溯法|2019-06-25|
|[141](leetcode141.go)|环形链表|快慢指针|2019-07-04|
|[142](leetcode142.go)|环形链表II|快慢指针|2019-07-04|
|[146](leetcode146.go)|LRU缓存机制|链表|2019-07-05|
|[232](leetcode232.go)|用栈实现队列|无|2019-07-06|

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