package top.sjydzq.utils;

import java.sql.PreparedStatement;

public abstract class StatementCallback {
    public abstract void set(PreparedStatement statement);
}
