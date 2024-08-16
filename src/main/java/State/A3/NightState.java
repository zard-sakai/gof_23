package State.A3;

import State.A4.Context;
import State.A4.DayState;

public class NightState implements State.A4.State {
    private static NightState singleton = new NightState();
    private NightState() {                              // 构造函数的可见性是private
    }
    public static State.A4.State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(State.A4.Context context, int hour) {    // 设置时间
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (12 <= hour && hour < 13) {                   
            context.changeState(NoonState.getInstance());       
        }                                                       
    }
    public void doUse(State.A4.Context context) {                // 使用金库
        context.callSecurityCenter("紧急：晚上使用金库！");
    }
    public void doAlarm(State.A4.Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(晚上)");
    }
    public void doPhone(Context context) {              // 正常通话
        context.recordLog("晚上的通话录音");
    }
    public String toString() {                          // 用字符串表示状态
        return "[晚上]";
    }
}


