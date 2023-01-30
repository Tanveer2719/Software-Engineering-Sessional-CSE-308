package CommandPattern;

import CommandPattern.Commands.*;
import CommandPattern.Invoker.RemoteControl;
import CommandPattern.Receiver.Door;
import CommandPattern.Receiver.Fan;
import CommandPattern.Receiver.Light;
import CommandPattern.Receiver.Television;

public class Demo {
    public static void main(String[] args) {
        System.out.println("---------- Remote Control --------");

        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        Fan fan = new Fan();
        Television tv = new Television();
        Door door = new Door();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);
        Command tvOn = new TvOnCommand(tv);
        Command tvOff = new TvOffCommand(tv);
        Command doorOn = new DoorOpenCommand(door);
        Command doorOff = new DoorCloseCommand(door);

        remoteControl.setCommand(0, lightOn, lightOff);
        remoteControl.setCommand(1, fanOn, fanOff);
        remoteControl.setCommand(2, tvOn, tvOff);
        remoteControl.setCommand(3, doorOn, doorOff);

        remoteControl.onButtonPressed(0);
        remoteControl.offButtonPressed(0);
        remoteControl.onButtonPressed(3);
        remoteControl.onButtonPressed(2);
        remoteControl.offButtonPressed(3);



    }
}
