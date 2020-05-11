package com.shop.file.service;

import com.shop.file.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Service
public class FileService {
    @Autowired
    FileDao fileDao;

    public String post(String fileName, MultipartFile file) {
        return fileDao.insert(fileName, file);
    }

    public void get(String objectName, OutputStream outputStream) {
        try {
            InputStream inputStream = fileDao.getUrl(objectName);
            byte[] bytes = new byte[1024];
            for (int len = inputStream.read(bytes); len != -1; len = inputStream.read(bytes)) {
                outputStream.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String objectName) {
        try {
            fileDao.delete(objectName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getImageNameBySeller(String sellerId){
        try{
            return fileDao.getImageNameBySeller(sellerId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
