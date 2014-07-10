/**
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.controller.release;

import java.util.List;

import com.asteroid.controller.DatabaseDao;
import com.asteroid.model.UserRelease;
import com.asteroid.util.QueryResult;


/**
 * @author 吴泽标
 *
 */
public class UserReleaseDao extends DatabaseDao {
  
  
 private static final String CLASS="com.asteroid.model.UserRelease";
  
  /**
   * 添加用户
   */
  public boolean save(UserRelease vo){return super.save(vo);}
    /**
   * 修改个人信息
   */
  public  boolean update(UserRelease vo){return super.update(vo);}
  
  /**
   * 根据发布id删除发布
   */
  public  boolean delete(int id){return super.delete(CLASS,id);}
  /**
   * 根据发布id返回发布内容
   */
  public  UserRelease findById(int id){return (UserRelease)(super.findById(CLASS,id));}
  
  /**
   * 根据用户id返回发布列表
   */
  public  List<UserRelease> findByUserId(int id){return (List<UserRelease>) (super.find(CLASS,"user_id",id));}
  
  /**
   * 根据标签id返回发布列表
   */
  public  List<UserRelease> findByTagId(int id){return (List<UserRelease>)(super.find(CLASS,"tag_id",id));}

  /**
   * 返回所有发布
   */
  public List<UserRelease> findAll(){return super.findAll(CLASS);}
  /**
   * 返回所有用户
   */
  public QueryResult findAll(int firstResult, int maxResults){return super.findAll(CLASS,firstResult,maxResults);}
  
  public List<UserRelease> findByTitle(String key) {return (List<UserRelease>)(super.findByKey(CLASS,"title",key));}

  public List<UserRelease> findByContent(String key) {return (List<UserRelease>)(super.findByKey(CLASS,"content",key));}

  
  public List<UserRelease> findByHql(String key) {
    
    String sql="From UserRelease as u where u.content like '%"+key.trim()+"%' or u.title like  '%"+key.trim()+"%' ";
    
    return (List<UserRelease>)(super.findByHql(sql));
    
  
  
  }
  public List<UserRelease> findByUserIdKey(Integer user_id) {
    
    
    String sql="SELECT U.release_id,U.user_id,U.tag_id,U.title,U.content,U.image,U.music,U.video From user_release as U left join attention as A on U.user_id = A.a_userid " +
    		   " where A.user_id = "+user_id+"";
    String sqls="Select U From UserRelease U where U.user_id in " +
    		"(Select A.a_userid From Attention A where A.user_id="+user_id+") or U.user_id="+user_id+"" ;
       
  
    
    return (List<UserRelease>)(super.findByHql(sqls));
    
  }
  
  
  
  
}
