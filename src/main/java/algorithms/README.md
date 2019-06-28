## Problem

* **Task**: Find the longest sequence with at most 2 different characters.
* **Output**: Print the length of the sequence.
* **Language**: Java.

### Solution Explained

#### Method 1 (Brute Force) 
If the length of string is N, then there can be N*(N+1)/2 possible substrings. 
A simple way would be to generate all the substrings and the check each one of them whether it has exactly 2 unique characters or not. 
It would take O(N2) to generate all substrings and O(N) to check.

#### Method 2 (Linear Time) 
We can improve this solution up to O(N2) by maintaining a cache - an associated array, which keeps the number of unique symbols in whole string.
We can use this cache for every next iteration.

Idea is to maintain a 'window' of N elements, starting form the first, and iteratively add new elements to this window until it contains less or equal 2.
Once any of window element exceeds the maximum, we slide window one position left.

### Input Validation
We accept strings of any length, up to maximum possible, empty strings and null (output will be 0 for two latter).
Input may content letters, numbers and special characters.
We expect the size of character set to be 256.
We don't expect whitespaces.

### Possible Improvements
We compose the code in the way so it can be easily modified to print the substring we are looking for.
It also can process not only 2-unique substrings, but k-unique as well (k>0).
The unit test provided covers pretty much all the cases. Nevertheless, it can be easily expanded by new cases thanks to @DataProvider.
