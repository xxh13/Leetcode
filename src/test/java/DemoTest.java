import leetcode_170_200.LRU;
import org.junit.Test;

/**
 *
 * Created by XXH on 2016/4/7.
 */
public class DemoTest{

	@Test
	public void test() {
		LRU<String, String> lru = new LRU<>(3);
		lru.put("1", "1");
		lru.put("2", "2");
		lru.put("3", "3");
		lru.put("4", "4");
		lru.put("5", "5");
		System.out.println(lru.get("1"));
		System.out.println(lru.get("3"));
		lru.put("1", "1");
		System.out.println(lru.get("4"));
	}

}
