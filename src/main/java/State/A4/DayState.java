package State.A4;

import State.Sample.Context;

public class DayState implements State.Sample.State {
    private static DayState singleton = new DayState();
    private DayState() {                                // 构造函数的可见性是private
    }
    public static State.Sample.State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(State.Sample.Context context, int hour) {    // 设置时间
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }
    public void doUse(State.Sample.Context context) {                // 使用金库
        context.recordLog("使用金库(白天)");
    }
    public void doAlarm(State.Sample.Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(白天)");
        context.changeState(UrgentState.getInstance()); 
    }
    public void doPhone(Context context) {              // 正常通话
        context.callSecurityCenter("正常通话(白天)");
    }
    public String toString() {                          // 显示表示类的文字
        return "[白天]";
    }
}
