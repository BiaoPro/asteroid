/**
 * 文件创建时间：2014年6月11日
 */
package com.asteroid.action;

import com.asteroid.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class RegisterAction extends ActionSupport {
  
  private String name;
  private String username;//接收表单的用户名
  private String pwd1;//接收表单的密码
  private String pwd2;//接收表单的密码
  private int resultNum;//返回登录的值:1注册成功、-3用户已注册、 -4密码不一致
  private UserService service;
  

   public String execute(){
      
     if(username==null||getPwd1()==null||username.equals("")||getPwd1().equals("")) {addActionError("帐号密码为空！");return ERROR;}
     
         service = new UserService();
         this.setResultNum(service.register(name,username, getPwd1(),getPwd2()));
         if (getResultNum() > 0){
           addActionError("注册成功！");
           return SUCCESS;
           }
         else{
           if(getResultNum()==-3){ addActionError("用户已被注册");}
           else if(getResultNum()==-4){ addActionError("输入的密码不一致");}
           else addActionError("注册失败！");
           return ERROR;
           }
         

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
  
   public int getResultNum() {
     return resultNum;
   }
   public void setResultNum(int resultNum) {
     this.resultNum = resultNum;
   }
  public String getPwd1() {
    return pwd1;
  }
  public void setPwd1(String pwd1) {
    this.pwd1 = pwd1;
  }
  public String getPwd2() {
    return pwd2;
  }
  public void setPwd2(String pwd2) {
    this.pwd2 = pwd2;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


}
