package utils.code.generate.gentype;

import utils.code.generate.CodeGenerateUtils;
import utils.code.generate.ColumnClass;
import utils.code.generate.entity.BaseEntity;
import utils.code.generate.entity.ExtraData;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelGen extends AbsGenType{

    public void generate(BaseEntity baseEntity,ExtraData extraData)throws Exception{


        final String suffix = ".java";
//        final String path = diskPath + changeTableName + suffix;
//        final String templateName = "Model.ftl";
//        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
//        while(resultSet.next()){
//            //id字段略过
//            if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
//            columnClass = new ColumnClass();
//            //获取字段名称
//            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
//            //获取字段类型
//            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
//            //转换字段名称，如 sys_name 变成 SysName
//            columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
//            //字段在数据库的注释
//            columnClass.setColumnComment(resultSet.getString("REMARKS"));
//            columnClassList.add(columnClass);
//        }

        String templateName = extraData.templateName;
        File mapperFile = extraData.mapperFile;

        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column",columnClassList);
        CodeGenerateUtils.getInstance().generateFileByTemplate(templateName,mapperFile,dataMap);

    }

}
