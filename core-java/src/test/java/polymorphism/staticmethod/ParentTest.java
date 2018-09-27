package polymorphism.staticmethod;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class ParentTest {

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("parent beforeclass setup");
        System.out.println(hostname());
    }

    public static String hostname() {
        return "parent-hostname";
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("after class parent");
    }
}
