




package com.klef.jfsd.springboot.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.model.Product;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.EmployeeService;
import com.klef.jfsd.springboot.service.ProductService;

@Controller
public class ClientController
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProductService  productservice;
	
	@GetMapping("/")
	public String mainhomedemo()
	{
		return "index";
	}
	
	@GetMapping("/adminlogin")
	public ModelAndView adminlogindemo()
	{
		ModelAndView mv = new ModelAndView("adminlogin");
		
		return mv;
	}
	
	@GetMapping("/employeelogin")
	public ModelAndView employeeogindemo()
	{
		ModelAndView mv = new ModelAndView("employeelogin");
		
		return mv;
	}
	@WebListener
	public class MyWebListener implements ServletContextListener {
	 
	    @Override
	    public void contextInitialized(ServletContextEvent sce) {      
	        ServletContextListener.super.contextInitialized(sce);
	         
	        sce.getServletContext().setSessionTimeout(1); // session timeout in minutes
	    }
	 
	}
	
	@GetMapping("/employeereg")
	public ModelAndView employeeregdemo()
	{
		ModelAndView mv = new ModelAndView("employeeregistration", "emp",new Employee());
		return mv;
	}
	
	@GetMapping("/adminhome")
	public ModelAndView adminhomedemo()
	{
		ModelAndView mv = new ModelAndView("adminhome");
		
		return mv;
	}
	
	@GetMapping("/employeehome")
	public ModelAndView employeehomedemo(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("employeehome");
		
		HttpSession session = request.getSession();
		
		String euname = (String) session.getAttribute("euname");
		
		mv.addObject("euname", euname);
		
		return mv;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	     
	    HttpSession session = request.getSession();
	     
	    session.setMaxInactiveInterval(100);    // session timeout in seconds
	     
	}
	@GetMapping("/addproduct")
	   public ModelAndView addproductdemo()
	   {
		   ModelAndView mv = new ModelAndView("addproduct");
		   return mv;
	   }
	 @PostMapping("/insertproduct")
	   public String insertproductdemo(HttpServletRequest request,@RequestParam("productimage") MultipartFile file) throws IOException, SerialException, SQLException
	   {
		   String category = request.getParameter("category");
		   String name = request.getParameter("name");
		   String description = request.getParameter("description");
		   Double cost = Double.valueOf(request.getParameter("cost"));
		   String productlink = request.getParameter("productlink");
		   
			  byte[] bytes = file.getBytes();
			  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			  
			  Product p = new Product();
			  p.setCategory(category);
			  p.setName(name);
			  p.setDescription(description);
			  p.setCost(cost);
			  p.setProductlink(productlink);
			  p.setProductimage(blob);
			  
			  productservice.AddProduct(p);
			  
			  return "redirect:addproduct";
	   }
	 @GetMapping("/viewallprods")
	   public ModelAndView viewallprodsdemo()
	   {
		   List<Product> productlist = productservice.ViewAllProducts();
		   
		   ModelAndView mv = new ModelAndView("viewallproducts");
		   
		   mv.addObject("productlist", productlist);
		   
		   return mv;
	   }
	 @GetMapping("/displayprodimage")
	 public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("id") int id) throws IOException, SQLException
	 {
	   Product product =  productservice.ViewProductByID(id);
	   byte [] imageBytes = null;
	   imageBytes = product.getProductimage().getBytes(1,(int) product.getProductimage().length());

	   return ResponseEntity.ok().contentType( MediaType.IMAGE_JPEG.toString()).body(imageBytes);
	 }

	   @GetMapping("/viewproductbyid")
	public ModelAndView  viewproductbyiddemo()
	{
		   List<Product> productlist=productservice.ViewAllProducts();
		   ModelAndView mv=new ModelAndView("viewproductbyid");
		   mv.addObject("productlist",productlist);
		   return mv;
	}
	   @PostMapping("/displayproduct")
	   public ModelAndView displayproductdemo(HttpServletRequest request)
	   {
		   int pid=Integer.parseInt(request.getParameter("pid"));
		   Product product=productservice.ViewProductByID(pid);
		   ModelAndView mv=new ModelAndView("displayproduct");
		   mv.addObject("product",product);
		   return mv;
	   }
	@GetMapping("/viewallemps")
	public ModelAndView viewallempsdemo()
	{
		ModelAndView mv = new ModelAndView("viewallemployees");
		
		List<Employee> emplist = adminService.viewallemployees();
		mv.addObject("emplist",emplist);
		
		return mv;
	}
	
	@PostMapping("/checkadminlogin")
	public ModelAndView checkadminlogindemo(HttpServletRequest request)
	{
		ModelAndView mv =  new ModelAndView();
		
		String auname = request.getParameter("auname");
		String apwd = request.getParameter("apwd");
		
		Admin admin = adminService.checkadminlogin(auname, apwd);
		
		if(admin!=null)
		{
			
			HttpSession session = request.getSession();
			
			session.setAttribute("auname", auname);
			
			mv.setViewName("adminhome");
		}
		else
		{
			mv.setViewName("adminlogin");
			mv.addObject("msg", "Login Failed");
		}
		
		
		return mv;
	}
	
	
	@PostMapping("/checkemplogin")
	public ModelAndView checkemplogindemo(HttpServletRequest request)
	{
		ModelAndView mv =  new ModelAndView();
		
		String euname = request.getParameter("euname");
		String epwd = request.getParameter("epwd");
		
		Employee emp = employeeService.checkemplogin(euname, epwd);
		
		if(emp!=null)
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("euname", euname);
			
			mv.setViewName("employeehome");
		}
		else
		{
			mv.setViewName("employeelogin");
			mv.addObject("msg", "Login Failed");
		}
		
		
		return mv;
	}
	
	
	@PostMapping("/addemployee")
	public String addemployeedemo(@ModelAttribute("emp") Employee employee)
	{
		employeeService.addemployee(employee);
		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("employeeregistration");
//		mv.addObject("msg", "Employee Registered Successfully");
		
		return "redirect:employeelogin";
	}
	
	@GetMapping("/deleteemp")
	public String deleteempdemo(@RequestParam("id") int eid)
	{
		adminService.deleteemployee(eid);
		
		return "redirect:viewallemps";
	}
	
	@GetMapping("/viewemp")
	public ModelAndView viewemp(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		String euname = (String) session.getAttribute("euname");
		
		Employee emp =  employeeService.viewemployee(euname);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewemployee");
		mv.addObject("emp",emp);
		
		return mv;
	}
	
	@GetMapping("/echangepwd")
	public ModelAndView echangepwd(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		String euname = (String) session.getAttribute("euname");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("empchangepwd");
		mv.addObject("euname",euname);
		
		return mv;
	}
	
	@PostMapping("/updateemppwd")
	public ModelAndView updateemppwddemo(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("empchangepwd");
		
		HttpSession session = request.getSession();
		
		String euname = (String) session.getAttribute("euname");
		
		String eoldpwd = request.getParameter("eopwd");
		String enewpwd = request.getParameter("enpwd");
		
		int n = employeeService.changeemployeepassword(eoldpwd, enewpwd, euname);
		
		if(n > 0)
		{
			
			mv.addObject("msg","Password Updated Successfully");
		}
		else
		{
			mv.addObject("msg","Old Password is Incorrect");
		}
		
		return mv;
	}
	
	@GetMapping("/viewempbyid")
	public ModelAndView viewempbyiddemo(@RequestParam("id") int eid)
	{
		Employee emp = adminService.viewemployeebyid(eid);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("viewempbyid");
		mv.addObject("emp",emp);
		
		return mv;
	}
	
	
	
}
