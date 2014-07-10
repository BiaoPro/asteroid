/**
 * Copyright (c) 广州顶九信息技术有限公司2014 版权
 *
 * 文件创建时间：2014年6月5日
 */
package com.asteroid.controller.comment;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.asteroid.controller.DatabaseDao;
import com.asteroid.controller.daoVO.CommentVO;
import com.asteroid.model.Comment;
import com.asteroid.model.Tag;
import com.asteroid.util.HibernateUtils;

/**
 * @author 吴泽标
 *
 */
public class CommentDao extends DatabaseDao {
  
  private static final Log log = LogFactory.getLog(CommentDao.class);
  
  private static final String CLASS="com.asteroid.model.Comment";
  
  /**
   * 添加评论
   */
    public boolean save(Comment vo) {return super.save(vo);}
    /**
     * 修改评论
     */
    public boolean update(Comment vo) {return super.update(vo);}
    /**
     * 获得评论
     */
    public Comment findById(int release_id) {return (Comment)(super.findById(CLASS,release_id));}
  /**
   * 删除评论by ID
   */
  public boolean delete(int id) {return super.delete(CLASS,id); // 删除的是实体对象
  }
  
  /**
   * 获取评论
   */
  public List<Comment> findAll() {
    return super.findAll(CLASS);
  }
  
  
   public List<Comment> find(String propertyName, Object value) {
      return super.find(CLASS, propertyName, value);
      
   }
   
   public List<Comment> findByReleaseId(int release_id){return find("release_id",release_id);}
  
    
}
