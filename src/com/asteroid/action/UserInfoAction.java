/**
 * 文件创建时间：2014年6月20日
 */
package com.asteroid.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.asteroid.controller.user.UserDao;
import com.asteroid.model.User;
import com.asteroid.service.UserService;
import com.asteroid.util.SessionManage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
public class UserInfoAction extends ActionSupport {
  
  
  private int user_id;
  private File image3;
  private String image;
  private String name3;
  private String goToUrl;
  private String username;
  private String password;
  private String pwd1;
  private String pwd2;
  
  private UserDao dao=new UserDao();
  private UserService service=new UserService();
  
  public String execute(){
    
    String realpath = ServletActionContext.getServletContext().getRealPath("/Asteroid/images/user/"+getUser_id()+"/");
    String filename=null;
    //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
    System.out.println("realpath: "+realpath);
    
    //imageFileName=imageFileName.substring(imageFileName.lastIndexOf("."));
    if (image3 != null) {
      
      String imageFileName = image3.getName();
      String fileType = imageFileName.substring(imageFileName.lastIndexOf("."));
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
      filename=format.format(new Date())+""+fileType;
        File savefile = new File(new File(realpath), filename);
        if (!savefile.getParentFile().exists())
            savefile.getParentFile().mkdirs();
        try {
          FileUtils.copyFile(image3, savefile);
        } catch (IOException e) {
          
          e.printStackTrace();
          return ERROR;
          
        }
        ActionContext.getContext().put("message", "文件上传成功");
    }
    if(filename!=null)
    this.setImage("images/user/"+getUser_id()+"/"+filename);
    
    
   
    User vo=new User();
    vo.setUser_id(getUser_id());
    vo.setName(getName3());
    vo.setImage(getImage());
    dao.update(vo);
    
    HttpSession session = ServletActionContext.getRequest().getSession();
    session.setAttribute("user", dao.findById(getUser_id()));
    
    ReleaseAction action=new ReleaseAction();
    action.setUser_id(getUser_id());
    action.execute();
    
    if(getGoToUrl()!=null&&getGoToUrl().equals("account")){
      addActionError("保存成功~");
      return "account";
    }
    return SUCCESS;
  }
  
  public String changePassword(){
    if(getPassword()==null||getPwd1()==null||getPwd2()==null||getPassword().equals("")||getPwd1().equals("")||getPwd2().equals("")) {addActionError("密码有空！");return ERROR;}
    
    if(!getPwd1().equals(getPwd2())){
      addActionError("新密码输入不一致哦~");
      return ERROR;
    }
    
    service = new UserService();
    int num=service.authenticate(username, password);
    if (num > 0){
      if(service.changePassword(getPwd1(), getUser_id())){
        addActionError("修改成功~");
        return SUCCESS;
      }else{
        addActionError("修改失败~");
        return ERROR;
      }
     
    }else{
      if(num==-4){ addActionError("输入的密码有错误哦~");}
    
    }
    
    return ERROR;
  }
  
  public String delUser(){
    
    if(getPassword()==null||getPassword().equals("")){
      addActionError("没有输入密码哦~");
      return ERROR;
    }
    System.out.println("***************************"+(getUsername()==null)+":"+(getPassword()==null));
     int num=service.authenticate(getUsername(), 
         getPassword());
     if(num>0){
     dao.delete(getUser_id());
     addActionError("帐号注销成功,谢谢您的使用~");
     SessionManage.getSession().setAttribute("user", null);
     return SUCCESS;
    }else{
      addActionError("帐号注销失败哦~");
      return ERROR;
    }
    
    
  }
  
  
  public File getImage3() {
    return image3;
  }
  public void setImage3(File image3) {
    this.image3 = image3;
  }
  public String getName3() {
    return name3;
  }
  public void setName3(String name3) {
    this.name3 = name3;
  }


  public int getUser_id() {
    return user_id;
  }


  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }


  public String getImage() {
    return image;
  }


  public void setImage(String image) {
    this.image = image;
  }


  public String getGoToUrl() {
    return goToUrl;
  }


  public void setGoToUrl(String goToUrl) {
    this.goToUrl = goToUrl;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPwd2() {
    return pwd2;
  }

  public void setPwd2(String pwd2) {
    this.pwd2 = pwd2;
  }

  public String getPwd1() {
    return pwd1;
  }

  public void setPwd1(String pwd1) {
    this.pwd1 = pwd1;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  

}
