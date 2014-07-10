/**
 * 文件创建时间：2014年6月22日
 */
package com.asteroid.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.asteroid.controller.daoVO.ReleaseVO;
import com.asteroid.model.User;
import com.asteroid.service.ReleaseService;
import com.asteroid.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class SearchAction extends ActionSupport {
  
  private String key;
  private List<ReleaseVO> releaseList;//返回的发布列表
  
  
  private List<User> userList;
  
  private UserService userService=new UserService();
  private ReleaseService service=new ReleaseService();
  
  public String search(){
    setReleaseList(service.getReleaseListByKey(this.getKey()));
    
    HttpSession session = ServletActionContext.getRequest().getSession();
    session.setAttribute("ReleaseList", getReleaseList());
    
    if(getReleaseList()==null){
      addActionError("没有记录");
      return ERROR;
    }else
      return SUCCESS;
    
  }
  
  public String searchRelease(){
    setReleaseList(service.getReleaseListByKey(this.getKey()));
    
    HttpSession session = ServletActionContext.getRequest().getSession();
    session.setAttribute("ReleaseList", getReleaseList());
    
    if(getReleaseList()==null){
      addActionError("没有记录");
      return ERROR;
    }else
      return SUCCESS;
    
  }
  
  public String searchAttention(){
    
    setUserList(userService.getUserListByKey(this.getKey()));
    
    HttpSession session = ServletActionContext.getRequest().getSession();
    session.setAttribute("userList", getUserList());
    
    if(getReleaseList()==null){
      addActionError("没有记录");
      return ERROR;
    }else
      return SUCCESS;
    
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public List<ReleaseVO> getReleaseList() {
    return releaseList;
  }

  public void setReleaseList(List<ReleaseVO> releaseList) {
    this.releaseList = releaseList;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

}
