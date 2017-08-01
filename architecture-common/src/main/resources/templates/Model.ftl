package ${obj.packageName};

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 描述：${obj.desc}模型
* @author ${obj.author}
* @email ${obj.email}
* @date ${obj.getDateString()}
*/

@Entity
@Table(name = "${extra.tableName}")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ${obj.name} extends Base implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
<#if obj.columnClassList?exists>
    <#list obj.columnClassList as model>
    /** ${model.columnComment!} */
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT')>
    private String ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'TIMESTAMP' >
    private Date ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'INT' >
    private Integer ${model.changeColumnName?uncap_first};
    </#if>
    </#list>
</#if>

<#if obj.columnClassList?exists>
    <#list obj.columnClassList as model>
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT')>
    /** 获取${model.columnComment!} */
    public String get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    /** 设置${model.columnComment!} */
    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
    </#if>
    <#if model.columnType = 'TIMESTAMP' >
    /** 获取${model.columnComment!} */
    public Date get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    /** 设置${model.columnComment!} */
    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
    </#if>
    <#if model.columnType = 'INT' >
    /** 获取${model.columnComment!} */
    public Integer get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    /** 设置${model.columnComment!} */
    public void set${model.changeColumnName}(Integer ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
    </#if>

    </#list>
</#if>

<#if obj.columnClassList?exists>
    <#assign head="${obj.name}{"/>
    <#assign part=""/>
    <#list obj.columnClassList as model>
        <#assign part=part+"\", ${model.changeColumnName?uncap_first}='\" + ${model.changeColumnName?uncap_first} +"/>
    </#list>
    <#assign end="'}'"/>
    @Override
    public String toString() {
        return "${head}"+${part}"${end}";
    }
</#if>
}