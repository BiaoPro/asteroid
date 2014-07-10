/**
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.controller.attention;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.asteroid.controller.DatabaseDao;
import com.asteroid.controller.comment.CommentDao;
import com.asteroid.model.Attention;
import com.asteroid.model.Tag;
import com.asteroid.model.TagAdd;
import com.asteroid.util.HibernateUtils;
import com.asteroid.util.QueryResult;


/**
 * @author 吴泽标
 *
 */
public class AttentionDao extends DatabaseDao{
  private static final Log log = LogFactory.getLog(AttentionDao.class);
  
  public static final String USER_ID = "user_id";
  
  private static final String CLASS="com.asteroid.model.Attention";

  /**
   * 添加关注
   */
  public boolean save(Attention att) {
    Session session = HibernateUtils.openSession();
    try {
        Transaction tx = session.beginTransaction(); // 开始事务
        
        session.save(att);//保存操作
        
        tx.commit(); // 提交事务
        return true;
    } catch (RuntimeException e) {
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【Attention.save error:】\n"+e.getMessage());          
        return false;
    } finally {
        session.close(); // 关闭Session
    }
  }
  


  /**
   * 删除关注
   */
  public boolean delete(int a_id) {
    Session session = HibernateUtils.openSession();
    try {
        Transaction tx = session.beginTransaction(); // 开始事务
        
       Attention att=(Attention) session.get(Attention.class, a_id);
       
        session.delete(att); // 删除的是实体对象
        
        tx.commit(); // 提交事务
        return true;
    } catch (RuntimeException e) {
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【Attention.delete error:】\n"+e.getMessage());          
        return false;
    } finally {
        session.close(); // 关闭Session
    }
  }
  
  /**
   * 删除关注
   */
  public boolean delete(int user_id,int a_userid) {
    Session session = HibernateUtils.openSession();
    try {
        Transaction tx = session.beginTransaction(); // 开始事务
        
        Criteria criteria = session.createCriteria(Attention.class); 
        criteria.add(Expression.eq("user_id",user_id)); 
        criteria.add(Expression.eq("a_userid", a_userid)); 
        List<Attention> list=criteria.list();
        
        for(Attention att:list) session.delete(att);
        
        tx.commit(); // 提交事务
        return true;
    } catch (RuntimeException e) {
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【Attention.delete error:】\n"+e.getMessage());          
        return false;
    } finally {
        session.close(); // 关闭Session
    }
  }
  
  /**
   * 返回所有关注的人
   */
  public List<Attention> find(String propertyName, Object value) {
    log.debug("finding Attention  by Property");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Attention> list=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        
        Criteria criteria = session.createCriteria(Attention.class); 
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
  
  /**
   * 根据用户id返回所有关注
   */
  public List<Attention> findByUserId(int user_id) {
       return this.find(USER_ID,user_id);
  }
  
  
  /**
   * 查看用户是否已关注
   */
  public boolean findById(int user_id,int a_userid) {
       return this.find(CLASS,"user_id",user_id,"a_userid",a_userid).size()>0;
  }
  
  
  /**
   * 获取数据表中全部关注
   */
  public List<Attention> findAll() {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Attention> list=null;
    try {
      tx = session.beginTransaction(); // 开始事务
      Criteria criteria = session.createCriteria(Attention.class);
      list = criteria.list();
        tx.commit();
        
    } catch (RuntimeException e) {
        tx.rollback();
        System.out.println("【Attention.findAll error】\n"+e.getMessage());        
       
    } finally {
        session.close();
    }
    return list;
  }

  /**
   * 返回部分关注
   */
  public QueryResult findAll(int firstResult, int maxResults) {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Attention> list=null;
    try {
        tx = session.beginTransaction();

         list = session.createQuery(//
                "FROM Attention")//
                .setFirstResult(firstResult)//
                .setMaxResults(maxResults)//
                .list();

        // 查询总记录数
        Long count = (Long) session.createQuery(//
                "SELECT COUNT(*) FROM Attention")//
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



}
