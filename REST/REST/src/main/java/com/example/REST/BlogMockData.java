package com.example.REST;

import java.util.ArrayList;
import java.util.List;

public class BlogMockData {

    //list of blog posts
    private List<Blog> blogs;

    //singleton class - Only once instance of the class is allowed.
    private static BlogMockData instance = null;
    public static BlogMockData getInstance() {
        if (instance == null) {
            instance = new BlogMockData();
        }
        return instance;
    }
    // As the class is singleton, only one instance of the articles is created
    public BlogMockData() {
        blogs = new ArrayList<Blog>();
        blogs.add(new Blog(1, "Article 1", "This is the first Article"));
        blogs.add(new Blog(2, "Article 2", "This is the second Article. Content will increase"));
        blogs.add(new Blog(3, "Article 3", "This is the third Article. Third Article contains more content than the second"));
        blogs.add(new Blog(4, "Article 4", "This is the fourth Article. Fourth is small"));
        blogs.add(new Blog(5, "Article 5", "This is the fifth Article. I just dont care about any other article"));
    }

    // return all blogs
    public List<Blog> fetchBlogs() {
        return blogs;
    }

    // return blog by id
    public Blog getBlogById(int id) {
        for(Blog b: blogs) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    //search blog by text
    public List<Blog> searchBlogs(String searchTerm) {
        List<Blog> searchedBlogs = new ArrayList<Blog>();

        for (Blog b : blogs) {
            if (b.getTitle().toLowerCase().contains(searchTerm) ||
                    b.getContent().toLowerCase().contains(searchTerm)) {
                searchedBlogs.add(b);
            }

        }
        return searchedBlogs;
    }

    // Create a new Blog
    public Blog createBlog(int id, String title, String content) {
        Blog newBlog = new Blog(id, title, content);
        blogs.add(newBlog);
        return newBlog;
    }

    // update Blog
    public Blog updateBlog(int id, String title, String content) {
        for (Blog b : blogs) {
            if (b.getId() == id) {
                int blogIndex = blogs.indexOf(b);
                b.setTitle(title);
                b.setContent(content);
                blogs.set(blogIndex, b);
                return b;
            }
        }
        return null;
    }

    // Delete Blog
    public boolean deleteBlog(int id) {
        int blogIndex = -1;
        for (Blog b : blogs) {
            if (b.getId() == id) {
                blogIndex = blogs.indexOf(b);
                break;
            }
        }
        if (blogIndex > -1) {
            blogs.remove(blogIndex);
        }
        return true;
    }


}
