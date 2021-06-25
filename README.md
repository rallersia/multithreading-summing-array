# multithreading-summing-array
Simple console application to understanding multithreading operations.
We have an array of random integer values, and we are summing them using threads. Array length and the number of threads are passed as command-line arguments.
An example of the program operation (if each array element equals 1):
```
$ java Program --arraySize=13 --threadsCount=3
Sum: 13
Thread 1: from 0 to 4 sum is 5
Thread 2: from 5 to 9 sum is 5
Thread 3: from 10 to 12 sum is 3
Sum by threads: 13
```
