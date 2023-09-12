package my.design.command;

/** 命令模式: 音响 */
public class Stereo {

    public void on() {
        System.out.println("Stereo is on");
    }

    public void off() {
        System.out.println("Stereo is off");
    }

    public void setCd() {
        System.out.println("Stereo is set for CD input");
    }

    public void setDvd() {
        System.out.println("Stereo is set for DVD input");
    }

    public void setRadio() {
        System.out.println("Stereo is set for Radio");
    }

    public void setVolume(int volume) {
        System.out.println("Stereo volume set to " + volume);
    }
}

/** 命令模式实现以CD模式打开音响的命令 */
class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}

class StereoOffWithCDCommand implements Command {

    Stereo stereo;

    public StereoOffWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }
}