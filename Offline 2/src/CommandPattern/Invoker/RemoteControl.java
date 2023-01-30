package CommandPattern.Invoker;

import CommandPattern.Commands.Command;
import CommandPattern.Commands.NoCommand;

public class RemoteControl {
    Command onCommands[];
    Command offCommands[];
    Command noCommand = new NoCommand();
    Command undoCommand;

    public RemoteControl(){
        onCommands = new Command[4];
        offCommands = new Command[4];
        for(int i = 0;i<4;i ++){
            offCommands[i] = noCommand;
            onCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command on, Command off){
        if(0<= slot && slot<4){
            onCommands[slot] = on;
            offCommands[slot] = off;
        }else{
            System.out.println("Incorrect slot");
        }
    }

    public void  onButtonPressed(int slot){
        onCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void  offButtonPressed(int slot){
        offCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void undoButtonPressed(){
        undoCommand.execute();
    }
}
