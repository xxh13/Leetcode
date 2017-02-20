package sample;

/**
 * 单例模式
 * Created by XXH on 2016/5/9.
 *
 **/

public class SingleItem {

    private static final SingleItem instance = new SingleItem();

    private SingleItem () {};

    public static SingleItem getInstance() {
        return instance;
    }

}

