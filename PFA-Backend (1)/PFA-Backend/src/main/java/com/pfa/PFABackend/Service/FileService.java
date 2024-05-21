package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.File;
import com.pfa.PFABackend.Repository.FileRepository;
import org.apache.catalina.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;



    public File store(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        File file = new File();
        file.setName(fileName);
        file.setType(multipartFile.getContentType());
        file.setData(multipartFile.getBytes());

        return  fileRepository.save(file);
    }

    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<File> getAllFiles(String id) {
        return fileRepository.findAll().stream();
    }
}
