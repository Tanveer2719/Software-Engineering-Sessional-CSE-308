package CommandPattern.Commands;

import CommandPattern.Receiver.Television;

public class TvOnCommand implements Command{
    Television tv;

    public TvOnCommand(Television tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
