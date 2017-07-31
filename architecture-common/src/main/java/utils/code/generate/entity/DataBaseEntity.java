package utils.code.generate.entity;

import utils.StringUtils;
import utils.code.generate.ColumnClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库对象生成代码处理实体类
 */
public class DataBaseEntity extends BaseEntity {

    private ResultSet resultSet;

    public DataBaseEntity(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    public ResultSet getEntity() {
        return resultSet;
    }

    public List<ColumnClass> createColumnClass(ResultSet resultSet) throws SQLException {

        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while(resultSet.next()){
            //id字段略过
            //if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(StringUtils.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            //默认值
            columnClass.setDefValue(resultSet.getString("COLUMN_DEF"));

            columnClassList.add(columnClass);
        }
        return columnClassList;
    }

}
