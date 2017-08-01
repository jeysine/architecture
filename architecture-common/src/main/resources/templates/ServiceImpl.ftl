package ${obj.packageName};

<#assign repo="${extra.tableName}Repository"/>

import cn.com.architecture.entity.${extra.tableName?cap_first};
import cn.com.architecture.repo.${repo?cap_first};
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
    private ${repo?cap_first} ${repo};

    @Override
    public ${extra.tableName?cap_first} save(${extra.tableName?cap_first} entity) {
        return ${repo}.save(entity);
    }

    @Override
    public ${extra.tableName?cap_first} findById(String id) {
        return ${repo}.findOne(id);
    }

    @Override
    public void delete(String s) {
        ${repo}.delete(s);
    }

    @Override
    public Iterable<${extra.tableName?cap_first}> findAll() {
        return ${repo}.findAll();
    }

    @Override
    public long count() {
        return ${repo}.count();
    }

    @Override
    public boolean exists(String s) {
        return ${repo}.exists(s);
    }
}
