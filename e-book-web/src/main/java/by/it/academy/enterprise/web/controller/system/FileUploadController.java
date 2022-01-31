package by.it.academy.enterprise.web.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {
    private final Logger logger = LoggerFactory.getLogger("LOGS-WEB");

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException{
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
            logger.trace("File catalog created by path " + uploadRootPath);
        }
        File serverFile = new File(uploadRootDir.getAbsolutePath() + file.getOriginalFilename());
        serverFile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(serverFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return new ResponseEntity<>("File is uploaded", HttpStatus.OK);
    }


}
