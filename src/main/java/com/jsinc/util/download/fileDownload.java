package com.jsinc.util.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;
@Component
public class fileDownload extends AbstractView{

	public fileDownload() {
		setContentType("application/download; charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		File file = (File) model.get("downloadFile");
		
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		String header = request.getHeader("User-Agent");
		boolean b = header.indexOf("MSIE") > -1;
		String fileName = null;
		
		
			File file2 = (File) model.get("realFileName");
			try {
			fileName = URLEncoder.encode(file2.getName(),"UTF-8").replaceAll("\\+", "%20");
			}catch (Exception e) {
				fileName = URLEncoder.encode(file.getName(),"UTF-8").replaceAll("\\+", "%20");
			}
		if(!b) {
			fileName = new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
		}
		response.setHeader("content-Disposition", "attachment; filename=\""+file2+"\";");
		response.setHeader("content-Transter-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null)
				try {
					fis.close();
				}catch (IOException ioe) {
					ioe.printStackTrace();
				}
		}
		out.flush();
	}
}
