package com.imooc.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private List<File> upload;//和表单的属性名一致
	
	private List<String> uploadContentType;

	private List<String> uploadFileName;

	private String result;

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("upload:"+upload.get(0));
		System.out.println("uploadContentType:"+uploadContentType.get(0));
		System.out.println("uploadFileName:"+uploadFileName.get(0));
		
		
		String path = ServletActionContext.getServletContext().getRealPath(
				"/images");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

		// 循环将批量上传的文件保存到本地
		for(int i = 0; i < upload.size(); i++) {
			FileUtils.copyFile(upload.get(i),
					new File(file, uploadFileName.get(i)));
		}
		result = "上传成功！";
		return SUCCESS;
	}
}
