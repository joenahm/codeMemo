package top.sjydzq.utils;

public abstract class Pagination {
    public static int paginate(int totalPages, int pageSize) {
        return  (int)Math.ceil((float) totalPages/(float) pageSize);
    }
}
