/**
 * 文件创建时间：2014年6月6日
 */
package com.asteroid.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.asteroid.controller.daoVO.ReleaseVO;
import com.asteroid.controller.daoVO.UserVO;
import com.asteroid.model.User;
import com.asteroid.service.ReleaseService;
import com.asteroid.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class LoginAction extends ActionSupport {
     private String username;//接收表单的用户名
     private String password;//接收表单的密码
     private int resultNum;//返回登录的值:1登录成功、-2用户不存在、-4密码错误
     private User user;
     private UserVO userVO;
     private UserService service;
     
      public String execute(){
        
        if(username==null||password==null){addActionError("帐号密码为空！");return ERROR;}
        
            service = new UserService();
            this.setResultNum(service.authenticate(username, password));
            if (getResultNum() > 0){
              setUser(service.getUserInfo());
              
              HttpSession session = ServletActionContext.getRequest().getSession();
              session.setAttribute("user", getUser());
              userVO=new UserVO();
              session.setAttribute("userVO", userVO);
              ReleaseService service=new ReleaseService();
              List<ReleaseVO> list=service.getReleaseListByAddUserIdKey(this.user.getUser_id());
              session.setAttribute("ReleaseList", list);
              
              
              List<User> userList=service.getAttentionUserList(getUser().getUser_id());
              session.setAttribute("userList", userList);
              
              return SUCCESS;
              }
            else{
              if(getResultNum()==-2){ addActionError("用户不存在，注册一个吧");}
              else if(getResultNum()==-4){ addActionError("输入的密码有误");}
              else{ addActionError("登录失败！");}
              return ERROR;
              }
            

       }
       public String getUsername() {
           return username;
       }
       public void setUsername(String username) {
           this.username = username;
       }
       public String getPassword() {
           return password;
       }
       public void setPassword(String password) {
           this.password = password;
       }
      public int getResultNum() {
        return resultNum;
      }
      public void setResultNum(int resultNum) {
        this.resultNum = resultNum;
      }
  
      public User getUser() {
        return user;
      }
      public void setUser(User user) {
        this.user = user;
      }
      
}
