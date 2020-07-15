package com.jsinc.services.attendance;

import org.springframework.ui.Model;

import com.jsinc.jsincDTO.AttendanceDTO;

public interface ServiceIf {
	public AttendanceDTO execute(AttendanceDTO dto_att);
	public void list(Model model);
}
