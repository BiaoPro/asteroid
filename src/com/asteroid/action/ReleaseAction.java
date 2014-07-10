package com.asteroid.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.asteroid.controller.daoVO.ReleaseVO;
import com.asteroid.controller.release.UserReleaseDao;
import com.asteroid.model.UserRelease;
import com.asteroid.service.ReleaseService;
import com.asteroid.util.SessionManage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReleaseAction extends ActionSupport {
  
    private static final Log log=LogFactory.getLog(ReleaseAction.class);
    
    
    
    
    private Integer tag_id;//要查看的标签
    private Integer user_id;//要查看的用户id
    private Integer user_add_id;//查看用户id关注的人
    private Integer user_love_id;//返回用户点赞内容的用户id
    private Integer release_id;//查看发布内容
    private List<ReleaseVO> releaseList;//返回的发布列表
    private ReleaseService service=new ReleaseService();
    
    private String title;
    private String content;
    private String image;
    
    UserReleaseDao dao=new UserReleaseDao();
    
    
    public String execute(){
      if(user_id!=null){
        setReleaseList(service.getReleaseListByUserId(user_id));
      }
      else if(tag_id !=null){
        setReleaseList(service.getReleaseListByTagId(tag_id));
      }
      else if(user_add_id !=null){
        setReleaseList(service.getReleaseListByAddUserIdKey(user_add_id));
      }
      else if(getUser_love_id()!=null){
        setReleaseList(service.getReleaseListByLoveUserId(getUser_love_id()));
      }
      else {return ERROR;}
      
      HttpSession session = ServletActionContext.getRequest().getSession();
      session.setAttribute("ReleaseList", getReleaseList());
      
      return SUCCESS;
    }
    
    public String addRelease() throws Exception{
      UserRelease vo=new UserRelease(getUser_id(),  
          getTag_id() ,
          getTitle(), 
          getContent(),
          getImage());
      boolean on=dao.save(vo);
      execute();
      if (on)
        return SUCCESS;
      else
        return ERROR;
    }
    
    
    
    private File image2; //上传的文件
    private String imageFileName; //文件名称
    private String imageContentType; //文件类型
    
    
    
    public String addRelease2() throws Exception{
      
      
      String realpath = ServletActionContext.getServletContext().getRealPath("/Asteroid/images/temp");
      String filename=null;
      //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
      System.out.println("realpath: "+realpath);
      
      //imageFileName=imageFileName.substring(imageFileName.lastIndexOf("."));
      if (image2 != null) {
        
        imageFileName = image2.getName();
        String fileType = imageFileName.substring(imageFileName.lastIndexOf("."));
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        filename=format.format(new Date())+""+fileType;
          File savefile = new File(new File(realpath), filename);
          if (!savefile.getParentFile().exists())
              savefile.getParentFile().mkdirs();
          try {
            FileUtils.copyFile(image2, savefile);
          } catch (IOException e) {
            
            e.printStackTrace();
            return "error";
            
          }
          ActionContext.getContext().put("message", "文件上传成功");
      }
      if(filename!=null)
      this.image="images/temp/"+filename;
      // this.image="images/"+imageFileName;
      
      UserReleaseDao dao=new UserReleaseDao();
      UserRelease vo=new UserRelease(getUser_id(),  
          getTag_id() ,
          getTitle(), 
          getContent(),
          getImage());
      boolean on=dao.save(vo);
      execute();
      if (on)
        return SUCCESS;
      else
        return ERROR;
    }
    
    
    
    public String delRelease(){
      boolean on= dao.delete(getRelease_id());
      System.out.println("delete release: "+on);
      this.setUser_id(SessionManage.getUserid());
      execute();
      if (on)
        return SUCCESS;
      else
        return ERROR;
    }
    
    
    private File upload;
    private String fileName;
    private String uploadContentType;
    
   
    
    
    public File getUpload() {
      return upload;
    }
    public void setUpload(File upload) {
      this.upload = upload;
    }
    public String getFileName() {
      return fileName;
    }
    public void setFileName(String fileName) {
      this.fileName = fileName;
    }
    public String getUploadContentType() {
      return uploadContentType;
    }
    public void setUploadContentType(String uploadContentType) {
      this.uploadContentType = uploadContentType;
    }

    public List<ReleaseVO> getReleaseList() {
      return releaseList;
    }


    public void setReleaseList(List<ReleaseVO> releaseList) {
      this.releaseList = releaseList;
    }
    
    public Integer getTag_id() {
      return tag_id;
    }

    public void setTag_id(Integer tag_id) {
      this.tag_id = tag_id;
    }

    public Integer getUser_id() {
      return user_id;
    }

    public void setUser_id(Integer user_id) {
      this.user_id = user_id;
    }

    public Integer getUser_add_id() {
      return user_add_id;
    }

    public void setUser_add_id(Integer user_add_id) {
      this.user_add_id = user_add_id;
    }

    public Integer getRelease_id() {
      return release_id;
    }

    public void setRelease_id(Integer release_id) {
      this.release_id = release_id;
    }

    public ReleaseService getService() {
      return service;
    }

    public void setService(ReleaseService service) {
      this.service = service;
    }

    public static Log getLog() {
      return log;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public File getImage2() {
      return image2;
    }

    public void setImage2(File image2) {
      this.image2 = image2;
    }

    public String getImageFileName() {
      return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
      this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
      return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
      this.imageContentType = imageContentType;
    }

    public Integer getUser_love_id() {
      return user_love_id;
    }

    public void setUser_love_id(Integer user_love_id) {
      this.user_love_id = user_love_id;
    }


    
    
}
