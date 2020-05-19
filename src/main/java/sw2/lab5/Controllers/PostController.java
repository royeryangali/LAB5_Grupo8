package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"", "/", "listar"})
    public String listarPost(Model model) {
               model.addAttribute("listapost", postRepository.findAll());
        return "listarpost";
    }
}