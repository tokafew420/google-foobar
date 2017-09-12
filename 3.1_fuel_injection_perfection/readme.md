Fuel Injection Perfection
=========================

Commander Lambda has asked for your help to refine the automatic quantum antimatter fuel injection system for her LAMBCHOP doomsday device. It's a great chance for you to get a closer look at the LAMBCHOP - and maybe sneak in a bit of sabotage while you're at it - so you took the job gladly. 

Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts of the LAMBCHOP each need to be fed fuel one pellet at a time. However, minions dump pellets in bulk into the fuel intake. You need to figure out the most efficient way to sort and shift the pellets down to a single pellet at a time. 

The fuel control mechanisms have three operations: 

1) Add one fuel pellet
2) Remove one fuel pellet
3) Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a quantum antimatter pellet is cut in half, the safety controls will only allow this to happen if there is an even number of pellets)

Write a function called answer(n) which takes a positive integer as a string and returns the minimum number of operations needed to transform the number of pellets to 1. The fuel intake control panel can only display a number up to 309 digits long, so there won't ever be more pellets than you can express in that many digits.

For example:  
answer(4) returns 2: 4 -> 2 -> 1  
answer(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1


Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:  
&nbsp;&nbsp;(string) n = "4"
Output:  
&nbsp;&nbsp;(int) 2

Inputs:  
&nbsp;&nbsp;(string) n = "15"
Output:  
&nbsp;&nbsp;(int) 5

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder

Solution
========

The first thing to notice is the operations that we are allowed to perform. Add 1, minus 1, and divide by 2. Doesn't that just scream BINARY!!! And it makes sense to tackle this problem in binary because it greatly simplifies the logic involved. We'll see this later on, but first how do we convert a numeric string into a binary array? For this I needed to consult with wikipedia.

Read here for the explanation on how to convert base-10 to base-2 by simply dividing by 2. https://en.wikipedia.org/wiki/Binary_number  
Ok great! But remember that the input can be up to 309 digits long, so be ready to manually divide numbers.

Let's work through a simple example to see the binary operations involved.

If the input is `"1480"`, the binary conversion will give us: `0101 1100 1000`

Our goal is to get down to: `0000 0000 0001`

We start looping through each digit from right to left. When we encounter a zero we'll divide by 2. After the first 3 iteration, we're left with:

```
operation count: 3
operations: /2 -> /2 -> /2
binary: 0000 1011 1001
```
You can see that dividing by zero shifts the binary to the right.

When the digit 1 is encountered, we must decide whether to add or subtract. Our decision will be based on whether the next digit (to the left) is 1 or 0. If the next digit is 0, then adding would carry the 1 to the next significant bit. This would then require an extra operation which goes against our goal of using the least number of operations.

So subtracting is the right choice:

```
operation count: 5
operaions: /2 -> /2 -> /2 -> -1 -> /2
binary: 0000 0101 1100
```
Note that after adding or subtracting we still need to divide by 2 to shift the binary to the right.

Let's continue to divide by 2 until we encounter the next 1 bit.

```
operation count: 7
operaions: /2 -> /2 -> /2 -> -1 -> /2 -> /2 -> /2
binary: 0000 0001 0111
```

Now we have a row of consecutive 1's (3 to be exact). If we subtract here, it would require 6 operations (3 subtractions and 3 divisions) to shift these three 1 bits. However if we add 1, the resulting carry would flip all the those consecutive bits, thereby lessening the number of operations required. The more consecutive 1 bits, the higher the operations savings.

```
operation count: 8
operaions: /2 -> /2 -> /2 -> -1 -> /2 -> /2 -> /2 -> +2
binary: 0000 0001 1000
```

Continuing to divide:

```
operation count: 11
operaions: /2 -> /2 -> /2 -> -1 -> /2 -> /2 -> /2 -> +2 -> /2 -> /2 ->/2
binary: 0000 0000 0011
```

The final home stretch! This scenario is the only time where we have consecutives 1's and we'd want to do subtraction. By doing subtraction, we reach our goal in 2 operations, otherwise we'd require 3 operations to complete. We can see this using decimals.

Binary `11` is `3`.
```
// Adding
3 + 1 = 4
4 / 2 = 2
2 / 2 = 1

// Substracting
3 - 1 = 2
2 / 2 = 1
```

And we're done!
```
operation count: 13
operaions: /2 -> /2 -> /2 -> -1 -> /2 -> /2 -> /2 -> +2 -> /2 -> /2 -> /2 -> -1 -> /2
binary: 0000 0000 0001
```

**Special Note:**

Ok so I might have been a bit misleading when I said we should always add when there are consecutive 1 bits except for the case where the value is 3 (the remaining two digits are 1's). It's true but not accurate. In the case where there are 2 consecutive 1 bits, we can sometimes subtract and still get the same result. For example:
```
binary: 1000 0011

// Adding route
operation count: 4
operations: +1 -> /2 -> /2 -> -1
result: 0010 0000

// Subtracting route
operation count: 4
operations: -1 -> /2 -> -1 -> /2
result: 0010 0000
```

We see that in this scenario it makes no difference to the resulting number of operations. However, adding is better because it's more "future proof" since it can possibly set ourselves up for further operations savings by connecting disjointed consecutive 1 bits. For example:

```
binary: 1011 1011

// Adding route
operation count: 3
operations: +1 -> /2 -> /2
result: 0010 1111

// Subtracting route
operation count: 4
operations: -1 -> /2 -> -1 -> /2
result: 0010 1110
```

See how we've just create a row of 4 consecutive 1 bits!
