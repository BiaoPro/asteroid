/**
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.controller.tag;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.asteroid.controller.DatabaseDao;
import com.asteroid.model.Tag;
import com.asteroid.util.HibernateUtils;
import com.asteroid.util.QueryResult;

/**
 * @author 吴泽标
 */
public class TagDao extends DatabaseDao {
private static final Log log=LogFactory.getLog(TagDao.class);

private static final String CLASS="com.asteroid.model.Tag";
/**
 * 添加标签
 */
  public boolean save(Tag tag) {return super.save(tag);}
  /**
   * 修改标签
   */
  public boolean update(Tag tag) {return super.update(tag);}
  /**
   * 获得标签
   */
  public Tag findById(int tag_id) {return (Tag)(super.findById(CLASS,tag_id));}
  
  /**
   * 返回所有标签
   */
  public List<Tag> findAll() {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Tag> list=null;
    try {
      tx = session.beginTransaction(); // 开始事务
      Criteria criteria = session.createCriteria(Tag.class);
      list = criteria.list();
        tx.commit();
        return list;
        
    } catch (RuntimeException e) {
        tx.rollback();
        System.out.println("【Tag.findAll error】\n"+e.getMessage());        
    } finally {
        session.close();
    }
    return list;
  }
  /**
   * 返回部分标签
   */
  public QueryResult findAll(int firstResult, int maxResults) {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();

        List<Tag> list = session.createQuery(//
                "FROM Tag")//
                .setFirstResult(firstResult)//
                .setMaxResults(maxResults)//
                .list();

        // 查询总记录数
        Long count = (Long) session.createQuery(//
                "SELECT COUNT(*) FROM Tag")//
                .uniqueResult();
        tx.commit();
        
        //  返回结果
        return new QueryResult(count.intValue(), list);
    } catch (RuntimeException e) {
        tx.rollback();
       return null;
    } finally {
        session.close();
    }
 }
  
  /**
   * 按列属性返回标签列表
   */
  public List<Tag> find(String propertyName, Object value) {
    log.debug("finding Tag  by Property");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Tag> list=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        
        Criteria criteria = session.createCriteria(Tag.class); 
        criteria.add(Expression.eq(propertyName,value)); 
        list = criteria.list(); // 要先获取到这个对象
        
        tx.commit();
        log.debug("find by example successful, result size: "
            + list.size());
        return list;
    } catch (RuntimeException re) {
        log.error("find by example failed", re);
        return null;
    }finally{
      session.clear();
    }
  }
}


