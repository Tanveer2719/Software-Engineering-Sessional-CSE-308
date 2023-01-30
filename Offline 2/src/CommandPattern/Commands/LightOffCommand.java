package CommandPattern.Commands;

import CommandPattern.Receiver.Light;

public class LightOffCommand implements Command{
    Light light;
    public LightOffCommand(Light l){
        light = l;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
