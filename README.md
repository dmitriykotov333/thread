# Thread 
***
task1 - 17 
# Output/Input
***
output_input1 - 7

Design pattern (Wrapper or Decorator example (package src.main.java.com.kotov.thread.decorator)) output_input8

If we want to "wrap" method calls of some object with our own code, then we need:

1) Create your own wrapper class and inherit from the same class / interface as the wrapped object.

2) Pass the wrapped object to the constructor of our class.

3) Override all methods in our new class, and call the methods of the wrapped object in them.

4) Make your own changes "to your liking": change the call results, parameters or do something else.

BufferedInputStream

Example 1:

Let's say I want to drink tea and I ask you to bring me a spoonful of sugar. You went to the basement, there is a bag of sugar. You can bring me a whole bag, but I don't need a bag. I only need one spoon. Then you took one spoon and brought it to me. I added it to tea, but still not very sweet. And I asked you for another one. You went down to the basement again and brought another spoon. This is all too long and ineffective.

A guest came, looked at all this and asked you to bring him a full sugar bowl of sugar.

What happened is called buffering, and the sugar bowl is a buffer. With buffering, clients can read data from the buffer in small chunks, and the buffer can read it in large chunks from the source to save time and effort.

Asking for a spoonful of sugar is analogous to reading one byte from a stream.

The BufferedInputStream class is a classic example of a buffer wrapper. It is an InputStream wrapper class. When reading data from it, it reads it from the original InputStream in large portions into the buffer, and then gives it from the buffer slowly
