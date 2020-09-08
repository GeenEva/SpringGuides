package eva.springguides.validatingFormInput;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");
    }


    @GetMapping("/")
    public String showForm(PersonForm personForm){
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm,
                                  BindingResult bindingResult){

        System.out.println("This is the name of the bindingResult: "
                    + bindingResult.getRawFieldValue("name"));

        System.out.println("BindingResult has errors yes or no: " +
                bindingResult.hasErrors());
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/results";
    }

}
