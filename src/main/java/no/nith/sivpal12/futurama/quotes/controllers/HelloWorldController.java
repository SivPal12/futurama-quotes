package no.nith.sivpal12.futurama.quotes.controllers;

import javax.annotation.Resource;

import no.nith.sivpal12.futurama.quotes.services.TestService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @Resource
    private TestService testService;

    @RequestMapping()
    public @ResponseBody String hello() {
        return testService.getQuote();
    }

    @RequestMapping("/asd")
    public ModelAndView hello1() {
        return new ModelAndView("helloWorld");
    }

}
