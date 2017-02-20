import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algorithm.Demo1;

/**
 *
 * Created by XXH on 2016/4/7.
 */
public class DemoTest{
    @Test
    public void assertDemo(){
        int[] a= {1,1,2,3,4,4,5,5,5};
        String s = "abba";
        assertEquals(3, Demo1.getMax(1,2,3));
        assertEquals(3, Demo1.getMax(3,3,3));
        assertEquals(3, Demo1.getMax(3,2,3));
        assertEquals(true, Demo1.isParadox(s));
    }

}
