package Mediator.A1;

import Mediator.Sample.Colleague;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator.Sample.Mediator mediator;
    public ColleagueButton(String caption) {
        super(caption);
    }
    public void setMediator(Mediator.Sample.Mediator mediator) {            // 保存Mediator
        this.mediator = mediator;
    }
    public void setColleagueEnabled(boolean enabled) {      // Mediator下达启用/禁用的指示 
        setEnabled(enabled);
    }
}
