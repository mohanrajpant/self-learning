package polymorphism.staticmethod;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChildTest extends ParentTest {

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("child beforeclass setup");
        System.out.println(hostname());
    }

    @Test
    public void dummyTest() throws Exception {
        // DO nothing
    }

    public static String hostname() {
        return "child-hostname";
    }
}
