package ex4;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void testPushAndPop() {
        Stack stack = new ArrayStack(10);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
    }

    @Test
    public void testPushInFullStack() {
        Stack stack = new ArrayStack(2);
        stack.push(1);
        stack.push(2);

        try {
            stack.push(3);
        } catch (FullStackException e) {
            return;
        }
        fail();
    }

    @Test(expected=EmptyStackException.class)
    public void testPopInEmptyStack() {
        Stack stack = new ArrayStack(2);
        stack.pop();
    }

    @Test
    public void testPeek() {
        Stack stack = new ArrayStack(10);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());
        assertEquals(3, stack.peek());
    }

    @Test(expected=EmptyStackException.class)
    public void testPeekInEmptyStack()  {
        Stack stack = new ArrayStack(10);
        stack.peek();
    }

    @Test
    public void testIsFull() {
        Stack stack = new ArrayStack(2);

        stack.push(1);
        assertFalse(stack.isFull());

        stack.push(2);
        assertTrue(stack.isFull());

        stack.pop();
        assertFalse(stack.isFull());
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new ArrayStack(2);

        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

}
