package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Type;
import model.Type;
import model.Type;
import service_Impl.Type_Service_Imp;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@RequestMapping("Type")
public class Typecontroller {
	@Autowired
	Type_Service_Imp service;
	@GetMapping(value = "Type")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit){
		String whera="";
		if(txt!=null) {
			whera="where name like '%"+txt+"%'";
		}
		return service.selectAll(whera,page,limit);
	}
	@DeleteMapping("{id}")
	public @ResponseBody ReturnJson delete(@PathVariable("id") int id){
		service.delete(id);
		return new ReturnJson();
	}
	@PostMapping("Type")
	public @ResponseBody ReturnJson insert(Type b,ModelMap m){
//		System.out.println("Typecontroller.insert()");
		service.insert(b);
		return new ReturnJson();
	}
	@GetMapping("{id}")
	public @ResponseBody Type edit(@PathVariable("id") int id){
		return service.selectById(id);
	}
	@PutMapping("Type/{id}")
	public @ ResponseBody ReturnJson update(Type b,ModelMap m) {
		service.update(b);
		return new ReturnJson();
	}
	
}
