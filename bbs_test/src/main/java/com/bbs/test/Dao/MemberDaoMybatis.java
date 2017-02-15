package com.bbs.test.Dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbs.test.Vo.MemberVO;

@Repository
public class MemberDaoMybatis extends SqlSessionDaoSupport {

	public void insertMember(MemberVO mVO){
		getSqlSession().insert("memberMapper.insertMember",mVO);
	}
	
	public MemberVO selectMember(MemberVO mVO) {
		return getSqlSession().selectOne("memberMapper.selectMember",mVO);
	}
	
//	public MemberVO updateMember(MemberVO mVO) {
//		return getSqlSession().selectOne("memberMapper.updateMember",mVO);
//	}
//	public void deleteMember(MemberVO mVO) {
//		getSqlSession().update("memberMapper.deleteMember",mVO);
//	}
	
	public String selectMemberOne(MemberVO mVO) {
		return getSqlSession().selectOne("memberMapper.selectMemberOne",mVO);
	}
	
}
