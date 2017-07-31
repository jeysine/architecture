package utils.code.generate.entity;

import utils.code.generate.ColumnClass;
import utils.code.generate.constants.GenerateConstants;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by li on 2017/7/28.
 */

public class JavaObj {

    /**文件名*/
    private String name;
    /**作者*/
    private String author ="yarus li";
    /**作者邮箱*/
    private String email;

    private String desc;

    private Date createDate = new Date();

    private List<ColumnClass> columnClassList = new ArrayList<>();

    private String packageName;

    private Map<String,String> extraMap = new HashMap<>();

    private SimpleDateFormat dateFormat = null;

    public JavaObj(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColumnClassList(List<ColumnClass> columnClassList) {
        this.columnClassList = columnClassList;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public List<ColumnClass> getColumnClassList() {
        return columnClassList;
    }

    public String getPackageName() {
        return packageName;
    }

    public void addFieldObj(ColumnClass fieldObj){
        columnClassList.add(fieldObj);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEmail() {
        return email;
    }

    public void setExtraMap(Map<String, String> extraMap) {
        this.extraMap = extraMap;
    }

    public void putExtraMap(String key,String value) {
        this.extraMap.put(key,value);
    }

    public Map<String, String> getExtraMap() {
        return extraMap;
    }

    public String getExtraMapValue(String key) {
        return extraMap.get(key);
    }

    public String getDateString(){
        if(dateFormat==null){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return dateFormat.format(createDate);
    }

    public static JavaObj defaultObj(){

        JavaObj obj = new JavaObj();
        obj.setAuthor(GenerateConstants.AUTHOR);
        obj.setCreateDate(new Date());
        obj.setEmail(GenerateConstants.EMAIL);
        obj.setDesc(GenerateConstants.DESCRIPTION);


        return obj;

    }

}
