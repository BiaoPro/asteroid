/**
 * 文件创建时间：2014年6月5日
 */
package com.asteroid.model;

import java.sql.Timestamp;

/**
 * @author 吴泽标
 *
 */
public class PrivateLetter {

  private int letter_id;
  private int user_id;
  private int to_userid;
  private String content;
  private Timestamp s_date;
  
  public PrivateLetter() {}
  public PrivateLetter(int user_id,int to_userid,String content) {
    
    this.user_id=user_id;
    this.to_userid=to_userid;
    this.content=content;
    
  }
  public PrivateLetter(int letter_id,int user_id,int to_userid,String content) {
    
    this.letter_id=letter_id;
    this.user_id=user_id;
    this.to_userid=to_userid;
    this.content=content;
    
  }
  

  
  public String toString(){
    return "{letter_id:"+letter_id+",user_id:"+user_id+",to_userid:"+to_userid+",content:"+content+",s_date:"+s_date+"}";
  }
  
  public int getLetter_id() {
    return letter_id;
  }
  public void setLetter_id(int letter_id) {
    this.letter_id = letter_id;
  }
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
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
  public Timestamp getS_date() {
    return s_date;
  }
  public void setS_date(Timestamp s_date) {
    this.s_date = s_date;
  }
  
}
