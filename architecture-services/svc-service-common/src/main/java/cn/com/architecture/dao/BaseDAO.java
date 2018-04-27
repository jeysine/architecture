package cn.com.architecture.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<M,QM>{
	
	void insert(M m);
	int update(M m);
	void delete(@Param("id") String id);
	void deleteByIds(Object[] ids);

	M findById(@Param("id") String id);
	List<QM> getList();
	List<QM> getByConditionPage(QM qm);

	boolean isExistName(M m);

}
