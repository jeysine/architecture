package ${obj.packageName};

import cn.com.architecture.service.Service;
import cn.com.architecture.entity.${extra.tableName?cap_first};
import cn.com.architecture.service.${extra.tableName?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 描述：${obj.desc}
* @author ${obj.author}
* @email ${obj.email}
* @date ${obj.getDateString()}
*/

@Service
public class ${extra.fileName} implements ${extra.tableName?cap_first}Service{

    @Autowired
    private ${extra.fileName} ${extra.fileName?uncap_first};

    @Override
    public ${extra.tableName} save(${extra.tableName} entity) {
        return ${extra.fileName?uncap_first}.save(entity);
    }

    @Override
    public User findById(String id) {
        return ${extra.fileName?uncap_first}.findOne(id);
    }

    @Override
    public void delete(String s) {
        ${extra.fileName?uncap_first}.delete(s);
    }

    @Override
    public Iterable<${extra.tableName?cap_first}> findAll() {
        return ${extra.fileName?uncap_first}.findAll();
    }

    @Override
    public long count() {
        return ${extra.fileName?uncap_first}.count();
    }

    @Override
    public boolean exists(String s) {
        return ${extra.fileName?uncap_first}.exists(s);
    }
}
