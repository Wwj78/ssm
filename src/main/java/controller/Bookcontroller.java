package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import service_Impl.Book_Service_Imp;
import service_Impl.Type_Service_Imp;
import utils.ReturnInfo;
import utils.ReturnJson;
@Controller
@RequestMapping("Book")
public class Bookcontroller {
		@Autowired
		Type_Service_Imp tservice;
		@Autowired
		Book_Service_Imp service;
		
		@GetMapping("index")
		public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit){
			String whera="";
			if(txt!=null) {
				whera="where book.name like '%"+txt+"%'";
			}
			return service.select(whera,page,limit);
		}
		@DeleteMapping("delete/{id}")
		public @ResponseBody ReturnJson delete(@PathVariable("id") int id){
			service.delete(id);
			return new ReturnJson();
		}
		@PostMapping("Book")
		public @ResponseBody ReturnJson insert(Book b,ModelMap m){
//			System.out.println("Bookcontroller.insert()");
			service.insert(b);
			return new ReturnJson();
		}
		@GetMapping("{id}")
		public @ResponseBody Book edit(@PathVariable("id") int id){
			return service.selectById(id);
		}
		@PutMapping("{id}")
		public @ ResponseBody ReturnJson update( Book b) {
			service.update(b);
			return new ReturnJson();
		}
		@GetMapping("Sexs")
		public @ResponseBody String[] getSexs() {
			return Book.sexs;
		}
		@GetMapping("Types")
		public @ResponseBody List getTypes() {
			return tservice.select();
		}
		
		

}
