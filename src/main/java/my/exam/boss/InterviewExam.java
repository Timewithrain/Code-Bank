package my.exam.boss;

import java.io.File;
import java.util.List;

public class InterviewExam {

    /** 给定如下方法deleteFile、getSubFiles、isFolder，编写函数完成删除空文件夹的功能 */
    void deleteFile(File file) {

    }

    List<File> getSubFiles(File file) {
        return null;
    }

    boolean isFolder(File file) {
        return false;
    }

    void retrieve(File file) {
        if (file==null || !isFolder(file)) return;
        List<File> files = getSubFiles(file);
        if (files==null) {
            deleteFile(file);
        } else {
            for (File f : files) {
                if (isFolder(f)){
                    retrieve(f);
                }
            }
            files = getSubFiles(file);  // 注意删除完成后需要再次判断空文件夹
            if (files==null) {
                deleteFile(file);
            }
        }
    }

    void deleteEmptyFolder(File file) {
        retrieve(file);
    }

}
