package com.userskill.model;

import java.util.List;

public class SkillService {
	private SkillDAO_Interface dao;

	public SkillService() {
		dao = new SkillDAO_JNDI();
	}
	public SkillVO addSkill(String MEM_NO, String SKILL_NO, String SKILL_DETAIL,byte[] SKILL_CERT) {
		SkillVO skillVO = new SkillVO();
		skillVO.setMem_no(MEM_NO);
		skillVO.setSkill_no(SKILL_NO);
		skillVO.setSkill_detail(SKILL_DETAIL);
		skillVO.setSkill_cert(SKILL_CERT);
		dao.insert(skillVO);
		return skillVO;
	}
	
	public void deleteSkill(String MEM_NO, String SKILL_NO) {
		dao.delete(MEM_NO, SKILL_NO);
	}
	
	public SkillVO updateSkill(String MEM_NO, String SKILL_NO, String SKILL_DETAIL,byte[] SKILL_CERT){
		SkillVO skillVO = new SkillVO();
		skillVO.setMem_no(MEM_NO);
		skillVO.setSkill_no(SKILL_NO);
		skillVO.setSkill_detail(SKILL_DETAIL);
		skillVO.setSkill_cert(SKILL_CERT);
		dao.update(skillVO);
		return skillVO;
	}
	public SkillVO getOneSkill(String MEM_NO, String SKILL_NO) {
		return dao.findByPrimaryKey(MEM_NO, SKILL_NO);
	}
	public List<SkillVO> getAllSkill(){
		return dao.getall();	
	}
}
