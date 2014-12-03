package ex2;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {
   
    @Test
    public void testSearchInSingleArray() {
        assertEquals(0, BinarySearch.search(new int[]{10}, 10));
        assertEquals(-1, BinarySearch.search(new int[]{20}, 10));
    }

    @Test
    public void testSearchInArray() {
        int[] a = {1, 2, 3, 4, 5, 7, 17, 19};

        assertEquals(0, BinarySearch.search(a, 1));
        assertEquals(1, BinarySearch.search(a, 2));
        assertEquals(-1, BinarySearch.search(a, 10));
        assertEquals(6, BinarySearch.search(a, 17));
        assertEquals(7, BinarySearch.search(a, 19));
    }

    @Test
    public void testSearchInArrayBoundary() {
        int[] a = new int[]{-324, -3, -1, 0, 42, 99, 101};

        assertEquals(0, BinarySearch.search(a, -324));
        assertEquals(3, BinarySearch.search(a, 0));
        assertEquals(6, BinarySearch.search(a, 101));
    }
}
