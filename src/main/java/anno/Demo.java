package anno;

/**
 * Created by XXH on 2018/2/2.
 */
public class Demo implements DemoImp{

    @Assignment(assignee = "xxh", effort = 10)
    public String worker1 = "worker1";

    @Assignment(assignee = "worker1", effort = 4)
    public String subWorker1 = "subWorker1";

    @Assignment(assignee = "worker1", effort = 4)
    public String subWorker2 = "subWorker2";

    @Assignment(assignee = "worker1", effort = 2)
    public String subWorker3 = "subWorker3";

    public void print(String s) {
        System.out.println(s);
    }
}
