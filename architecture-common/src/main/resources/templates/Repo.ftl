package ${obj.packageName};

import cn.com.architecture.entity.${extra.tableName?cap_first};
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 描述：${obj.desc}
* @author ${obj.author}
* @email ${obj.email}
* @date ${obj.getDateString()}
*/
public interface ${extra.fileName} extends JpaRepository<${extra.tableName?cap_first},${extra.otherType?cap_first}>{
}
