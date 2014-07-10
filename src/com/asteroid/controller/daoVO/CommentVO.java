/**
 * 文件创建时间：2014年6月19日
 */
package com.asteroid.controller.daoVO;

import java.sql.Timestamp;

import com.asteroid.controller.user.UserDao;
import com.asteroid.model.Comment;
import com.asteroid.model.User;

/**
 * @author 吴泽标
 *
 */
public class CommentVO {
  
  private int comment_id;
  private int user_id;
  private int release_id;
  private int to_userid;
  private String content;
  private Timestamp c_date;
  private User user;
  
  public CommentVO(){}
  public CommentVO(Comment comment){
    this.comment_id=comment.getComment_id();
    this.user_id=comment.getUser_id();
    this.release_id=comment.getRelease_id();
    this.to_userid=comment.getTo_userid();
    this.content=comment.getContent();
    this.c_date=comment.getC_date();
    
    UserDao dao=new UserDao();
    this.user = dao.findById(this.getUser_id());
    
  }
  
  
  
  public int getComment_id() {
    return comment_id;
  }
  public void setComment_id(int comment_id) {
    this.comment_id = comment_id;
  }
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public int getRelease_id() {
    return release_id;
  }
  public void setRelease_id(int release_id) {
    this.release_id = release_id;
  }
  public int getTo_userid() {
    return to_userid;
  }
  public void setTo_userid(int to_userid) {
    this.to_userid = to_userid;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Timestamp getC_date() {
    return c_date;
  }
  public void setC_date(Timestamp c_date) {
    this.c_date = c_date;
  }
  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }

}
