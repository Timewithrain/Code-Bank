package my.design.command;

public class Light {

    String name = "Light";

    public Light() {}

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " is on");
    }
    public void off() {
        System.out.println(name + " is off");
    }
}

/** 命令模式实现开灯的命令 */
class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

/** 命令模式实现关灯的命令 */
class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
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