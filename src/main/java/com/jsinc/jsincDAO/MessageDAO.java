package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.MessageDTO;

@Repository
public class MessageDAO {
	private static final String namespace="com.jsinc.mybatis.message";
	@Autowired
	private SqlSession sqlSession;
	//JSinc_sendMsg 테이블에 저장됨
	public void sendMsg(MessageDTO dto) {
		sqlSession.insert(namespace+".sendMsg",dto);
	}
	//JSinc_recMsg테이블에 저장됨
	public void recMsg(MessageDTO dto) {
		sqlSession.insert(namespace+".recMsg",dto);
	}
	//보낸 메세지를 가져옴
	public List<MessageDTO> sentView(int empNo){
		return sqlSession.selectList(namespace+".sentView",empNo);
	}
	//받은 메세지 가져옴
	public List<MessageDTO> recView(int recEmpNo){
		return sqlSession.selectList(namespace+".recView",recEmpNo);
	}
	//보낸 메세지 삭제
	public int sentMsgDel(MessageDTO dto) {
	 return sqlSession.delete(namespace+".sentMsgDel",dto);
	}
	//받은 메세지 삭제
	public int recMsgDel(MessageDTO dto) {
		return sqlSession.delete(namespace+".recMsgDel",dto);
		
	}
	//메세지 알림
	public int msgAlarm(int empNo) {
		return sqlSession.selectOne(namespace+".msgAlarm",empNo);
	}
	//메세지 알림 체크 'Y'
	public int msgChk(MessageDTO dto) {
		return sqlSession.update(namespace+".msgChk",dto);
	}
	//최근 메세지 가져오기
	public List<MessageDTO> recentMsg(int empNo){
		return sqlSession.selectList(namespace+".recentMsg",empNo);
	}
	
	
}
