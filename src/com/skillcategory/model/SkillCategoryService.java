package com.skillcategory.model;

import java.util.List;

public class SkillCategoryService {
	private SkillCategoryDAO_interface dao;
	
	public SkillCategoryService() {
		dao = new SkillCategoryDAO_JNDI();
	}
	
	public SkillCategoryVO addSklCate(String SKILL_CATE_NO, String SKILL_CATE_NAME) {
		SkillCategoryVO SKVO = new SkillCategoryVO();
		SKVO.setSkill_cate_no(SKILL_CATE_NO);
		SKVO.setSkill_cate_name(SKILL_CATE_NAME);
		return SKVO;
	}
	public void deleteSklCate(String SKILL_CATE_NO) {
		dao.delete(SKILL_CATE_NO);
	}
	public SkillCategoryVO updateSklCate(String SKILL_CATE_NO, String SKILL_CATE_NAME) {
		SkillCategoryVO SKVO = new SkillCategoryVO();
		SKVO.setSkill_cate_no(SKILL_CATE_NO);
		SKVO.setSkill_cate_name(SKILL_CATE_NAME);
		dao.update(SKVO);
		return SKVO;
	}
	public SkillCategoryVO getOneSkillCate(String SKILL_CATE_NO) {
		return dao.findByPrimaryKey(SKILL_CATE_NO);
	}
	public List<SkillCategoryVO> getAllSklCate(){
		return dao.getall();
	}
}