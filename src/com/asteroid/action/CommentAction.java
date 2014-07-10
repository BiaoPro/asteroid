/**
 * 文件创建时间：2014年6月20日
 */
package com.asteroid.action;

import java.sql.Timestamp;

import com.asteroid.controller.comment.CommentDao;
import com.asteroid.model.Comment;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class CommentAction  extends ActionSupport  {
  
  private int user_id;
  private int release_id;
  private int to_userid;
  private String content;
  
  public String execute(){
    
    CommentDao dao=new CommentDao();
    Comment vo=new Comment(getUser_id(),getRelease_id(),0, getContent());
    dao.save(vo);    
    ReleaseAction action=new ReleaseAction();
    action.setUser_id(getUser_id());
    action.execute();
    return SUCCESS;
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
  

}
