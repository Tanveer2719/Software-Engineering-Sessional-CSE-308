package CommandPattern.Commands;

import CommandPattern.Receiver.Fan;
import CommandPattern.Receiver.Light;

public class FanOnCommand implements Command{
    Fan fan;
    public FanOnCommand(Fan f){
        fan = f;
    }
    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}
