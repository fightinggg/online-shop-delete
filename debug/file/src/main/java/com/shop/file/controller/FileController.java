package com.shop.file.controller;

import com.shop.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/seller/{sellerId}/{filename}")
    public String post(@PathVariable("sellerId") String sellerId, @PathVariable String filename, @RequestBody MultipartFile multipartFile) {
        fileService.post(sellerId + filename, multipartFile);
        return "成功 ";
    }

    @GetMapping("/everyone/null/{sellerId}/{filename}")
    public void get(@PathVariable String sellerId, @PathVariable String filename, HttpServletResponse response) throws ServletException, IOException {
        fileService.get(sellerId + filename, response.getOutputStream());
    }

    @DeleteMapping("/seller/{sellerId}/{filename}")
    public void delete(@PathVariable("sellerId") String sellerId, @PathVariable String filename) {
        fileService.delete(sellerId + filename);
    }

    @GetMapping("/seller/{sellerId}")
    public List<String> getAll(@PathVariable String sellerId) throws ServletException, IOException {
        return fileService.getImageNameBySeller(sellerId);
    }
}

/**
 * http://127.0.0.1:9000/shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135650Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=9a77f5342292cf629dee39a75ea06d9c59359b381f5b94f80ce488c74b5c466d
 * <p>
 * http://121.199.76.43:9000/shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135841Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=13bf52b059232a5391cf92af1b03d1ddb35837ba7e020c84655e9416056b8433
 * <p>
 * http://121.199.76.43:9000/shop/1hello5.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2F%2Fs3%2Faws4_request&X-Amz-Date=20200509T140338Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=36ca23f9fc5249f9a266f55f01c89ee84fff1b149be3f8a78cb151c9d6dcef0d
 * http://121.199.76.43:9000/shop/1hello5.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135319Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=0c56ede3cb99158d2cd0694148708a69a502c1bf378a52d5abaef24f8f7bbce6
 * <p>
 * <p>
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135650Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=9a77f5342292cf629dee39a75ea06d9c59359b381f5b94f80ce488c74b5c466d
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135650Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=9a77f5342292cf629dee39a75ea06d9c59359b381f5b94f80ce488c74b5c466d
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135653Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=f9e076d7c71af5a6f89aae6cd4483444238ca7c952a2d91bc49387aa679cbf19
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135653Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=f9e076d7c71af5a6f89aae6cd4483444238ca7c952a2d91bc49387aa679cbf19
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135733Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=171ed3e4d5940659b6701d73f0a06fdc5f8a95b04c1c32eb038458d96d3b7071
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135733Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=171ed3e4d5940659b6701d73f0a06fdc5f8a95b04c1c32eb038458d96d3b7071
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135741Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=f3af384db23a76dd4c08f723ffffa2cb329e9fdebb68d5bf63017b0555cd6966
 * shop/1hello1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=admin%2F20200509%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200509T135741Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=f3af384db23a76dd4c08f723ffffa2cb329e9fdebb68d5bf63017b0555cd6966
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * ?
 */