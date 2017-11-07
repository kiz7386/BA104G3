package com.userskill.model;

import java.util.List;

public interface SkillDAO_Interface {
	public void insert(SkillVO skillVO);
	public void delete(String MEM_NO, String SKILL_NO);
	public void update(SkillVO skillVO);
	public SkillVO findByPrimaryKey(String MEM_NO, String SKILL_NO);
	public List<SkillVO> getall();
	
}
