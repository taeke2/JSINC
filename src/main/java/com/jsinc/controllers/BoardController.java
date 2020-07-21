package com.jsinc.controllers;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jsinc.jsincDTO.BoardDTO;
import com.jsinc.services.board.boardService;
import com.jsinc.services.board.departmentService;
import com.jsinc.services.board.referenceService;

// 작성자 : 임재만

// 게시판 Controller
@Controller
public class BoardController {
	@Resource(name = "uploadPath")
	private String uploadPath;

	ApplicationContext ac = App.ac;
	
	@Autowired
	referenceService rs;
	@Autowired
	boardService bs;
	@Autowired
	departmentService ds;

	@RequestMapping("allCompanyBoard")
	public ModelAndView allCompany() throws Exception {
		List<BoardDTO> list = bs.listAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/allCompany");
		mav.addObject("board", list);
		return mav;
	}

	@RequestMapping("allCompanyCon")
	public ModelAndView allCompanyCon(@RequestParam int bno) throws Exception {
		BoardDTO dto = bs.view(bno);
		String content = dto.getContent();
		content = content.replace("\n", "<br>");
		dto.setContent(content);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/allCompanyCon");
		mav.addObject("board", dto);
		return mav;
	}

	@RequestMapping("writeBoard")
	public String moveWrite() {
		return "board/writeBoard";
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String acWrite(@ModelAttribute BoardDTO dto) throws Exception {

		bs.create(dto);
		return "redirect:allCompanyBoard";
	}

	@RequestMapping("updateCom")
	public ModelAndView updateCom(@RequestParam int bno) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/updateCom");
		mav.addObject("board", bs.view(bno));
		return mav;
	}

	@RequestMapping(value = "updateAC", method = RequestMethod.POST)
	public String updateAC(@ModelAttribute BoardDTO dto) throws Exception {
		bs.update(dto);
		return "redirect:allCompanyCon?bno=" + dto.getBno();
	}

	@RequestMapping("deleteAC")
	public String deleteCom(@RequestParam int bno) throws Exception {
		bs.delete(bno);
		return "redirect:allCompanyBoard";
	}

	/////////////////// 부서 게시판////////////////////////////
	@RequestMapping("depView")
	public ModelAndView depView(@RequestParam int bno) {
		BoardDTO dto = ds.depRead(bno);
		String content = dto.getContent();
		content = content.replace("\n", "<br>");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department/depView");
		mav.addObject("view", dto);
		return mav;
	}

	@RequestMapping("departmentBoard")
	public ModelAndView department() {
		List<BoardDTO> list = ds.allList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department");
		mav.addObject("department", list);
		return mav;
	}

	@RequestMapping("depWrite")
	public String depWrite() {
		return "board/department/depWrite";
	}

	@RequestMapping(value = "depCreate", method = RequestMethod.POST)
	public String depCreate(@ModelAttribute BoardDTO dto) {
		ds.create(dto);
		return "redirect:departmentBoard";
	}

	@RequestMapping("develop")
	public ModelAndView develop() {
		List<BoardDTO> list = ds.develop();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department/develop");
		mav.addObject("develop", list);
		return mav;
	}

	@RequestMapping("support")
	public ModelAndView support() {
		List<BoardDTO> list = ds.support();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department/support");
		mav.addObject("support", list);
		return mav;
	}

	@RequestMapping("accounting")
	public ModelAndView accounting() {
		List<BoardDTO> list = ds.accounting();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department/accounting");
		mav.addObject("accounting", list);
		return mav;
	}

	@RequestMapping("quality")
	public ModelAndView quality() {
		List<BoardDTO> list = ds.quality();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department/quality");
		mav.addObject("quality", list);
		return mav;
	}

	@RequestMapping("overseas")
	public ModelAndView overseas() {
		List<BoardDTO> list = ds.overseas();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department/overseas");
		mav.addObject("overseas", list);
		return mav;
	}

	@RequestMapping("updateDep")
	public ModelAndView updateDep(@RequestParam int bno) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/department/depUpdate");
		mav.addObject("dep", ds.depRead(bno));
		return mav;
	}

	@RequestMapping(value = "updateD", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO dto) {
		ds.depUpdate(dto);
		return "redirect:depView?bno=" + dto.getBno();
	}

	@RequestMapping("deleteDep")
	public String delete(@RequestParam int bno) {
		ds.depDelete(bno);
		return "redirect:departmentBoard";
	}

	///////////////////////////////////////////////
	@RequestMapping("referenceBoard")
	public ModelAndView reference() throws Exception {
		List<BoardDTO> list = rs.fileListAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/reference");
		mav.addObject("reference", list);

		return mav;
	}

	@RequestMapping("upload")
	public String upload() {
		return "board/upload";
	}

	@RequestMapping(value = "uploadWrite", method = RequestMethod.POST)
	public String uploadWrite(@ModelAttribute BoardDTO dto, MultipartFile file_0) throws Exception {

		// 업로드
		UUID uuid = UUID.randomUUID(); // 파일 이름 중복 방지
		String saveName = uuid + "_" + file_0.getOriginalFilename(); // UUID가 붙은 파일이름을 객체에 저장
		String realName = file_0.getOriginalFilename();
		File saveFile = new File(uploadPath + File.separator + "files", saveName);// 저장할 폴더 이름 , 저장할 파일 이름
		try {
			file_0.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입히기
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		dto.setSavefile(File.separator + "files" + File.separator + saveName);
		dto.setRealfile(realName);
		rs.create(dto);

		return "redirect:referenceBoard";
	}

	@RequestMapping("deleteRef")
	public String deleteRef(@RequestParam int bno) throws Exception {
		BoardDTO dto = rs.fileView(bno);
		String file = dto.getSavefile();
		File deleteFile = new File(uploadPath + file);
		if (deleteFile.exists()) {
			if (deleteFile.delete()) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} else {
			System.out.println("파일을 찾지 못함");
		}
		return "redirect:referenceBoard";
	}

	@RequestMapping("refContent")
	public ModelAndView refContent(@RequestParam int bno) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/refContent");
		mav.addObject("ref", rs.fileView(bno));
		return mav;
	}

	@RequestMapping("fileDownload")
	public ModelAndView download(@RequestParam int bno) throws Exception {

		BoardDTO dto = rs.fileView(bno);
		String realName = dto.getRealfile();
		String save = dto.getSavefile();
		String fullPath = uploadPath + save;

		save = new String(save.getBytes("iso-8859-1"), "UTF-8");
		realName = new String(realName.getBytes("iso-8859-1"), "UTF-8");

		File file = new File(fullPath);
		File file2 = new File(realName);

		// File downloadFile = new File(uploadPath + save);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("fileDownload");
		mav.addObject("downloadFile", file);
		mav.addObject("realFileName", file2);

		if (!file.exists()) {
			return null;
		}

		return mav;
		// new ModelAndView("fileDownload", "downloadFile", downloadFile);

	}

}
