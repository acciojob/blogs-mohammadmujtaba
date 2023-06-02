package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Optional<Blog> blogOptional = blogRepository2.findById(blogId);
        if(blogOptional.isPresent()){
            Image image = new Image();
            image.setBlog(blogOptional.get());
            image.setDescription(description);
            image.setDimensions(dimensions);

            Image savedImage = imageRepository2.save(image);
            blogOptional.get().getImageList().add(savedImage);

            return savedImage;
        }
        return null;
    }

    public void deleteImage(Integer id){
        Optional<Image> optionalImage = imageRepository2.findById(id);
        if(optionalImage.isPresent()) {
            imageRepository2.deleteById(id);
        }
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Optional<Image> optionalImage = imageRepository2.findById(id);
        if(optionalImage.isPresent()) {
            Image image = optionalImage.get();
            String imagedDimension[] = image.getDimensions().split("[V]");
            String size[] = screenDimensions.split("[V]");

            int imageSize = Integer.parseInt(imagedDimension[0])*Integer.parseInt(imagedDimension[1]);
            int screenSize = Integer.parseInt(size[0])*Integer.parseInt(size[1]);

            return screenSize / imageSize;
        }
        return 0;
    }
}
