package com.yongyou.yfl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yongyou.yfl.pojo.Hero;
import com.yongyou.yfl.service.HeroService;

@RestController
public class HeroController {

	@Autowired
	HeroService heroService;

	@GetMapping("/heroes")
	public PageInfo<Hero> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		PageHelper.startPage(start, size, "is desc");
		List<Hero> heros = heroService.list();
		System.out.println(heros.size());

		PageInfo<Hero> page = new PageInfo<>(heros, 5);
		return page;
	}

	@GetMapping("/heroes/{id}")
	public Hero get(@PathVariable("id") int id) throws Exception {
		System.out.println(id);
		Hero h = heroService.get(id);
		System.out.println(h);
		return h;
	}

	@PostMapping("/heroes")
	public String add(@RequestBody Hero hero) throws Exception {
		heroService.add(hero);
		return "success";
	}

	@DeleteMapping("/heroes/{id}")
	public String delete(@RequestBody Hero hero) throws Exception {
		heroService.delete(hero.getId());
		return "success";
	}

	@PutMapping("/heroes/{id}")
	public String update(@RequestBody Hero hero) throws Exception {
		heroService.update(hero);
		return "success";
	}
	
	
	/*页面跳转 部分*/
    @RequestMapping(value="/listHero", method=RequestMethod.GET)
    public ModelAndView listHero(){
        ModelAndView mv = new ModelAndView("listHero");
        return mv;
    }
     
    @RequestMapping(value="/editHero", method=RequestMethod.GET)
    public ModelAndView editHero(){
        ModelAndView mv = new ModelAndView("editHero");
        return mv;
    }  

}
