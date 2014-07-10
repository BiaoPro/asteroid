/**
 * 文件创建时间：2014年6月6日
 */
package com.asteroid.controller.praise;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.asteroid.controller.DatabaseDao;
import com.asteroid.controller.praise.AddPraiseDao;
import com.asteroid.model.AddPraise;
import com.asteroid.model.Attention;
import com.asteroid.model.Tag;
import com.asteroid.util.HibernateUtils;

/**
 * @author 吴泽标
 *
 */
public class AddPraiseDao extends DatabaseDao  {
private static final Log log = LogFactory.getLog(AddPraiseDao.class);
private static final String CLASS="com.asteroid.model.AddPraise";  
  /**
   * 添加点赞
   */
  public boolean save(AddPraise obj){ return super.save(obj);}
  
  /**
   * 修改点赞
   */
  public boolean update(AddPraise obj){return super.update(obj);}
  
  /**
   * 删除点赞
   */
  public boolean delete(AddPraise obj){
    
    
    
    return false;
  }
  
  /**
   * 删除点赞by ID
   */
  public boolean delete(int id) {
    Session session = HibernateUtils.openSession();
        AddPraise obj  = (AddPraise)session.get(AddPraise.class, id); // 要先获取到这个对象
        session.close();
        return this.delete(obj); // 删除的是实体对象
  }
  
  
  
  public  boolean deleteByID2(int user_id,int release_id){
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    AddPraise vo=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        
        String sql="delete AddPraise as A where A.user_id ="+user_id+" and A.release_id="+release_id+"";
        
        Query query = session.createQuery(sql);
        
        
        int n = query.executeUpdate();
        
        tx.commit();
        if(n>0) return true;
        else return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }finally{
      session.clear();
    }
    
  }
  
  
  /**
   * 判断是否已被点赞
   */
  public boolean findById(int user_id,int release_id){
    return super.find(CLASS, "user_id",user_id,"release_id", release_id).size()>0;
  }
  
  
  
  /**
   * 根据用户id返回所有关注
   */
  public List<AddPraise> findByUserId(int user_id) {
       return this.find("user_id",user_id);
  }
  
  
  
  /**
   * 获取点赞
   */
  public List<AddPraise> findAll() {
    log.debug("finding all AddPraise:");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<AddPraise> list=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        Criteria criteria = session.createCriteria(AddPraise.class);
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
  
  
   public List<AddPraise> find(String propertyName, Object value) {
     log.debug("finding AddPraise  by Property");
     Session session = HibernateUtils.openSession();
     Transaction tx = null;
     List<AddPraise> list=null;
     try {
         tx = session.beginTransaction(); // 开始事务
         
         Criteria criteria = session.createCriteria(AddPraise.class); 
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
