package com.skillcategory.model;

import java.util.List;


public interface SkillCategoryDAO_interface {
	public void insert(SkillCategoryVO SkillCategoryVO);
	public void delete(String SKILL_CATE_NO);
	public void update(SkillCategoryVO SkillCategoryVO);
	public SkillCategoryVO findByPrimaryKey(String SKILL_CATE_NO);
	public List<SkillCategoryVO> getall();
}
