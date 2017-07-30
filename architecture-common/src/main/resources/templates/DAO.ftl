package ${obj.packageName};

import cn.com.architecture.entity.${extra.tableName?cap_first};

/**
* 描述：${obj.desc}
* @author ${obj.author}
* @email ${obj.email}
* @date ${obj.getDateString()}
*/
public interface ${extra.fileName} extends BaseDAO<${extra.tableName?cap_first},${extra.tableName?cap_first}>{
}
