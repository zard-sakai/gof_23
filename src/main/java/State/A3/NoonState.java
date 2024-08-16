package State.A3;

import State.A4.Context;
import State.A4.DayState;

public class NoonState implements State.A4.State {
    private static NoonState singleton = new NoonState();
    private NoonState() {                               // 构造函数的可见性是private
    }
    public static State.A4.State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(State.A4.Context context, int hour) {    // 设置时间
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        } else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(State.A4.Context context) {                // 使用金库
        context.callSecurityCenter("紧急：午餐时间使用金库！");
    }
    public void doAlarm(State.A4.Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(午餐时间)");
    }
    public void doPhone(Context context) {              // 正常通话
        context.recordLog("午餐时间的通话录音");
    }
    public String toString() {                          // 显示字符串
        return "[午餐时间]";
    }
}
