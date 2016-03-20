package shop.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by oleg on 09.03.16.
 */
public class FileIOUtil {
    public String saveFile(MultipartFile file) throws IOException {
        String name = null;

        if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();

                String rootPath = "/home/oleg/IdeaProjects/Online-Shop-1.0/files";
                File dir = new File(rootPath + File.separator + "loadFiles");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                return name;
        } else {
            return "";
        }
    }
}
