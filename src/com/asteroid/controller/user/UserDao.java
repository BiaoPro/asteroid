/**
 * Copyright (c) 广州顶九信息技术有限公司2014 版权
 *
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.controller.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asteroid.util.HibernateUtils;
import com.asteroid.util.QueryResult;
import com.asteroid.controller.DatabaseDao;
import com.asteroid.model.User;
import com.asteroid.model.UserInfo;

/**
 * @author 吴泽标
 *
 */
public class  UserDao extends DatabaseDao {

  private static final String CLASS="com.asteroid.model.User";
  /**
   * 添加用户
   */
  public boolean save(User user){return super.save(user);}
    /**
   * 修改个人信息
   */
  public  boolean update(User user){
    User vo=new User();
    
    vo=findById(user.getUser_id());
    
    if(user.getImage()!=null) vo.setImage(user.getImage());
    if(user.getName()!=null) vo.setName(user.getName());
    if(user.getPassword()!=null) vo.setPassword(user.getPassword());
    
    return super.update(vo);}
  
  /**
   * 根据用户id删除用户
   */
  public  boolean delete(int user_id){return super.delete(CLASS,user_id);}
  
  /**
   * 修改密码
   */
  public boolean updatePassword(String newPassword, int userId) {
    Session session = HibernateUtils.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();
        User user = (User) session.get(User.class, userId); // 操作
        user.setPassword(newPassword);
        session.update(user);
        tx.commit();
        return true;
    } catch (RuntimeException e) {
        tx.rollback();
        System.out.println("【User.updatePassword error】\n"+e.getMessage());        
        return false;
    } finally {
        session.close();
    }
  }

  /**
   * 查找个人信息
   */
  public  User findById(int id){
    
    List<User> list=super.find(CLASS,"user_id",id);
    if(list.get(0)==null) return null;
    else return (User)(super.find(CLASS,"user_id",id).get(0));}
  
  /**
   * 查找关注人列表
   */
  public  List<User> findByUserId(int id){return (List<User>)(super.find(CLASS,"user_id",id).get(0));}


  /**
   * 根据用户和密码验证用户
   */
  public int check(String username, String password) {
    
    List<User> list=super.find(CLASS, "username", username,"password",password);
    
    return list.size()> 0 ? list.get(0).getUser_id():0;
  }
  
  /**
   * 根据用户名验证用户是否存在
   */
  public boolean check(String username) {
    
    List list=super.find(CLASS, "username", username);
    
    return (list.size())> 0 ? true:false;
  }
  
  /**
   * 返回所有用户
   */
  public List<User> findAll(){return super.findAll(CLASS);}
  
  /**
   * 返回所有用户
   */
  public QueryResult findAll(int firstResult, int maxResults){return super.findAll(CLASS,firstResult,maxResults);}
  
  
  public List<User> findByKey(String key) {
    
    String sql ="From User as u where u.username like '%"+key.trim()+"%' or name like '%"+key.trim()+"%'";
    
    return (List<User>)super.findByHql(sql);
  }

  
}
