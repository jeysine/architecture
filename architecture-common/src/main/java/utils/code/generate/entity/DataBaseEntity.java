package utils.code.generate.entity;

import java.sql.ResultSet;

public class DataBaseEntity extends BaseEntity<ResultSet> {

    private ResultSet resultSet;

    public DataBaseEntity(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    @Override
    ResultSet getEntity() {
        return resultSet;
    }
}
