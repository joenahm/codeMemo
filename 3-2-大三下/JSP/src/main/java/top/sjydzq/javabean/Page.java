package top.sjydzq.javabean;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by 11620 on 2019/4/9 9:37
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageSize;
    private int pageNo;
    private int totalPages;
    private int recordCount;
    private Vector<T> records;
    private boolean hasPrev;
    private boolean hasNext;

    public Page(int pageSize, int pageNo, Vector<T> records) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.records = records;
        this.recordCount = records.size();
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public Vector<T> getRecords() {
        return records;
    }

    public boolean hasPrev() {
        return hasPrev;
    }

    public boolean hasNext() {
        return hasNext;
    }
}
