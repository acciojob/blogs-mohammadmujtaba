package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Optional<User> optionalUser = userRepository1.findById(userId);
        if(optionalUser.isPresent()){
            Blog blog = new Blog();
            blog.setContent(content);
            blog.setUser(optionalUser.get());
            blog.setTitle(title);

            Blog savedBlog = blogRepository1.save(blog);

            optionalUser.get().getBlogList().add(savedBlog);
            return savedBlog;
        }
        return null;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog blog = blogRepository1.findById(blogId).get();
        if(!Objects.isNull(blog)) {
            blogRepository1.deleteById(blogId);
        }
    }
}
