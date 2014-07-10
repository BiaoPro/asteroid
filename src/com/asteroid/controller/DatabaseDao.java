/**
 * Copyright (c) 广州顶九信息技术有限公司2014 版权
 *
 * 文件创建时间：2014年6月6日
 */
package com.asteroid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.asteroid.model.AddPraise;
import com.asteroid.model.Attention;
import com.asteroid.model.Tag;
import com.asteroid.model.UserRelease;
import com.asteroid.util.HibernateUtils;
import com.asteroid.util.QueryResult;

/**
 * @author 吴泽标
 *
 */
public abstract class DatabaseDao {
  private static final Log log=LogFactory.getLog(DatabaseDao.class);
  
  /**
   * 保存
   */
  public  boolean save(Object obj) {
    Session session = HibernateUtils.openSession();
    try {
        Transaction tx = session.beginTransaction(); // 开始事务
        
        session.save(obj);//保存操作
        
        tx.commit(); // 提交事务
        return true;
    } catch (RuntimeException e) {
        session.getTransaction().rollback(); // 回滚事务
        return false;
    } finally {
        session.close(); // 关闭Session
    }
  }

  /**
   * 更新
   */
  public boolean update(Object obj) {
    Session session = HibernateUtils.openSession();
    try {
        Transaction tx = session.beginTransaction(); // 开始事务
        
        session.update(obj);//更新操作
        
        tx.commit(); // 提交事务
        return true;
    } catch (RuntimeException e) {
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【Tag.update error:】\n"+e.getMessage());          
        return false;
    } finally {
        session.close(); // 关闭Session
    }
  }
  
  /**
   * 删除
   */
  private boolean delete(Object obj){
    Session session = HibernateUtils.openSession();
    log.debug("delete AddPraise:");
    try {
    
          Transaction tx = session.beginTransaction(); // 开始事务
          
          session.delete(obj);
          
          tx.commit(); // 提交事务
      
        log.debug("delete successful");
         return true;
    } catch (RuntimeException re) {
        log.error("delete failed", re);
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【AddPraise.delete error:】\n"+re.getMessage());          
        return false;
    }finally {
      session.close(); // 关闭Session
    }
  }
  /**
   * 按id删除
   */
  public boolean delete(String className,int id){
    Session session = HibernateUtils.openSession();
    log.debug("delete by id:");
    try {
    
          Transaction tx = session.beginTransaction(); // 开始事务
          
          Object obj=session.get(Class.forName(className), id);
          
          session.delete(obj);
          
          tx.commit(); // 提交事务
      
        log.debug("delete successful");
         return true;
    } catch (RuntimeException re) {
        log.error("delete failed", re);
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【delete error:】\n"+re.getMessage());          
        return false;
    } catch (ClassNotFoundException e) { e.printStackTrace();return false;
    } finally {
      session.close(); // 关闭Session
    }
  }
  
  /**
   * 按id查找
   */
  public Object findById(String className,int id){
    Session session = HibernateUtils.openSession();
    log.debug("delete by id:");
    try {
    
          Transaction tx = session.beginTransaction(); // 开始事务
          
          Object obj=session.get(Class.forName(className), id);
          
          tx.commit(); // 提交事务
      
        log.debug("delete successful");
         return obj;
    } catch (RuntimeException re) {
        log.error("delete failed", re);
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【delete error:】\n"+re.getMessage());          
        return null;
    } catch (ClassNotFoundException e) { e.printStackTrace();return false;
    } finally {
      session.close(); // 关闭Session
    }
  }
  
  /**
   * 查询
   */
  public List findAll(String name) {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Tag> list=null;
    try {
      tx = session.beginTransaction(); // 开始事务
      Criteria criteria = session.createCriteria(Class.forName(name));
      list = criteria.list();
        tx.commit();
        return list;
        
    } catch (RuntimeException e) {
        tx.rollback();
        System.out.println("【Tag.findAll error】\n"+e.getMessage());        
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
        session.close();
    }
    return list;
  }
  
  /**
   * 部分查询，返回查询条数，可用于分页浏览
   */
  public QueryResult findAll(String name,int firstResult, int maxResults) {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();

        List<Tag> list = session.createQuery(//
                "FROM "+name+"")//
                .setFirstResult(firstResult)//
                .setMaxResults(maxResults)//
                .list();

        // 查询总记录数
        Long count = (Long) session.createQuery(//
                "SELECT COUNT(*) FROM "+name)//
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
   * 部分查询，按列值查询
   */
  public List find(String name,String propertyName, Object value)  {
    log.debug("finding "+name+" by Property");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Tag> list=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        
        Criteria criteria = session.createCriteria(Class.forName(name)); 
        criteria.add(Expression.eq(propertyName,value)); 
        list = criteria.list(); // 要先获取到这个对象
        
        tx.commit();
        log.debug("find by example successful, result size: "
            + list.size());
        return list;
    } catch (RuntimeException re) {
        log.error("find by example failed", re);
        return new ArrayList();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return new ArrayList();
    }finally{
      session.clear();
    }
  }
  
  /**
   * 部分查询，按列值查询
   */
  public List find(String table,String column1, Object value1,String column2, Object value2)  {
    log.debug("finding "+table+" by Property");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<Tag> list=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        
        Criteria criteria = session.createCriteria(Class.forName(table)); 
        criteria.add(Expression.eq(column1,value1)); 
        criteria.add(Expression.eq(column2,value2)); 
        list = criteria.list(); // 要先获取到这个对象
        
        tx.commit();
        log.debug("find by example successful, result size: "
            + list.size());
        return list;
    } catch (RuntimeException re) {
        log.error("find by example failed", re);
        return new ArrayList();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return new ArrayList();
    }finally{
      session.clear();
    }
  }

  public List findByKey(String table,String column,String key) {
    
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List list=null;
    try {
        tx = session.beginTransaction(); // 开始事务
        
            
            Criteria criteria = session.createCriteria(Class.forName(table)); 
            criteria.add(Expression.like(column,"%"+key+"%")); 
          
            list=criteria.list();
            
            tx.commit(); // 提交事务
        log.debug("find by example successful, result size: "
            + list.size());
        return list;
        
    } catch (RuntimeException re) {
        log.error("find by example failed", re);
        return new ArrayList();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return new ArrayList();
    }finally{
      session.clear();
    }
  }

  public List findByHql(String hql) {
    log.debug("***************根据sql查找："+hql+"********************");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();

        List list = session.createQuery(hql).list();

        tx.commit();
      
    log.debug("***************根据sql查找返回记录数："+list.size()+"********************");  
        
        return list;
        //  返回结果
    } catch (RuntimeException e) {
        tx.rollback();
       return null;
    } finally {
        session.close();
    }
  }
  
  public List findBySql(String sql) {
    log.debug("***************根据sql查找："+sql+"********************");
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();

        List list = session.createSQLQuery(sql).list();

        tx.commit();
      
    log.debug("***************根据sql查找返回记录数："+list.size()+"********************");  
        
        return list;
        //  返回结果
    } catch (RuntimeException e) {
        tx.rollback();
       return new ArrayList();
    } finally {
        session.close();
    }
  }
  
}
