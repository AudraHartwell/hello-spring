package org.lauchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    /*@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring";
    }*/

    @GetMapping("goodbye") // ;lives /hello/goodbye
    public String goodbye() {
        return "Goodbye, Spring";
    }

    //Handles request of the form /hello?name=Launchcode

    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String hello(@RequestParam String name, Model model) {
       String greeting="Hello" + name + "!";
       model.addAttribute("greeting", greeting);
        return "hello";
    }

    //Handles request of the form /hello/Launchcode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello," + name + "!";
    }

   /* @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' >" + //submit a request to /hello
                "<input type = 'text' name= 'name'>" +
                "<select name='language'>" +
                    "<option value='English'>English</option>" +
                    "<option value='Spanish'>Spanish</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='German'>German</option>" +
                    "<option value='Italian'>Italian</option>" +
                "</select>" +
                "<input type ='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        switch (language){
            case "Spanish":
                return "Hola," + name;
            case "French" :
                return "Bonjour," + name;
            case "German":
                return "Hallo," + name;
            case "Italian":
                return "Ciao," + name;
            case "English":
            default:
                return "Hello" + name;
        }
    }
}
