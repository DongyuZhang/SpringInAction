package com.dongyuzhang.resources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileSourceExample {
    public static void main(String[] args){
        try{
            String filePath = "/Users/dongyuzhang/Documents/SpringInAction/IOCDemo/src/main/resources/conf/file1.txt";

            WritableResource res1 = new PathResource(filePath);
            OutputStream stream = res1.getOutputStream();
            stream.write("this is for testing 中文".getBytes());
            stream.close();

            Resource res = new ClassPathResource("conf/file1.txt");
            EncodedResource encodedResource = new EncodedResource(res, "UTF-8");
            String content = FileCopyUtils.copyToString(encodedResource.getReader());
            System.out.println(content);
            /*
            InputStream inputStream = res.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            while ((i = inputStream.read()) != -1)
                byteArrayOutputStream.write(i);

            System.out.println("class path resource file1.txt: \n"+byteArrayOutputStream.toString());
            inputStream.close();
            */


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
