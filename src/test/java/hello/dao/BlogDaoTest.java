package hello.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

class BlogDaoTest {
    SqlSession mockSession = Mockito.mock(SqlSession.class);
    private BlogDao blogDao = new BlogDao(mockSession);

    @Test
    public void testGetBlogs() {
        blogDao.getBlogs(2, 10, 3);
        Map<String, Object> expectedParam = new HashMap<>();
        expectedParam.put("user_id", 3);
        expectedParam.put("offset", 10);
        expectedParam.put("limit", 10);
        Mockito.verify(mockSession).selectList("selectBlog", expectedParam);
    }
}