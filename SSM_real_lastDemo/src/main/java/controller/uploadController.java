package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Blob;

@Controller
@RequestMapping("")
public class uploadController {
	@RequestMapping(value = "/uploadcontroller", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, 
			@RequestParam("mp3Name") String mp3Name,
			@RequestParam("file") MultipartFile file) throws Exception {
	System.out.println(mp3Name);
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/");
			// 上传文件名
			String filename = mp3Name;
			File filepath = new File(path, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + filename));//File.separator 指的是一个系统路径，与分隔符/、\\\没有关系。因为win是/\都行，而Linux只能\
			return "success";
		} else {
			return "error";
		}

	}

}