LEVEL 2
======= 

You survived a week in Commander Lambda's organization, and you even managed to get yourself promoted. Hooray! Henchmen still don't have the kind of security access you'll need to take down Commander Lambda, though, so you'd better keep working. Chop chop!

The latest gossip in the henchman breakroom is that "LAMBCHOP" stands for "Lambda's Anti-Matter Biofuel Collision Hadron Oxidating Potentiator". You're pretty sure it runs on diesel, not biofuel, but you can at least give the commander credit for trying.

Rumor has it the prison guards are inexplicably fond of bananas. You're an apple person yourself, but you file the information away for future reference. You never know when you might need to bribe a guard or three...

Power Hungry
============
Commander Lambda's space station is HUGE. And huge space stations take a LOT of power. Huge space stations with doomsday devices take even more power. To help meet the station's power needs, Commander Lambda has installed solar panels on the station's outer surface. But the station sits in the middle of a quasar quantum flux field, which wreaks havoc on the solar panels. You and your team of henchmen has been assigned to repair the solar panels, but you can't take them all down at once without shutting down the space station (and all those pesky life support systems!).

You need to figure out which sets of panels in any given array you can take offline to repair while still maintaining the maximum amount of power output per array, and to do THAT, you'll first need to figure out what the maximum output of each array actually is. Write a function answer(xs) that takes a list of integers representing the power output levels of each panel in an array, and returns the maximum product of some non-empty subset of those numbers. So for example, if an array contained panels with power output levels of [2, -3, 1, 0, -5], then the maximum product would be found by taking the subset: xs[0] = 2, xs[1] = -3, xs[4] = -5, giving the product 2*(-3)*(-5) = 30.  So answer([2,-3,1,0,-5]) will be "30".
Each array of solar panels contains at least 1 and no more than 50 panels, and each panel will have a power output level whose absolute value is no greater than 1000 (some panels are malfunctioning so badly that they're draining energy, but you know a trick with the panels' wave stabilizer that lets you combine two negative-output panels to produce the positive output of the multiple of their power values). The final products may be very large, so give the answer as a string representation of the number.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:  
&nbsp;&nbsp;(int list) xs = [2, 0, 2, 2, 0]

Output:  
&nbsp;&nbsp;(string) "8"

Inputs:  
&nbsp;&nbsp;(int list) xs = [-2, -3, 4, -5]

Output:  
&nbsp;&nbsp;(string) "60"

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

Solution
========

The problem is fairly straight forward. Find the maximum product of the array of panels. The only "got'cha" is to account for all the edge cases. The problem description itself gives many hints on some of cases to account for. Here's a list:

- The array can possibly contain only one panel. This means the max output can be negative.
- The max output can be bigger than int (2^32-1), so use the BigInteger class.
- Don't multiply by zero. duh! But zero may be the answer if all other panels are zero except maybe one negative panel.
- Order matters when it comes to odd numbers of negative panels. For example, `[-1, -2, -3]`. In this case, you'd want to do `-2 * -3` instead of `-1 * -2`. To account for this, the array can be sorted before processing, otherwise the two most significant malfunctioning panels have to be tracked.
