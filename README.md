# Thread 
***
task1 - 17 
# Output/Input
***
output_input1 - 7

Design pattern (Wrapper or Decorator example (package src.main.java.com.kotov.thread.decorator)) output_input8 - 23

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


Design pattern Adapter (output_input24 - 34)

Serializable (serializable1 - )

# java.nio.file.*

| Методы класса Paths	| Описание| 
| ------------- | ------------- |
| boolean isAbsolute()	| Возвращает true, если путь – абсолютный. |
| Path getRoot()	| Возвращает корень текущего пути – директорию самого верхнего уровня. |
| Path getFileName()	| Возвращает имя файла из текущего пути. |
| Path getParent()	| Возвращает директорию из текущего пути. |
| boolean startsWith(Path other)	| Проверяет, что текущий путь начинается с переданного пути. |
| boolean endsWith(Path other)	| Проверяет, что текущий путь заканчивается на переданный путь. |
| Path normalize()	| Нормализует текущий путь. Например, приводит путь «c:/dir/dir2/../a.txt» к пути «c:/dir/a.txt» |
| Path relativize(Path other)	| Вычисляет относительный путь двух путей – «разницу путей» |
| Path resolve(String other)	| Восстанавливает абсолютный путь по текущему и относительному. |
| URI toUri()	| Возвращает URI текущего пути/файла. |
| Path toAbsolutePath()	| Приводит путь к абсолютному, если был относительный. |
| File toFile()	| Возвращает объект File, который соответствует текущему объекту Path. |

| Методы класса Files	| Описание | 
| ------------- | ------------- |
| Path createFile(…) |	Создает файл на диске. |
| Path createDirectory(…) |	Создает директорию. |
| Path createDirectories(…) |	Создает директорию и поддиректории. |
| Path createTempFile(…) |	Создает «временный файл» |
| Path createTempDirectory(…) |	Создает «временную директорию» |
| void delete(Path path) |	Удаляет файл/директорию. |
| Path copy(Path source, Path target,…) |	Копирует файл. |
| Path move(Path source, Path target,…) |	Перемещает файл. |
| boolean isSameFile(Path, Path) |	Сравнивает два файла. |
| boolean isDirectory(Path) |	Путь — это директория? |
| boolean isRegularFile(Path) |	Путь – это файл? |
| long size(Path) |	Возвращает размер файла. |
| boolean exists(Path) |	Объект с таким именем существует? |
| boolean notExists(Path) |	Объект с таким именем не существует? |
| long copy(InputStream, OutputStream) |	Копирует байты из InputStream в OutputStream. |
| long copy(Path, OutputStream) |	Копирует все байты из Path в OutputStream. |
| long copy(InputStream, Path) |	Копирует все байты из InputStream в Path. |
| byte[] read(InputStream, int initialSize) |	Читает массив байт из InputStream. |
| byte[] readAllBytes(Path path) |	Читает все байты из InputStream. |
| List<String> readAllLines(Path path,..) |	Читает текстовый файл, возвращает список строк. |
| Path write(Path path, byte[] bytes,…) |	Пишет массив байт в файл. |
  
