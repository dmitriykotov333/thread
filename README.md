# Thread 
***
task1 - 17 
# Output/Input
***
Design pattern (Wrapper or Decorator)

If we want to "wrap" method calls of some object with our own code, then we need:

1) Create your own wrapper class and inherit from the same class / interface as the wrapped object.

2) Pass the wrapped object to the constructor of our class.

3) Override all methods in our new class, and call the methods of the wrapped object in them.

4) Make your own changes "to your liking": change the call results, parameters or do something else.

Код на Java	Описание
class Cat
{
 private String name;
 public Cat(String name)
 {
  this.name = name;
 }
 public String getName()
 {
  return this.name;
 }
 public void setName(String name)
 {
  this.name = name;
 }
}	Класс Кот(Cat) содержит два метода – получить имя и установить имя.
class CatWrapper extends Cat
{
 private Cat original;
 public CatWrapper (Cat cat)
 {
  super(cat.getName());
  this.original = cat;
 }

 public String getName()
 {
  return "Кот по имени " + original.getName();
 }

 public void setName(String name)
 {
  original.setName(name);
 }
}	Класс-обертка. Класс не хранит никаких данных, кроме ссылки на оригинальный объект.
Класс в состоянии «пробрасывать» вызовы оригинальному объекту (setName), переданному ему в конструкторе.А также «перехватывать» эти вызовы и модифицировать их параметры и результаты.
public static void main(String[] args)
{
 Cat cat = new Cat("Васька ");
 Cat catWrap = new CatWrapper (cat);
 printName(catWrap);
}

public static void printName(Cat named)
{
 System.out.println(named.getName());
}	Пример использования.
В консоль будет выведена строка
«Кот по имени Вась
