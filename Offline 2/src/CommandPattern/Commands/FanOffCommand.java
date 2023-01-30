package CommandPattern.Commands;

import CommandPattern.Receiver.Fan;

public class FanOffCommand implements Command{
    Fan fan;
    public FanOffCommand(Fan f){
        fan = f;
    }
    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on();
    }
}
