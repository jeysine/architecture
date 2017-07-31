package utils.code.generate;

/**
 * 数据库字段封装类
 * Created by yarus li on 2017/7/30.
 */
public class ColumnClass {

    /** 数据库字段名称 **/
    private String columnName;
    /** 数据库字段类型 **/
    private String columnType;
    /** 数据库字段首字母小写且去掉下划线字符串 **/
    private String changeColumnName;
    /** 数据库字段注释 **/
    private String columnComment;
    /** 数据库默认值 **/
    private String defValue;

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getChangeColumnName() {
        return changeColumnName;
    }

    public void setChangeColumnName(String changeColumnName) {
        this.changeColumnName = changeColumnName;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

    public String getDefValue() {
        return defValue;
    }
}