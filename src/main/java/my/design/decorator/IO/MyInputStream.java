package my.design.decorator.IO;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MyInputStream {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new LowerCaseInputStream(new ByteArrayInputStream("I am telling you, CPU is good".getBytes()));
        int c;
        while ((c = inputStream.read()) >= 0) {
            System.out.print((char) c);
        }
        System.out.println();
    }


}
