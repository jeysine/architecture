package utils.code.generate.gentype;

import utils.code.generate.entity.BaseEntity;
import utils.code.generate.entity.ExtraData;

public abstract class AbsGenType<T> {

    public abstract void generate(BaseEntity<T> baseEntity,ExtraData extraData)throws Exception;


}
