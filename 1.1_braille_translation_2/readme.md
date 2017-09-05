LEVEL 1
======= 

Success! You've managed to infiltrate Commander Lambda's evil organization, and finally earned yourself an entry-level position as a Minion on her space station. From here, you just might be able to subvert her plans to use the LAMBCHOP doomsday device to destroy Bunny Planet. Problem is, Minions are the lowest of the low in the Lambda hierarchy. Better buck up and get working, or you'll never make it to the top...

Next time Bunny HQ needs someone to infiltrate a space station to rescue prisoners, you're going to tell them to make sure 'stay up for 48 hours straight scrubbing toilets' is part of the job description. It's only fair to warn people, after all.

Braille Translation
===================

Because Commander Lambda is an equal-opportunity despot, she has several visually-impaired minions. But she never bothered to follow intergalactic standards for workplace accommodations, so those minions have a hard time navigating her space station. You figure printing out Braille signs will help them, and - since you'll be promoting efficiency at the same time - increase your chances of a promotion. 
Braille is a writing system used to read by touch instead of by sight. Each character is composed of 6 dots in a 2x3 grid, where each dot can either be a bump or be flat (no bump). You plan to translate the signs around the space station to Braille so that the minions under Commander Lambda's command can feel the bumps on the signs and "read" the text with their touch. The special printer which can print the bumps onto the signs expects the dots in the following order:

1 4  
2 5  
3 6  

So given the plain text word "code", you get the Braille dots:

11 10 11 10  
00 01 01 01  
00 10 00 00

where 1 represents a bump and 0 represents no bump.  Put together, "code" becomes the output string "100100101010100110100010".

Write a function answer(plaintext) that takes a string parameter and returns a string of 1's and 0's representing the bumps and absence of bumps in the input string. Your function should be able to encode the 26 lowercase letters, handle capital letters by adding a Braille capitalization mark before that character, and use a blank character (000000) for spaces. All signs on the space station are less than fifty characters long and use only letters and spaces.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:  
&nbsp;&nbsp;(string) plaintext = "code"

Output:  
&nbsp;&nbsp;(string) "100100101010100110100010"

Inputs:  
&nbsp;&nbsp;(string) plaintext = "Braille"

Output:  
&nbsp;&nbsp;(string) "000001110000111010100000010100111000111000100010"

Inputs:  
&nbsp;&nbsp;(string) plaintext = "The quick brown fox jumped over the lazy dog"

Output:  
&nbsp;&nbsp;(string) "000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100100010100110000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110"

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

Solution
========

This problem is pretty straight forward and easy. We just have to lookup the [braille codes](https://en.wikipedia.org/wiki/Braille) for the letters a-z and the [ASCII character codes](https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html) then create a mapping for them. Looping through each character of the input, we append the correct mapping to a StringBuilder taking special care to account for spaces and upper case characters.
