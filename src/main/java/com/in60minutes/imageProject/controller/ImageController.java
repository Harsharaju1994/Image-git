package com.in60minutes.imageProject.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.in60minutes.imageProject.model.Images;
import com.in60minutes.imageProject.repo.ImageRepo;

import jakarta.websocket.server.PathParam;

@RestController
public class ImageController {
	
	@Autowired
	ImageRepo imageRepo;
	
	@PostMapping("/addImage")
	public Images postImage(@RequestParam("file") MultipartFile file) throws IOException {
		Images image = new Images();
		image.setImage(file.getBytes());
		return imageRepo.save(image);
	}
	
	@GetMapping(value="/get/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageId(@PathVariable int id) {
		Optional<Images> img = imageRepo.findById(id);
		if(img.isPresent()) {
			Images image = img.get();
			return image.getImage();
		}
		return null;
	}

}
