package eva.springguides.handlingFormSubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {


    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping("/greeting")
    public String greetingForm(Model model){
        model.addAttribute("greeting", new Greeting());
        model.addAttribute("greetingsList", greetingService.findAll());
        return "greetingTemp";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute("greeting") Greeting greeting, Model model){
        greetingService.addGreeting(greeting);
        model.addAttribute("greetingsList", greetingService.findAll());
        return "greetingTemp";
    }


}
