package hello.service;

import hello.dao.BlogDao;
import hello.entity.Blog;
import hello.entity.BlogListResult;
import hello.entity.BlogResult;
import hello.entity.Result;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BlogService {
    private BlogDao blogDao;
    private UserService userService;

    @Inject
    public BlogService(BlogDao blogDao, UserService userService) {
        this.blogDao = blogDao;
        this.userService = userService;
    }

    public Result getBlogs(Integer page, Integer pageSize, Integer userId) {
        try {
            List<Blog> blogs = blogDao.getBlogs(page, pageSize, userId);
            blogs.forEach(blog -> blog.setUser(userService.getUserById(blog.getUserId())));

            int count = blogDao.count(userId);

            int pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;


            return BlogListResult.newResults(blogs, count, page, pageCount);
        } catch (Exception e) {
            e.printStackTrace();
            return BlogListResult.failure("系统异常");
        }
    }

    public BlogResult getBlogById(Integer id) {
        try {
            return BlogResult.success("获取成功", blogDao.selectBlogById(id));
        } catch (Exception e) {
            return BlogResult.failure(e);
        }
    }

    public BlogResult insertBlog(Blog newBlog) {
        try {
            return BlogResult.success("创建成功", blogDao.insertBlog(newBlog));
        } catch (Exception e) {
            return BlogResult.failure(e);
        }
    }

    public BlogResult updateBlog(Integer blogId, Blog newBlog) {
        try {
            return BlogResult.success("修改成功", blogDao.updateBlog(newBlog));
        } catch (Exception e) {
            return BlogResult.failure(e);
        }
    }
}
