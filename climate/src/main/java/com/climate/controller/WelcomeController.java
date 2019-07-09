package com.climate.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.climate.dao.ClimateDAO;
import com.climate.dto.ClimateDTO;

@Controller
public class WelcomeController {
	
	Logger logger = LogManager.getLogger(WelcomeController.class);
	@Autowired
	private ClimateDAO climateDao;

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

  

    @GetMapping("/")
    public String main(Model model) {
    	List<ClimateDTO> list= climateDao.getData();
        model.addAttribute("message", message);
        model.addAttribute("list", list);
       logger.info("************climate controller");
        return "welcome"; //view
    }

    // /detail?id=123
    @GetMapping("/detail")
    public String mainWithParam(
            @RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) {
    	logger.info("****************climate detail,id="+id);
    	List<ClimateDTO> list= climateDao.getData();
    	try {
	    	ClimateDTO dto= list.get(Integer.valueOf(id));
	    	
	    	
//	    	List<ClimateDTO> detail= new ArrayList<ClimateDTO>();
//	    	detail.add(dto);
	    	
	        model.addAttribute("climate", dto);
        }catch(Exception e) {
        	
        	return "error";
        }

        return "detail"; //view
    }

}