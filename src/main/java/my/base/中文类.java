package my.base;

interface 动物 {
    void 吃();
}

class 狗 implements 动物 {
    public void 吃() {
        System.out.println("吃狗粮");
    }
}

class 猫 implements 动物 {
    public void 吃() {
        System.out.println("吃猫粮");
    }
}

public class 中文类 {
    public static void main(String[] args) {
        动物 小狗 = new 狗();
        动物 小猫 = new 猫();
        动物 人 = new 动物() {
            public void 吃() {
                System.out.println("吃饭");
            }
        };
        小狗.吃();
        小猫.吃();
        人.吃();
    }
}
