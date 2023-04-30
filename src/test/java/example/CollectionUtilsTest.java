package example;

import org.example.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CollectionUtilsTest {

    @Test
    public void testConcat() {
        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("c", "d");
        List<String> expected = Arrays.asList("a", "b", "c", "d");
        List<String> actual = CollectionUtils.concat(list1, list2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        List<String> list = new ArrayList<>();
        CollectionUtils.addAll(list, "foo", "bar", "baz");
        assertEquals(Arrays.asList("foo", "bar", "baz"), list);
    }

    @Test
    public void testUnion() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> union = CollectionUtils.union(set1, set2);
        assertEquals(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)), union);
    }

    @Test
    public void testIntersection() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> intersection = CollectionUtils.intersection(set1, set2);
        assertEquals(new HashSet<>(Collections.singletonList(3)), intersection);
    }

    @Test
    public void testSubtract() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> difference = CollectionUtils.subtract(set1, set2);
        assertEquals(new HashSet<>(Arrays.asList(1, 2)), difference);
    }

    @Test
    public void testFirst() {
        List<String> list = Arrays.asList("foo", "bar", "baz");
        assertEquals("foo", CollectionUtils.first(list));
        assertNull(CollectionUtils.first(Collections.emptyList()));
    }

    @Test
    public void testLast() {
        List<String> list = Arrays.asList("foo", "bar", "baz");
        assertEquals("baz", CollectionUtils.last(list));
        assertNull(CollectionUtils.last(Collections.emptyList()));
    }

    @Test
    public void testReverse() {
        List<String> list = Arrays.asList("foo", "bar", "baz");
        List<String> reversed = CollectionUtils.reverse(list);
        assertEquals(Arrays.asList("baz", "bar", "foo"), reversed);
    }

    @Test
    public void testSort() {
        List<String> list = Arrays.asList("foo", "bar", "baz");
        List<String> sorted = CollectionUtils.sort(list);
        assertEquals(Arrays.asList("bar", "baz", "foo"), sorted);
    }

    @Test
    public void testSortWithComparator() {
        List<String> list = Arrays.asList("foo", "bar", "baz");
        List<String> sorted = CollectionUtils.sort(list, Comparator.reverseOrder());
        assertEquals(Arrays.asList("foo", "baz", "bar"), sorted);
    }
}
