package src.main.java.com.kotov.thread.abstract_list;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/

/**
 * Иногда необходимо получить копию объекта, которая не зависела бы от оригинала.
 * С которой можно было бы производить манипуляции, при этом, не изменяя оригинал.
 * При обыкновенном присваивание объектов (obj1 = obj2;) передаются ссылки на объект.
 * В итоге два экземпляра ссылаются на один объект, и изменение одного приведет к изменению другого.
 * Как мы видим это не то, что нам нужно.
 * И в данном случае, нам на помощь придет интерфейс Cloneable и метод clone() класса Object.
 */
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    /**
     * любое дерево начинается с корня, поэтому в класс CustomTree добавим поле root типа Entry<String> c модификатором доступа по умолчанию.
     */
    private Entry<String> root;

    CustomTree() {
        this.root = new Entry<>("0");
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }

    String getParent(String entryName) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            if (currentNode.elementName.equals(entryName)) {
                return currentNode.parent.elementName;
            } else {
                child(currentNode, queue);
            }
        }
        return null;
    }

    private void child(Entry<String> currentNode, Queue<Entry<String>> queue) {
        if (currentNode.leftChild != null) {
            queue.offer(currentNode.leftChild);
        }
        if (currentNode.rightChild != null) {
            queue.offer(currentNode.rightChild);
        }
    }

    /**
     * poll() - удаляет верхний элемент из очереди
     * offer() - пытается вставить элемент в конец очереди.
     *
     * @param s
     * @return boolean add result
     */
    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            currentNode.checkChildren();
            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren) {
                    currentNode.leftChild = new Entry<>(s);
                    currentNode.leftChild.parent = currentNode;
                    return true;
                } else if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = new Entry<>(s);
                    currentNode.rightChild.parent = currentNode;
                    return true;
                }
            } else {
                child(currentNode, queue);
            }
        }
        return false;
    }

    @Override
    public void add(int index, String element) {
        // super.add(index, element);

        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        //return super.set(index, element);
        throw new UnsupportedOperationException();
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            throw new UnsupportedOperationException();
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    @Override
    public boolean remove(Object o) {
        String s = (String) o;
        if (!isInteger(s)) {
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Entry<String> currentNode = queue.poll();
                if (currentNode.leftChild != null) {
                    if (currentNode.leftChild.elementName.equals(s)) {
                        currentNode.leftChild = null;
                        return true;
                    }
                    queue.offer(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    if (currentNode.rightChild.elementName.equals(s)) {
                        currentNode.rightChild = null;
                        return true;
                    }
                    queue.offer(currentNode.rightChild);
                }
            }
        }
        return false;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        //return super.subList(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        //super.removeRange(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        //return super.addAll(index, c);
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {

        int size = -1;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();
            size++;
            child(currentNode, queue);
        }
        return size;
    }


    /**
     * Класс описывающий дерево мы создали, теперь нужен класс описывающий тип элементов дерева:
     * 1.  В классе CustomTree создай вложенный статический параметризированный класс Entry<T> с модификатором доступа по умолчанию.
     * 2. Обеспечь поддержку этим классом интерфейса Serializable.
     * 3. Создай такие поля (модификатор доступа по умолчанию):
     * - String elementName;
     * - boolean availableToAddLeftChildren, availableToAddRightChildren;
     * - Entry<T> parent, leftChild, rightChild;
     * - при необходимости, можешь создавать и другие поля;
     * 4. Реализуй публичный конструктор с одним параметром типа String:
     * - установи поле elementName равным полученному параметру;
     * - установи поле availableToAddLeftChildren равным true;
     * - установи поле availableToAddRightChildren равным true;
     * 5. Реализуй публичный метод boolean isAvailableToAddChildren, возвращающий дизъюнкцию полей availableToAddLeftChildren и availableToAddRightChildren.
     *
     * @param <T>
     */
    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        boolean isAvailableToAddChildren() {
            if (availableToAddLeftChildren) {
                return true;
            } else return availableToAddRightChildren;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }
    }
}
