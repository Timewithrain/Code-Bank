package my.design.command;

/** 命令模式: 遥控器
 * 命令模式将"请求"方法封装成对象, 以便使用不同的请求,队列或者日志来参数化其他对象.
 * 调用者通过调用命令对象的execute()方法来执行请求, 请求具体的处理过程在具体的command中定义，和调用者解耦合.
 */
public class SimpleRemoteControl {
    Command slot;  // 插槽用于持有命令

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {  // 设置命令
        slot = command;
    }

    public void buttonWasPressed() {  // 按钮触发, 执行命令, 命令执行封装在execute中调用者不必关心
        slot.execute();
    }

    // 测试命令模式调用
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();  // 定义遥控器
        Command lightCommand = new LightOnCommand(new Light());  // 定义开灯命令，实现参数化对象
        Command garageDoorCommand = new GarageDoorOnCommand(new GarageDoor());  // 定义开车库门命令

        remote.setCommand(lightCommand);  // 设置命令，以参数形式传入需要执行的命令
        remote.buttonWasPressed();  // 按钮触发命令执行

        remote.setCommand(garageDoorCommand);
        remote.buttonWasPressed();
    }
}
