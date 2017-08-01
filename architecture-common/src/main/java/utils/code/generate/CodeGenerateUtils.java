package utils.code.generate;

import freemarker.template.Template;
import utils.StringUtils;
import utils.code.generate.constants.GenCons;
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

        getInstance().generate();

        //getInstance().generate();
    }

    public void generate() throws Exception{

        Connection connection = getConnection1();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        ResultSet tbRs = databaseMetaData.getTables(null, null, null, null);

        List<String> tbNames = new LinkedList<>();

        while(tbRs.next()) {
            tbNames.add(tbRs.getString("TABLE_NAME"));
        }

        for (String tbName : tbNames) {

            ResultSet rs = databaseMetaData.getColumns(null, null, tbName, null);

            List<ExtraData> extraDataList = new ArrayList<>();


            ExtraData modelExtraData = new ExtraData();
            modelExtraData.setPackageName(GenCons.BASE_PACKAGE+".entity")
                    .setSuffix(".java")
                    .setTemplateName("Model.ftl")
                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\entity\\")
                    .setFileName(StringUtils.upFirst1(tbName))
                    .setTableName(tbName)
                    .setOtherType("String")
                    .putDataMap("listType", StringUtils.upFirst1(tbName));

            extraDataList.add(modelExtraData);

            ExtraData daoExtraData = new ExtraData();
            daoExtraData.setPackageName(GenCons.BASE_PACKAGE+".dao")
                    .setSuffix(".java")
                    .setTemplateName("DAO.ftl")
                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\dao\\")
                    .setFileName(StringUtils.upFirst1(tbName)+"Dao")
                    .setTableName(tbName)
                    .setOtherType("String")
                    .putDataMap("listType", StringUtils.upFirst1(tbName));

            extraDataList.add(daoExtraData);


            ExtraData serviceExtraData = new ExtraData();
            serviceExtraData.setPackageName(GenCons.BASE_PACKAGE+".service")
                    .setSuffix(".java")
                    .setTemplateName("Service.ftl")
                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\service\\")
                    .setFileName(StringUtils.upFirst1(tbName)+"Service")
                    .setTableName(tbName)
                    .setOtherType("String")
                    .putDataMap("listType", StringUtils.upFirst1(tbName));

            extraDataList.add(serviceExtraData);

            ExtraData serviceImplExtraData = new ExtraData();
            serviceImplExtraData.setPackageName(GenCons.BASE_PACKAGE+".service.impl")
                    .setSuffix(".java")
                    .setTemplateName("ServiceImpl.ftl")
                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\service\\impl\\")
                    .setFileName(StringUtils.upFirst1(tbName)+"ServiceImpl")
                    .setTableName(tbName)
                    .setOtherType("String")
                    .putDataMap("listType", StringUtils.upFirst1(tbName));


            extraDataList.add(serviceImplExtraData);

            ExtraData repoExtraData = new ExtraData();
            repoExtraData.setPackageName(GenCons.BASE_PACKAGE+".repo")
                    .setSuffix(".java")
                    .setTemplateName("Repo.ftl")
                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\repo\\")
                    .setFileName(StringUtils.upFirst1(tbName)+"Repository")
                    .setTableName(tbName)
                    .setOtherType("String")
                    .putDataMap("listType", StringUtils.upFirst1(tbName));

            extraDataList.add(repoExtraData);

//            ExtraData controllerExtraData = new ExtraData();
//            controllerExtraData.setPackageName(GenCons.BASE_PACKAGE+".repo")
//                    .setSuffix(".java")
//                    .setTemplateName("Controller.ftl")
//                    .setFilePath("C:\\ideaProject1\\tools\\architecture-services\\svc-service-user\\src\\main\\java\\cn\\com\\architecture\\repo\\")
//                    .setFileName(StringUtils.upFirst1(tbName)+"Repository")
//                    .setTableName(tbName)
//                    .putDataMap("listType", StringUtils.upFirst1(tbName));
//
//            extraDataList.add(controllerExtraData);



            DataBaseEntity dataBaseEntity = new DataBaseEntity(rs);

            DataBaseModelGen dataBaseModelGen = new DataBaseModelGen(dataBaseEntity);
            dataBaseModelGen.generate(extraDataList);



        }
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