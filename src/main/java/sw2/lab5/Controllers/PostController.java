package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sw2.lab5.Entity.Post;
import sw2.lab5.Repository.PostRepository;

import java.util.Optional;

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
        return "listapost";
    }

    @GetMapping("/borrar")
    public String borrarPost(@RequestParam("id") int id, RedirectAttributes attr) {
        Optional<Post> optional = postRepository.findById(id);

        if (optional.isPresent()) {
            postRepository.deleteById(id);
        }
        attr.addFlashAttribute("msg","post borrado exitosamente");
        return "redirect:/posts";
    }
}
