package com.someco.controller;

import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.someco.service.DataService;
import com.someco.utils.Ajax;
import com.someco.utils.ExceptionHandlerController;
import com.someco.utils.RestException;

/**
 * @author ikarmatsky
 *
 */
@org.springframework.stereotype.Controller
public class Controller extends ExceptionHandlerController{
	
	private static final Log LOG = LogFactory.getLog(Controller.class);
	
	@Autowired
	@Qualifier ("dataService")
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	@RequestMapping(value = "/persist", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> persist(@RequestParam("data") String data) throws RestException {
        try {
            if (data == null || data.equals("")) {
                return Ajax.emptyResponse();
            }
            dataService.persist(data);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/getRandomData", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getRandomData() throws RestException {
        try {
            Set<String> result = dataService.getRandomData();
            return Ajax.successResponse(result);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }
    
    @RequestMapping(value = "/")
    public String index(){
    	return "index";
    }
    
    @RequestMapping(value = "/jaja")
    public String mainPage(){
    	return "jaja";
    }
    
    @RequestMapping(value = "/restlogin")
    public String restLogin(){
    	RestTemplate restTemplate = new RestTemplate();
    	final String URL = "http://localhost:8080/login?username=admin&password=admin";
    	ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, null, String.class);
    	System.out.println(response.getBody());
    	return "index";
    }
}
