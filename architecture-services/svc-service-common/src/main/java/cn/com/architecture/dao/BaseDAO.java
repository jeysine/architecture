package cn.com.architecture.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<M,QM>{
	
	void create(M m);
	int update(M m);
	void delete(@Param("uuid") Object uuid);
	void deleteByIds(Object[] ids);

	M getByUuid(@Param("uuid") Object uuid);
	List<QM> getList();
	List<QM> getByConditionPage(QM qm);

	boolean isExistName(M m);

}
