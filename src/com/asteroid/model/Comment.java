/**
 * 文件创建时间：2014年6月5日
 */
package com.asteroid.model;

import java.sql.Timestamp;

/**
 * @author 吴泽标
 *
 */
public class Comment {

  private int comment_id;
  private int user_id;
  private int release_id;
  private int to_userid;
  private String content;
  private Timestamp c_date;
  
  
  public Comment(){}
  public  Comment(int user_id,int release_id,int to_userid,String content){
    this.user_id=user_id;
    this.release_id=release_id;
    this.to_userid=to_userid;
    this.content=content;
    
  }
  
  public String toString(){
    return "{comment_id:"+comment_id+",user_id:"+user_id+",to_userid:"+to_userid+",content:"+content+",c_date:"+c_date+"}";
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

}
