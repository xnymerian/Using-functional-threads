# Using-functional-threads
The threads are prepared according to the following problem.
Create an ArrayList consisting of numbers from 1 to 1,000,000 (1 million).
Then, divide the 1 million elements in the ArrayList into 4 equal parts, each containing 25,000 elements.
Design 4 separate threads that will:
a) Add even numbers they find to a shared ArrayList.
b) Add odd numbers they find to a shared ArrayList.
c) Add prime numbers they find to a shared ArrayList.
When the ArrayLists are initially created, they will be empty.
