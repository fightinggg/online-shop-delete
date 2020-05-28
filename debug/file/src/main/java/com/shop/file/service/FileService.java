package com.shop.file.service;

import com.shop.common.exception.FallbackException;
import io.minio.errors.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface FileService {

    public String post(Integer id, MultipartFile file) throws FallbackException, Exception;

    public void get(String objectName, OutputStream outputStream) throws IOException, XmlPullParserException, NoSuchAlgorithmException, InvalidKeyException, InvalidExpiresRangeException, InvalidArgumentException, ErrorResponseException, NoResponseException, InvalidBucketNameException, InsufficientDataException, InternalException, Exception;

    public void delete(String id, String objectName) throws Exception;

    public List<String> getImageNameBySeller(String id) throws Exception;
}
