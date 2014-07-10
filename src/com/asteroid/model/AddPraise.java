/**
 * 文件创建时间：2014年6月5日
 */
package com.asteroid.model;

import java.sql.Timestamp;

/**
 * @author 吴泽标
 *
 */
public class AddPraise {
  
  private int praise_id;
  private int user_id;
  private int release_id;
  private Timestamp p_date;
  
  public AddPraise(){}
  public AddPraise(int user_id,int release_id){
    this.user_id=user_id;
    this.release_id=release_id;
  }
  public AddPraise(int praise_id,int user_id,int release_id){
    this.praise_id=praise_id;
    this.user_id=user_id;
    this.release_id=release_id;
  }
  
  public String toString(){
    return "{praise_id:"+praise_id+",user_id:"+user_id+",release_id:"+release_id+",p_date:"+p_date+"}";
  }
  public int getPraise_id() {
    return praise_id;
  }
  public void setPraise_id(int praise_id) {
    this.praise_id = praise_id;
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
  public Timestamp getP_date() {
    return p_date;
  }
  public void setP_date(Timestamp p_date) {
    this.p_date = p_date;
  }
  
  

}
