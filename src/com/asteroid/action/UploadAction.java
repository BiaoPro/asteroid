/**
 * 文件创建时间：2014年6月19日
 */
package com.asteroid.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 吴泽标
 *
 */
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport{
    
    private File image; //上传的文件
    private String imageFileName; //文件名称
    private String imageContentType; //文件类型
    private String realpath;

    public String execute()  {
        
        realpath = ServletActionContext.getServletContext().getRealPath("/Asteroid/images");
        //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
        System.out.println("realpath: "+realpath);
        if (image != null) {
            File savefile = new File(new File(realpath), imageFileName);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            try {
              FileUtils.copyFile(image, savefile);
            } catch (IOException e) {
              
              e.printStackTrace();
              return "error";
              
            }
            ActionContext.getContext().put("message", "文件上传成功");
        }
        return "success";
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
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

    public String getRealpath() {
      return realpath;
    }

    public void setRealpath(String realpath) {
      this.realpath = realpath;
    }

    
}