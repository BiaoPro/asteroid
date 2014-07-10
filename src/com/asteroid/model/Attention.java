/**
 * 文件创建时间：2014年6月1日
 */
package com.asteroid.model;

import java.sql.Timestamp;
import java.util.Date;

/**关注表
 * @author 吴泽标
 *
 */
public class Attention {
      private int a_id;
      private int user_id;
      private int a_userid;
      private Timestamp a_date;
      
      public Attention(){}
      public Attention(int user_id,int a_userid){
        this.user_id=user_id;
        this.a_userid=a_userid;
      }
      
      public String toString() {
        return "[ a_id:"+ a_id+",user_id:"+user_id+",a_userid:"+a_userid+",a_date;"+a_date+"]";
      }
      public int getA_id() {
        return a_id;
      }
      public void setA_id(int a_id) {
        this.a_id = a_id;
      }
      public int getUser_id() {
        return user_id;
      }
      public void setUser_id(int user_id) {
        this.user_id = user_id;
      }
      public int getA_userid() {
        return a_userid;
      }
      public void setA_userid(int a_userid) {
        this.a_userid = a_userid;
      }
      public Timestamp getA_date() {
        return a_date;
      }
      public void setA_date(Timestamp a_date) {
        this.a_date = a_date;
      }
      
   
}
