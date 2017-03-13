import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import leetcode_60_80.*;

/**
 *
 * Created by XXH on 2016/4/7.
 */
public class DemoTest{
    @Test
    public void assertDemo(){
        for (int i = 0; i < 10000; i++) {
            assertEquals(new _69().mySqrt(i), (int) Math.sqrt(i));
        }
    }

}
