package com.bbs.test.Dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbs.test.Vo.BbsVO;

@Repository
public class BbsDaoMybatis extends SqlSessionDaoSupport {
	public BbsDaoMybatis() {
		// TODO Auto-generated constructor stub
	}
	
	public List<BbsVO> selectBbsList(){
		return getSqlSession().selectList("bbsMapper.selectBbsList");
	}
	
	public BbsVO selectBbsOne(BbsVO bVO){
		return getSqlSession().selectOne("bbsMapper.selectBbsOne",bVO);
	}
	
	public void modifyBbs(BbsVO bVO){
		getSqlSession().update("bbsMapper.modifyBbs",bVO);
	}
	
	public void insertBbs(BbsVO bVO){
		getSqlSession().insert("bbsMapper.insertBbs",bVO);
	}	
	
	public void deleteBbs(BbsVO bVO){
		getSqlSession().update("bbsMapper.deleteBbs",bVO);
	}
	
}
