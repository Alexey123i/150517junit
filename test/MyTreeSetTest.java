import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by user on 15.05.17.
 */
class MyTreeSetTest {
    private MyTreeSet myTreeSet = new MyTreeSet();

    private MyTreeSetTest() {
        myTreeSet.insert("ананас");
        myTreeSet.insert("апельсин");
        myTreeSet.insert("банан");
        myTreeSet.insert("персик");
    }

    @Test
    void insert() {
        myTreeSet.insert("test");
        boolean result = myTreeSet.contains("test");
        boolean expected = true;
        assertEquals(expected,result);
    }

    @Test
    void contains() {
        boolean expected = true;
        boolean result = myTreeSet.contains("банан");
        assertEquals(expected,result);
    }

    @Test
    void getSize() {
        int expected = 4;
        int result = myTreeSet.getSize();
        assertEquals(expected,result);
    }

    @Test
    void delete() {
        myTreeSet.delete("банан");
        boolean expected = false;
        boolean result = myTreeSet.contains("банан");
        assertEquals(expected,result);

    }

}