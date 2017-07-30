package utils.code.generate.gentype;

import utils.code.generate.entity.BaseEntity;
import utils.code.generate.entity.ExtraData;
import utils.code.generate.entity.JavaObj;

/**
 * 生成对象类型
 * @param <T>
 */
public abstract class AbsGenType<T extends BaseEntity> {

    protected T entity;

    public AbsGenType(T entity){
        this.entity = entity;
    }

    public abstract void generate(ExtraData extraData)throws Exception;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
