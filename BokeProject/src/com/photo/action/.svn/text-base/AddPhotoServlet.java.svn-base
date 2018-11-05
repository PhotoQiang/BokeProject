package com.photo.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.photo.dao.PhotoDao;
import com.photo.pojo.Photo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPhotoServlet extends HttpServlet {
	PhotoDao dao = new PhotoDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 System.out.println("----------------AddPhotoServlet.doGet()----------------------");
		// String url=request.getParameter("url");
		// System.out.println("-------------------"+url+"--------------------");
		// copyFile(url);
		// //将url转变为文件名
		// int index=url.lastIndexOf("\\");
		// url=url.substring((index+1), url.length());
		//
//		 int loginUserId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
		// Photo photo=new Photo(loginUserId,url);
		// dao.addPhoto(photo);
		// List<Photo> photos=dao.selectByUser(loginUserId);
		// request.getSession().setAttribute("photos",photos);
		// response.sendRedirect("photo/photo.jsp");
		
		

		System.out.println("----------------AddPhotoServlet.doGet()----------------------");
		int loginUserId=Integer.parseInt(request.getSession().getAttribute("userId").toString());
		// 获取*号匹配的路径
		String pathInfo = "/upload";
		System.out.println("AddPhotoServlet.doGet()"+pathInfo);
		request.setCharacterEncoding("utf-8");
		// 获取images对应的路径
		String path = getServletContext().getRealPath("/photoLibrary");
		System.out.println("ApacheOperation.doPost()----------------------"
				+ path + "----------------------");
		// 文件上传
		if (pathInfo.equals("/upload")) {
			// 判断是否是文件上传
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println(isMultipart);
			// 如果是，执行文件上传操作
			if (isMultipart) {
				System.out.println("isMultipart");
				// 创建文件上传对象
				ServletFileUpload fileUpload = new ServletFileUpload();
				try {
					String flag=null;
					// List<FileItem> items=fileUpload.parseRequest(request);
					FileItemIterator iter = fileUpload.getItemIterator(request);
					while (iter.hasNext()) {
						System.out.println("aaa");
						FileItemStream stream = iter.next();
						InputStream in = stream.openStream();
						String name = stream.getFieldName();

						if (stream.isFormField()) {
							String value = Streams.asString(in, "utf-8");
							System.out.println(name + "---" + value);
						} else {
							
							// 获取上传文件的文件名
							System.out.println("AddPhotoServlet.doGet()"+stream.getName());
							if(stream.getName()!=""){
								File f=new File(stream.getName());
								String url=f.getName();
								String upPath = path + "\\" + url;
								System.out.println("ApacheOperation.doPost()-------------fileName--------------------");
								System.out.println(url);							
								Photo photo=new Photo(loginUserId,url);
								dao.addPhoto(photo);
								flag="OK";
								OutputStream os = new FileOutputStream(upPath);
								byte[] buffer = new byte[1024];
								int len = -1;
								while ((len = in.read(buffer)) != -1) {
									os.write(buffer, 0, len);
								}
								os.close();
							}else{
								flag=null;
								request.getSession().setAttribute("flag",flag);
							}
							
						}
					}
					
					List<Photo> photos=dao.selectByUser(loginUserId);
					request.getSession().setAttribute("photos",photos);
					response.sendRedirect("/BokeProject/photo/photo.jsp");
				} catch (FileUploadException e) {
					e.printStackTrace();
					// response.sendRedirect(request.getContextPath()
					// + "/pages/failure.jsp");
				}
			}
		}else {
			// 路径无效
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "无效路径");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

//	// 复制照片到照片库
//	public void copyFile(String url) {
//		File from = new File(url);
//		// 复制到tomcat下存放照片文件夹
//		File to = new File(
//				"D:\\apache-tomcat-6.0.14\\webapps\\BokeProject\\photoLibrary");
//
//		try {
//			FileUtils.copyFileToDirectory(from, to);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
