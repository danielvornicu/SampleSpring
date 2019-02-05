package tech.dev.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/test")
@SessionAttributes({"myBean1"})
public class TestController {

    private static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        model.addAttribute("message", "Spring MVC XML Config Test...");
        return "message";
    }

    @ModelAttribute("myBean1")
    public String addToModel() {
        LOGGER.info("Inside of addToModel SessionScope");
        return "test";
    }

    @ModelAttribute
    public void addToModel(ModelMap model) {
        LOGGER.info("Inside of addToModel RequestScope");
        model.put("myBean2", "test");
    }


}
