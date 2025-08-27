//Bryan Montalvo Ramos
//COP 3330C-24217
//3/16/2025
//Generic Container class to handle any kind of information
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//Generic constructor for a List
public class Container<T> {
    private List<T> items;
//Generic constrcutor for an Array
    public Container() {
        items = new ArrayList<>();
    }
//Generic method to Add Items
    public void add(T item) {
        items.add(item);
    }
//Generic method to remove items
    public void remove(T item) {
        items.remove(item);
    }
//Generic method to retrieve index
    public T retrieve(int index) {
        return (index >= 0 && index < items.size()) ? items.get(index) : null;
    }

    public int findIndex(T value) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }


    //Get Items
    public List<T> getItems() {
        return items;

    }
//Container sorting methods utilizing Comparator
    public void sort(Comparator<T> comparator) {
        items.sort(comparator);
    }
//Print Method
    public void printAll() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}
