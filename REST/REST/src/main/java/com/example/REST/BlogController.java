package com.example.REST;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    BlogMockData blogMockedData = BlogMockData.getInstance();

    // Fetching all blogs to the /blog end point
    @GetMapping({"/", "/blog"})
    public List<Blog> index() {
        return blogMockedData.fetchBlogs();
    }


    // fetching the blo with  the given id at the /blog/{id} end point
    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogMockedData.getBlogById(blogId);
    }

    // Searching a blog with the given search term at /search end point
    @PostMapping("/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchItem = body.get("text");
        return blogMockedData.searchBlogs(searchItem);
    }

    // Creating a new blog by using post at /blog
    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return blogMockedData.createBlog(id, title, content);
    }

    // Updating a blog
    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return blogMockedData.updateBlog(blogId, title, content);
    }

    //Deleting a blog
    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogMockedData.deleteBlog(blogId);
    }

}
