package utils.code.generate.entity;

import freemarker.ext.beans.HashAdapter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExtraData {

    public String templateName = "";

    /**
     * FreeMarker模板文件
     */
    public File mapperFile;

    /**
     * 文件路径
     */
    public String filePath;

    /**
     * 文件后缀
     */
    public String suffix;

    /**
     * 文件包名
     */
    public String packageName;

    /**
     * 文件名
     */
    public String fileName;

    /**
     * 额外数据
     */
    public Map<String,Object> dataMap = null;

    /**
     * 数据库表名
     */
    public String tableName;

    public ExtraData setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public ExtraData setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public ExtraData setMapperFile(File mapperFile) {
        this.mapperFile = mapperFile;
        return this;
    }

    public ExtraData setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public ExtraData setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public ExtraData setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public ExtraData setDataMap(Map<String,Object> dataMap){
        this.dataMap = dataMap;
        return this;
    }

    public ExtraData putDataMap(String key,Object value){
        if(this.dataMap == null){
            dataMap = new HashMap<>();
        }
        this.dataMap.put(key,value);
        return this;
    }

    public Object getDataMap(String key){
        return dataMap.get(key);
    }

    public ExtraData setTableName(String tableName){
        this.tableName = tableName;
        return this;
    }

    public String getPackageName() {
        return packageName;
    }

    public File getMapperFile() {
        return mapperFile;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void clear(){
        templateName = null;
        mapperFile = null;
        filePath = null;
        suffix = null;
        packageName = null;
        dataMap = null;
        fileName = null;
    }
}
