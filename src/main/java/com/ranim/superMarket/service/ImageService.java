package com.ranim.superMarket.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.ranim.superMarket.model.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;

	Image getImageDetails(Long id) throws IOException;

	ResponseEntity<byte[]> getImage(Long id) throws IOException;

	void deleteImage(Long id);
	
	Image uplaodImageSup(MultipartFile file,Long idSuperMarket) throws IOException;
	List<Image> getImagesParSup(Long idSuperMarket);
}
