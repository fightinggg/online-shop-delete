package com.shop.file.service.impl;

import com.shop.common.exception.NoAuthorityException;
import com.shop.common.service.UidService;
import com.shop.file.dao.FileDao;
import com.shop.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;
    @Autowired
    UidService uidService;

    public String post(Integer id, MultipartFile file) throws Exception {
        String filename = id.toString() + uidService.getUid().toString();
        fileDao.insert(filename, file);
        return filename;
    }

    public void get(String objectName, OutputStream outputStream) throws Exception {
        InputStream inputStream = fileDao.getStream(objectName);
        byte[] bytes = new byte[1024];
        for (int len = inputStream.read(bytes); len != -1; len = inputStream.read(bytes)) {
            outputStream.write(bytes, 0, len);
        }
    }

    public void delete(String id, String objectName) throws Exception {
        if(!objectName.startsWith(id)) {
            throw new NoAuthorityException();
        }
        fileDao.delete(objectName);
    }

    public List<String> getImageNameBySeller(String id) throws Exception {
        return fileDao.getImageNameBySeller(id);
    }
}
