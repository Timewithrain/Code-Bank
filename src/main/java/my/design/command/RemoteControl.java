package my.design.command;

/*** 命令模式: 遥控器
 * 能够处理一系列命令的遥控器
 */
public class RemoteControl {
    int capacity = 7;
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[capacity];
        offCommands = new Command[capacity];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public RemoteControl(int capacity) {
        this.capacity = capacity;
        new RemoteControl();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {  // 设置开关指令
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {  // 触发slot对应的开启按钮
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {  // 触发slot对应的关闭按钮
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {  // 撤销上一次的操作
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control ------\n");
        for (int i = 0; i < capacity; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }

    /** 测试 */
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        // 开灯命令
        Light livingRoomLight = new Light("Living Room");
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Light kitchenLight = new Light("Kitchen");
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        // 开车库门命令
        GarageDoor garageDoor = new GarageDoor();
        Command garageDoorUp = new GarageDoorOnCommand(garageDoor);
        Command garageDoorDown = new GarageDoorOffCommand(garageDoor);
        // 开音响命令
        Stereo stereo = new Stereo();
        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        Command stereoOff = new StereoOffWithCDCommand(stereo);

        // 设置遥控器的开关指令
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, garageDoorUp, garageDoorDown);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);

        System.out.println(remoteControl);

        // 调用遥控器的开关指令
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);

        // 测试撤销操作
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

    }
}
