package hello.entity;

public class BlogResult extends Result<Blog> {
    private int total;
    private int page;
    private int totalPage;

    private BlogResult(String status, String msg, Blog data) {
        super(status, msg, data);
    }

    public static BlogResult failure(Exception e) {
        return new BlogResult("fail", e.getMessage(), null);
    }

    public static BlogResult failure(String message) {
        return new BlogResult("fail",message, null);
    }

    public static BlogResult success(String message, Blog data) {
        return new BlogResult("ok", message, data);
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
