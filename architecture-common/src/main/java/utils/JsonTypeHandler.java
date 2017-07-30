package utils;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;


// 继承自BaseTypeHandler<Object> 使用Object是为了让JsonUtil可以处理任意类型
public class JsonTypeHandler extends BaseTypeHandler<Object> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter,
            JdbcType jdbcType) throws SQLException {
        
        String formatString=JsonUtil.stringify(parameter);
    	ps.setString(i, formatString);
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
    	String value=rs.getString(columnName);
        return JsonUtil.parse(value, Object.class);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value=rs.getString(columnIndex);
        return JsonUtil.parse(value, Object.class);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
    	String value=cs.getString(columnIndex);
        return JsonUtil.parse(value, Object.class);
    }

}
