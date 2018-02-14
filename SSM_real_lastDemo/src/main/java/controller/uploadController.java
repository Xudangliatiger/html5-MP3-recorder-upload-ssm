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
		// ����ļ���Ϊ�գ�д���ϴ�·��
		if (!file.isEmpty()) {
			// �ϴ��ļ�·��
			String path = request.getServletContext().getRealPath("/");
			// �ϴ��ļ���
			String filename = mp3Name;
			File filepath = new File(path, filename);
			// �ж�·���Ƿ���ڣ���������ھʹ���һ��
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// ���ϴ��ļ����浽һ��Ŀ���ļ�����
			file.transferTo(new File(path + File.separator + filename));//File.separator ָ����һ��ϵͳ·������ָ���/��\\\û�й�ϵ����Ϊwin��/\���У���Linuxֻ��\
			return "success";
		} else {
			return "error";
		}

	}

}