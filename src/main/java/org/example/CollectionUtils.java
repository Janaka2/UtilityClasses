package org.example;

import java.util.*;

public class CollectionUtils {
    public static <T> List<T> concat(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1.size() + list2.size());
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    /**
     * Adds all elements of the specified arrays to the specified collection.
     */
    public static <T> void addAll(Collection<? super T> collection, T... elements) {
        for (T element : elements) {
            collection.add(element);
        }
    }

    /**
     * Returns the union of two collections.
     */
    public static <T> Set<T> union(Collection<? extends T> a, Collection<? extends T> b) {
        Set<T> result = new HashSet<>();
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    /**
     * Returns the intersection of two collections.
     */
    public static <T> Set<T> intersection(Collection<?> a, Collection<?> b) {
        Set<T> result = new HashSet<>();
        for (Object element : a) {
            if (b.contains(element)) {
                result.add((T) element);
            }
        }
        return result;
    }

    /**
     * Returns the difference of two collections.
     */
    public static <T> Set<T> subtract(Collection<?> a, Collection<?> b) {
        Set<T> result = new HashSet<>();
        for (Object element : a) {
            if (!b.contains(element)) {
                result.add((T) element);
            }
        }
        return result;
    }

    /**
     * Returns the first element of the specified list or null if the list is empty.
     */
    public static <T> T first(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * Returns the last element of the specified list or null if the list is empty.
     */
    public static <T> T last(List<T> list) {
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }

    /**
     * Returns a new list containing the elements of the specified list in reverse order.
     */
    public static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>(list);
        java.util.Collections.reverse(result);
        return result;
    }

    /**
     * Returns a new list containing the elements of the specified list sorted in ascending order.
     */
    public static <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        List<T> result = new ArrayList<>(list);
        java.util.Collections.sort(result);
        return result;
    }

    /**
     * Returns a new list containing the elements of the specified list sorted according to the specified comparator.
     */
    public static <T> List<T> sort(List<T> list, java.util.Comparator<? super T> comparator) {
        List<T> result = new ArrayList<>(list);
        java.util.Collections.sort(result, comparator);
        return result;
    }

}
