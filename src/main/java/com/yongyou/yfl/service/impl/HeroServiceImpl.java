package com.yongyou.yfl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongyou.yfl.mapper.HeroMapper;
import com.yongyou.yfl.pojo.Hero;
import com.yongyou.yfl.service.HeroService;
@Service
public class HeroServiceImpl implements HeroService{
	
	@Autowired HeroMapper heroMapper;

	@Override
	public int add(Hero hero) {
		return heroMapper.add(hero);
	}

	@Override
	public void delete(int id) {
		heroMapper.delete(id);
	}

	@Override
	public Hero get(int id) {
		return heroMapper.get(id);
	}

	@Override
	public int update(Hero hero) {
		return heroMapper.update(hero);
	}

	@Override
	public List<Hero> list() {
		return heroMapper.list();
	} 
}
