package com.skill.model;

import java.util.List;


public interface SkillDAO_interface {
	public void insert(SkillVO skillVO);
	public void delete(String SKILL_NO);
	public void update(SkillVO skillVO);
	public SkillVO findByPrimaryKey(String SKILL_NO);
	public List<SkillVO> getall();
}
