package my.design.command;

public class GarageDoor {
    public void up() {
        System.out.println("GarageDoor is open");
    }
    public void down() {
        System.out.println("GarageDoor is down");
    }
    public void stop() {
        System.out.println("GarageDoor is stop");
    }
    public void lightOn() {
        System.out.println("GarageDoor's light is on");
    }
    public void lightOff() {
        System.out.println("GarageDoor's light is off");
    }
}

/** 命令模式实现开车库门的命令 */
class GarageDoorOnCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOnCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}

class GarageDoorOffCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOffCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}


