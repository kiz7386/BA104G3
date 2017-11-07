package com.skill.model;

import java.util.List;

public class SkillService {
	private SkillDAO_interface dao;
	
	public SkillService() {
		dao = new SkillDAO_JNDI();
	}
	public SkillVO addSkill(String SKILL_NO,String SKILL_NAME,String SKILL_CATE_NO) {
		SkillVO skillVO = new SkillVO();
		skillVO.setSkill_no(SKILL_NO);
		skillVO.setSkill_name(SKILL_NAME);
		skillVO.setSkill_cate_no(SKILL_CATE_NO);
		return skillVO;
	}
	public void deleteSkill(String SKILL_NO) {
		dao.delete(SKILL_NO);
	}
	public SkillVO updateSkill(String SKILL_NO,String SKILL_NAME,String SKILL_CATE_NO) {
		SkillVO skillVO = new SkillVO();
		skillVO.setSkill_no(SKILL_NO);
		skillVO.setSkill_name(SKILL_NAME);
		skillVO.setSkill_cate_no(SKILL_CATE_NO);
		dao.update(skillVO);
		return skillVO;
	}
	public SkillVO getOneSkill(String SKILL_NO) {
		return dao.findByPrimaryKey(SKILL_NO);
	}
	public List<SkillVO> getAllSkill() {
		return dao.getall();
	}
}
