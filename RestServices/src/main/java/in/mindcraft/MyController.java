package in.mindcraft;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	private List<Product> list =new ArrayList<>();
	
	public MyController() {
		list.add(new Product(101,"mark1",100));
		list.add(new Product(102,"mark2",200));
		list.add(new Product(103,"mark3",300));
		list.add(new Product(104,"mark4",400));
	}
	
//	@ResponseBody
	@RequestMapping(value="products", method=RequestMethod.GET)
	public List<Product> getProducts() {
		System.out.println("Checking!!!");
		return list;
	}
	
	@RequestMapping(value = "products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable int id) {
		for(Product p:list) {
			if(p.getPid() == id) {
				return p;
			}
		}
		
		return null;
	}
	
	@RequestMapping(value = "products", method = RequestMethod.POST)
	public List<Product> addProducts(@RequestBody Product p){
		list.add(p);
		return list;
	}

	
	@RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
	public List<Product> editProducts(@PathVariable int id, @RequestBody Product p){
		for(Product pupdate:list) {
			if(p.getPid() == id) {
				pupdate.setMake(p.getMake());
				pupdate.setCost(p.getCost());
				
				return list;
			}
		}
		return null;
		
	}
	
	@RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
	public List<Product> deleteProducts(@PathVariable int id){
		Product prodRem = null;
		for(Product p:list) {
			if(p.getPid() == id) {
				prodRem = p;
				break;
			}
		}
		
		if(prodRem != null) {
			list.remove(prodRem);
		}
		return null;
	}


}
