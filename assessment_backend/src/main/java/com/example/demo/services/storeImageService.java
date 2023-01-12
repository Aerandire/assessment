package com.example.demo.services;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.demo.models.Image;

@Service
public class storeImageService {
    @Autowired
    AmazonS3 s3Client;

    //String FOLDER = "files/";

    public String saveFile(MultipartFile multipartFile) throws IOException{
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		String imgName = FilenameUtils.removeExtension(multipartFile.getOriginalFilename());
		String key = imgName + "." + extension;
		saveImageToServer(multipartFile, key);
		Image image = new Image();
		image.setName(imgName);
		image.setExt(extension);
		image.setCreatedtime(new Timestamp(new Date().getTime()));
        return key;
    }

    private void saveImageToServer(MultipartFile multipartFile, String key) throws IOException {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(multipartFile.getInputStream().available());
		if (multipartFile.getContentType() != null && !"".equals(multipartFile.getContentType())) {
			metadata.setContentType(multipartFile.getContentType());
		}
		s3Client.putObject(new PutObjectRequest("aer", key, multipartFile.getInputStream(), metadata)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}
}
