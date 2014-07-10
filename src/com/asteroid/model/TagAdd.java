/**
 *
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 吴泽标
 *
 */
public class TagAdd {

  private int tag_add_id;//删除
  private int user_id;
  private int tag_id;
  private Timestamp a_date;
  
  public TagAdd(){}
  public TagAdd(int user_id,int tag_id){
    this.user_id=user_id;
    this.tag_id=tag_id;
  }
  
  public String toString() {
    return "[tag_add_id"+tag_add_id+",add_user_id:"+user_id+",add_tag_id;"+tag_id+",add_date:"+a_date+"]";
  }
 
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public int getTag_id() {
    return tag_id;
  }
  public void setTag_id(int tag_id) {
    this.tag_id = tag_id;
  }
  public Timestamp getA_date() {
    return a_date;
  }
  public void setA_date(Timestamp a_date) {
    this.a_date = a_date;
  }
  public int getTag_add_id() {
    return tag_add_id;
  }
  public void setTag_add_id(int tag_add_id) {
    this.tag_add_id = tag_add_id;
  }
  
 
}
