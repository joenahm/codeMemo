package top.sjydzq.utils;

import java.sql.PreparedStatement;

public abstract class StatementCallback {
    abstract void set(PreparedStatement statement);
}
