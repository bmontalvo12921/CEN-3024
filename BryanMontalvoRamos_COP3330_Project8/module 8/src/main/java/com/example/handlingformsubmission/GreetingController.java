import com.example.handlingformsubmission.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//controller to map html files in the project folders
public class GreetingController {
    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/greeting";
    }//if any errors in local host site it will redirect into localhost:8080/greeting


    // Show form
    @GetMapping("/greeting")
    public String showForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";  // Load greeting.html
    }

    // Handle form submission
    @PostMapping("/greeting")
    public String submitForm(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";  // Load result.html directly
    }

    // shows posted results
    @GetMapping("/result")
    public String showResult() {
        return "result"; // Load result.html
    }
}
