package CommandPattern.Commands;

import CommandPattern.Receiver.Television;

public class TvOffCommand implements Command{
    Television tv;

    public TvOffCommand(Television tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}