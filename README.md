# Thread 
***
task1 - 17 
# Output/Input
***
output_input1 - 7

Design pattern (Wrapper or Decorator) output_input8

If we want to "wrap" method calls of some object with our own code, then we need:

1) Create your own wrapper class and inherit from the same class / interface as the wrapped object.

2) Pass the wrapped object to the constructor of our class.

3) Override all methods in our new class, and call the methods of the wrapped object in them.

4) Make your own changes "to your liking": change the call results, parameters or do something else.
