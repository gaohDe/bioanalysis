package com.ys.project.imp;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ys.project.inface.EntityDao;

public class EntityDaoSqlMapImpl<T> extends SqlMapClientDaoSupport implements EntityDao<T> {
   public static final String PREFIX_INSERT = "insert";
   public static final String PREFIX_UPDATE = "update";
   public static final String PREFIX_DELETE = "delete";
   public static final String PREFIX_SELECT = "select";
   public static final String SUFFIX_COUNT = "Count";
   public static final String SUFFIX_LIST = "List";
   public static final String SUFFIX_PAGINATED_LIST = "PaginatedList";
	 
   public Long insertEntity(T t)
     throws DataAccessException
   {
     String statement = "insert" + t.getClass().getSimpleName();
     return (Long)super.getSqlMapClientTemplate().insert(statement, t);
   }
 
   public int updateEntity(T t) throws DataAccessException {
     String statement = "update" + t.getClass().getSimpleName();
     return super.getSqlMapClientTemplate().update(statement, t);
   }
 
   public int deleteEntity(T t) throws DataAccessException {
     String statement = "delete" + t.getClass().getSimpleName();
     return super.getSqlMapClientTemplate().update(statement, t);
   }
 
   public T selectEntity(T t) throws DataAccessException
   {
     String statement = "select" + t.getClass().getSimpleName();
     return (T)super.getSqlMapClientTemplate().queryForObject(statement, t);
   }
 
   public Long selectEntityCount(T t) throws DataAccessException {
     String statement = "select" + t.getClass().getSimpleName() + "Count";
     return (Long)super.getSqlMapClientTemplate().queryForObject(statement, t);
   }
 
   public List<T> selectEntityList(T t) throws DataAccessException
   {
     String statement = "select" + t.getClass().getSimpleName() + "List";
     return super.getSqlMapClientTemplate().queryForList(statement, t);
   }
 
   public List<T> selectEntityPaginatedList(T t) throws DataAccessException
   {
     String statement = "select" + t.getClass().getSimpleName() + "PaginatedList";
     return super.getSqlMapClientTemplate().queryForList(statement, t);
   }

}
