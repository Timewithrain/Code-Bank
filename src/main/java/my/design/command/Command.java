package my.design.command;

/** 命令模式: 命令接口 */
public interface Command {
    void execute();
    void undo();
}
