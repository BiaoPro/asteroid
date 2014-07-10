/**
 * 文件创建时间：2014年6月6日
 */
package com.asteroid.controller.letter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.asteroid.controller.comment.CommentDao;
import com.asteroid.model.PrivateLetter;
import com.asteroid.util.HibernateUtils;

/**
 * @author 吴泽标
 *
 */
public class PrivateLetterDao {
private static final Log log = LogFactory.getLog(PrivateLetterDao.class);
  
  /**
   * 添加私信
   */
  public boolean save(PrivateLetter obj){
    Session session = HibernateUtils.openSession();
    log.debug("saving PrivateLetter instance");
    try {
    
          Transaction tx = session.beginTransaction(); // 开始事务
          
          session.save(obj);
          
          tx.commit(); // 提交事务
      
        log.debug("save successful");
         return true;
    } catch (RuntimeException re) {
        log.error("save failed", re);
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【Attention.save error:】\n"+re.getMessage());          
        return false;
    }finally {
      session.close(); // 关闭Session
    }
  }
  
  /**
   * 修改私信
   */
  public boolean update(PrivateLetter obj){
    Session session = HibernateUtils.openSession();
    log.debug("update PrivateLetter instance");
    try {
    
          Transaction tx = session.beginTransaction(); // 开始事务
          
          session.update(obj);
          
          tx.commit(); // 提交事务
      
        log.debug("update successful");
         return true;
    } catch (RuntimeException re) {
        log.error("update failed", re);
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【PrivateLetter.update error:】\n"+re.getMessage());          
        return false;
    }finally {
      session.close(); // 关闭Session
    }
  }
  
  /**
   * 删除私信
   */
  public boolean delete(PrivateLetter obj){
    Session session = HibernateUtils.openSession();
    log.debug("delete PrivateLetter:");
    try {
    
          Transaction tx = session.beginTransaction(); // 开始事务
          
          session.delete(obj);
          
          tx.commit(); // 提交事务
      
        log.debug("delete successful");
         return true;
    } catch (RuntimeException re) {
        log.error("delete failed", re);
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【PrivateLetter.delete error:】\n"+re.getMessage());          
        return false;
    }finally {
      session.close(); // 关闭Session
    }
  }
  
  
  /**
   * 删除私信by ID
   */
  public boolean delete(int id) {
    Session session = HibernateUtils.openSession();
        PrivateLetter obj  = (PrivateLetter)session.get(PrivateLetter.class, id); // 要先获取到这个对象
        session.close();
        return this.delete(obj); // 删除的是实体对象
  }
  
  /**
   * 获取私信
   */
  public List<PrivateLetter> findAll() {
    log.debug("finding all PrivateLetter:");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<PrivateLetter> list=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        Criteria criteria = session.createCriteria(PrivateLetter.class);
        list = criteria.list();
        tx.commit();
        log.debug("find all successful");
    } catch (RuntimeException e) {
        log.error("find all failed", e);
        tx.rollback();
    }finally{
      session.close();
      return list;
    }
   }
  
  
   public List<PrivateLetter> find(String propertyName, Object value) {
     log.debug("finding PrivateLetter  by Property");
     Session session = HibernateUtils.openSession();
     Transaction tx = null;
     List<PrivateLetter> list=null;
     try {
         tx = session.beginTransaction(); // 开始事务
         
         Criteria criteria = session.createCriteria(PrivateLetter.class); 
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
