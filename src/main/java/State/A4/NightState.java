package State.A4;

import State.Sample.Context;
import State.Sample.DayState;

public class NightState implements State.Sample.State {
    private static NightState singleton = new NightState();
    private NightState() {                              // 构造函数的可见性是private
    }
    public static State.Sample.State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(State.Sample.Context context, int hour) {    // 设置时间
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(State.Sample.Context context) {                // 使用金库
        context.callSecurityCenter("紧急：晚上使用金库！");
    }
    public void doAlarm(State.Sample.Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(晚上)");
        context.changeState(UrgentState.getInstance()); 
    }
    public void doPhone(Context context) {              // 正常通话
        context.recordLog("晚上的通话录音");
    }
    public String toString() {                          // 显示字符串
        return "[晚上]";
    }
}
