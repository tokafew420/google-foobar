Bunny Prisoner Locating
=======================

Keeping track of Commander Lambda's many bunny prisoners is starting to get tricky. You've been tasked with writing a program to match bunny prisoner IDs to cell locations.

The LAMBCHOP doomsday device takes up much of the interior of Commander Lambda's space station, and as a result the prison blocks have an unusual layout. They are stacked in a triangular shape, and the bunny prisoners are given numerical IDs starting from the corner, as follows:
```
| 7
| 4 8
| 2 5 9
| 1 3 6 10
```

Each cell can be represented as points (x, y), with x being the distance from the vertical wall, and y being the height from the ground. 
For example, the bunny prisoner at (1, 1) has ID 1, the bunny prisoner at (3, 2) has ID 9, and the bunny prisoner at (2, 3) has ID 8. This pattern of numbering continues indefinitely (Commander Lambda has been taking a LOT of prisoners). 

Write a function answer(x, y) which returns the prisoner ID of the bunny at location (x, y). Each value of x and y will be at least 1 and no greater than 100,000. Since the prisoner ID can be very large, return your answer as a string representation of the number.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:  
&nbsp;&nbsp;(int) x = 3
&nbsp;&nbsp;(int) y = 2

Output:  
&nbsp;&nbsp;(string) "9"

Inputs:  
&nbsp;&nbsp;(int) x = 5
&nbsp;&nbsp;(int) y = 10

Output:  
&nbsp;&nbsp;(string) "96"

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

Solution
========

This problem is not difficult to brute force. You can simply start building the trianguler shape, plotting each point and retaining the id (count of plotted points thus far) and return the id when you hit the x, y input. However, this approach clearly isn't the best answer. That would be too easy!

Using what's known as the [Triangular Number](https://en.wikipedia.org/wiki/Triangular_number), we can calculate the answer much faster. 

The nth triangular number value (t) is given by the formula `n * (n + 1) / 2`.

In the above example with `n = 4`, we can use the formula to get the bottom right most id number.
```
| 7
| 4 8
| 2 5 9
| 1 3 6 10

n = 4
t = 10
```
Now with the value of `t` we just need to offset the position to get the final result.

Here's how it works for the input x = 3, y = 2

1. First, get the value of `n`. Since it's a triangle the corrdinates x and y along the hypothenuse have an inverse relationship. `n` is equal to `x + y - 1`.
  - `n = x + y - 1 = 3 + 2 - 1 = 4`
2. Now calculate `t` using the forumla for triangular numbers.
  - `t = n * (n + 1) / 2 = 4 * (4 + 1) / 2 = 10`
3. The triangular number is actually at x = 4, y = 1, but what we want is x = 3, y = 2. Note that we're just moving backwards up the hypotenuse of the triangle. The steps to move is given by `n - x`.
  - Steps to move back is `n - x = 4 - 3 = 1`
4. Return `t` with the offset as the final answer.
  - `t - 1 = 9`

**Note:** Pay special attention to the upper bound specified in the problem. x and y can both be a maximum of 100,000. This means that the type `int` is not sufficient to calculate this answer, we must use type `long`.
