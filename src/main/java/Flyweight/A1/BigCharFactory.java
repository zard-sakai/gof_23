package Flyweight.A1;

import Flyweight.A2.BigChar;

import java.util.HashMap;

public class BigCharFactory {
    // 管理已经生成的BigChar的实例
    private HashMap pool = new HashMap();
    // Singleton模式
    private static BigCharFactory singleton = new BigCharFactory();
    // 构造函数
    private BigCharFactory() {
    }
    // 获取唯一的实例
    public static BigCharFactory getInstance() {
        return singleton;
    }
    // 生成（共享）BigChar类的实例
    public synchronized Flyweight.A2.BigChar getBigChar(char charname) {
        Flyweight.A2.BigChar bc = (Flyweight.A2.BigChar)pool.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname); // 生成BigChar的实例
            pool.put("" + charname, bc);
        }
        return bc;
    }
}
