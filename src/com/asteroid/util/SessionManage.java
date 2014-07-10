/**
 * 文件创建时间：2014年6月21日
 */
package com.asteroid.util;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.asteroid.model.User;

/**
 * @author 吴泽标
 *
 */
public class SessionManage {
  
  public static HttpSession session;
  
  static {
    try {
      session = ServletActionContext.getRequest().getSession();
    } catch (Exception e) {
        System.err.println("%%%% Error Creating Session %%%%");
        e.printStackTrace();
    }
 }
  
  public static HttpSession getSession(){
    return  ServletActionContext.getRequest().getSession();
  }
  
  public void SessionManage(){
    session = ServletActionContext.getRequest().getSession();
  }
   
  public static User getUser(){
    return (User)session.getAttribute("user");
  }
  
  public static int getUserid(){
    return getUser().getUser_id();
  }
  
  
  public static String getName(){
    return getUser().getName();
  }

}
