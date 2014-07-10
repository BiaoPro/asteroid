/**
 * 文件创建时间：2014年6月3日
 */
package com.asteroid.controller.tagAdd;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.asteroid.controller.DatabaseDao;
import com.asteroid.model.Tag;
import com.asteroid.model.TagAdd;
import com.asteroid.model.User;
import com.asteroid.util.HibernateUtils;
import com.asteroid.util.QueryResult;

/**
 * @author 吴泽标
 *
 */
public class TagAddDao extends DatabaseDao {
  
  /**
   * 添加标签
   */
  public boolean save(TagAdd tagAdd) {
    Session session = HibernateUtils.openSession();
    try {
        Transaction tx = session.beginTransaction(); // 开始事务
        session.save(tagAdd);
        tx.commit(); // 提交事务
        return true;
    } catch (RuntimeException e) {
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【TagAdd.save error:】\n"+e.getMessage());          
        return false;
    } finally {
        session.close(); // 关闭Session
    }
  }


  /**
   * 删除tag_add
   */
  public boolean delete(int user_id,int tag_id) {
    Session session = HibernateUtils.openSession();
    try {
        Transaction tx = session.beginTransaction(); // 开始事务
        Criteria criteria = session.createCriteria(TagAdd.class); 
        criteria.add(Expression.eq("user_id",new Integer(user_id))); 
        criteria.add(Expression.eq("tag_id",new Integer(tag_id))); 
        List<TagAdd> list=criteria.list();
        for(TagAdd tagAdd:list) session.delete(tagAdd);
        tx.commit(); // 提交事务
        return true;
    } catch (RuntimeException e) {
        session.getTransaction().rollback(); // 回滚事务
        System.out.println("【TagAdd.delete error:"+user_id+"】\n"+e.getMessage());          
        return false;
    } finally {
        session.close(); // 关闭Session
    }
  }
  /**
   * 按个人id查找添加的标签
   */
  public List<TagAdd> findAllById(int user_id) {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<TagAdd> list=null;
    try {
        tx = session.beginTransaction();
        list = session.createQuery(//
            "FROM TagAdd where user_id="+user_id+"")//
            .list();
        tx.commit();
        
    } catch (RuntimeException e) {
        tx.rollback();
        System.out.println("【TagAdd.findAllById error】\n"+e.getMessage());        
    } finally {
        session.close();
    }
    return list;
  }

  /**
   * 返回所有添加的标签数据
   */
  public List<TagAdd> findAll() {
    Session session = HibernateUtils.openSession();
    List<TagAdd> list=null;
    Transaction tx = null;
    try {
        tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(TagAdd.class);
        list = criteria.list();
        
        tx.commit();
        
    } catch (RuntimeException e) {
        tx.rollback();
        System.out.println("【TagAdd.findAll error】\n"+e.getMessage());        
    } finally {
        session.close();
    }
    return list;
  }
  /**
   * 返回所有添加的标签数据
   */
  public QueryResult  findAll(int first, int n) {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    List<TagAdd> list=null;
    try {
        tx = session.beginTransaction();

        list = session.createQuery(//
                "FROM TagAdd")//
                .setFirstResult(first)//
                .setMaxResults(n)//
                .list();

        // 查询总记录数
        Long count = (Long) session.createQuery(//
                "SELECT COUNT(*) FROM TagAdd")//
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




