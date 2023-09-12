package my.design.command;

/** 空对象：无指令，用于解决不需要任何操作时的占位对象 */
public class NoCommand implements Command {
    public void execute() {}

    public void undo() {}
}
