package com.ranim.superMarket.restconrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ranim.superMarket.model.Image;
import com.ranim.superMarket.model.Supermarket;
import com.ranim.superMarket.service.ImageService;
import com.ranim.superMarket.service.SupermarketService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	
	@Autowired
	SupermarketService supermarketService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImageSup/{idSuperMarket}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file,
			@PathVariable("idSuperMarket") Long idSuperMarket) throws IOException {
		return imageService.uplaodImageSup(file, idSuperMarket);
	}

	@RequestMapping(value = "/getImagesSup/{idSuperMarket}", method = RequestMethod.GET)
	public List<Image> getImagesSup(@PathVariable("idSuperMarket") Long idSuperMarket) throws IOException {
		return imageService.getImagesParSup(idSuperMarket);
	}

	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		Supermarket s = supermarketService.getSupermarket(id);
		s.setImagePath(id + ".jpg");
		Files.write(Paths.get(System.getProperty("user.home") + "/images/" + s.getImagePath()), file.getBytes());
		supermarketService.saveSupermarket(s);
	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
		Supermarket s = supermarketService.getSupermarket(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + s.getImagePath()));
	}
}
