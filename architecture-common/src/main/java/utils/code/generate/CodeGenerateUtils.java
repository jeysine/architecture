package utils.code.generate;

import freemarker.template.Template;
import utils.StringUtils;
import utils.code.generate.entity.DataBaseEntity;
import utils.code.generate.entity.ExtraData;
import utils.code.generate.gentype.database.DataBaseDaoGen;
import utils.code.generate.gentype.database.DataBaseModelGen;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

/**
 * 描述：代码生成器
 * Created by lst on 2017/7/27.
 */
public class CodeGenerateUtils {

    private final String AUTHOR = "Ay";
    private final String CURRENT_DATE = "2017/05/03";
    private final String tableName = "tm_project_quality_problem";
    private final String packageName = "com.evada.pm.process.manage";
    private final String tableAnnotation = "质量问题";
    private final String URL = "jdbc:postgresql://192.168.3.160:10655/cibpm";
    private final String USER = "postgres";
    private final String PASSWORD = "888888";
    private final String DRIVER = "org.postgresql.Driver";
    private final String diskPath = "D://";
    private final String changeTableName = StringUtils.replaceUnderLineAndUpperCase(tableName);

    public Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public Connection getConnection1() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "1234");
        return connection;
    }

    private static class Inner{
        public static CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
    }

    public static CodeGenerateUtils getInstance(){
        return Inner.codeGenerateUtils;
    }

    public static void main(String[] args) throws Exception{

        getInstance().generateModel();
        getInstance().generateDao();

        //getInstance().generate();
    }

    public void generateModel() throws Exception{

        Connection connection = getConnection1();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        ResultSet tbRs = databaseMetaData.getTables(null, null, null, null);

        List<String> tbNames = new LinkedList<>();

        while(tbRs.next()) {
            tbNames.add(tbRs.getString("TABLE_NAME"));
        }

        for (String tbName : tbNames) {

            ResultSet rs = databaseMetaData.getColumns(null, null, tbName, null);

            ExtraData extraData = new ExtraData();
            extraData.setPackageName("cn.com.architecture.entity")
                    .setSuffix(".java")
                    .setTemplateName("Model.ftl")
                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\entity\\")
                    .setFileName(StringUtils.upFirst1(tbName))
                    .setTableName(tbName);

            DataBaseEntity dataBaseEntity = new DataBaseEntity(rs);

            DataBaseModelGen dataBaseModelGen = new DataBaseModelGen(dataBaseEntity);
            dataBaseModelGen.generate(extraData);

            extraData.clear();

        }
    }

    public void generateDao() throws Exception{

        Connection connection = getConnection1();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        ResultSet tbRs = databaseMetaData.getTables(null, null, null, null);

        List<String> tbNames = new LinkedList<>();

        while(tbRs.next()) {
            tbNames.add(tbRs.getString("TABLE_NAME"));
        }

        for (String tbName : tbNames) {

            ResultSet rs = databaseMetaData.getColumns(null, null, tbName, null);

            ExtraData extraData = new ExtraData();
            extraData.setPackageName("cn.com.architecture.dao")
                    .setSuffix(".java")
                    .setTemplateName("DAO.ftl")
                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\dao\\")
                    .setFileName(StringUtils.upFirst1(tbName)+"Dao")
                    .setTableName(tbName);

            extraData.putDataMap("listType", "User");

            DataBaseEntity dataBaseEntity = new DataBaseEntity(rs);

            DataBaseDaoGen dataBaseDaoGen = new DataBaseDaoGen(dataBaseEntity);

            dataBaseDaoGen.generate(extraData);

            extraData.clear();
        }
    }

    @Deprecated
    public void generate() throws Exception{
        try {
            Connection connection = getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getColumns(null,"%", tableName,"%");
            //生成Mapper文件
            generateMapperFile(resultSet);
            //生成Dao文件
            generateDaoFile(resultSet);
            //生成Repository文件
            generateRepositoryFile(resultSet);
            //生成服务层接口文件
            generateServiceInterfaceFile(resultSet);
            //生成服务实现层文件
            generateServiceImplFile(resultSet);
            //生成Controller层文件
            generateControllerFile(resultSet);
            //生成DTO文件
            generateDTOFile(resultSet);
            //生成Model文件
            generateModelFile(resultSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{

        }
    }

    @Deprecated
    public void generateModelFile(ResultSet resultSet) throws Exception{

        final String suffix = ".java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Model.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while(resultSet.next()){
            //id字段略过
            if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(StringUtils.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("model_column",columnClassList);
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    @Deprecated
    public void generateDTOFile(ResultSet resultSet) throws Exception{
        final String suffix = "DTO.java";
        final String path = "D://" + changeTableName + suffix;
        final String templateName = "DAO.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    @Deprecated
    public void generateControllerFile(ResultSet resultSet) throws Exception{
        final String suffix = "Controller.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    @Deprecated
    public void generateServiceImplFile(ResultSet resultSet) throws Exception{
        final String suffix = "ServiceImpl.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    @Deprecated
    public void generateServiceInterfaceFile(ResultSet resultSet) throws Exception{
        final String prefix = "I";
        final String suffix = "Service.java";
        final String path = diskPath + prefix + changeTableName + suffix;
        final String templateName = "ServiceInterface.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    @Deprecated
    public void generateRepositoryFile(ResultSet resultSet) throws Exception{
        final String suffix = "Repository.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Repository.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);
    }

    @Deprecated
    public void generateDaoFile(ResultSet resultSet) throws Exception{
        final String suffix = "DAO.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "DAO.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    @Deprecated
    public void generateMapperFile(ResultSet resultSet) throws Exception{
        final String suffix = "Mapper.xml";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        Map<String,Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName,mapperFile,dataMap);

    }

    @Deprecated
    public void generateFileByTemplate(final String templateName,File file,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("table_name",changeTableName);
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",packageName);
        dataMap.put("table_annotation",tableAnnotation);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }

}