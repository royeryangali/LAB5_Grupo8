package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sw2.lab5.Entity.User;
import sw2.lab5.Repository.PostRepository;
import sw2.lab5.Repository.UserRepository;

import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"", "/", "listar"})
    public String listarUser(Model model) {
        model.addAttribute("listauser", userRepository.);
        return "listapost";
    }


    @GetMapping("/editar")
    public String editarUser(Model model, @RequestParam("id") int id) {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isPresent()) {
            model.addAttribute("employee", optional.get());
            model.addAttribute("listaJefes", getListaJefes());
            return "listausuarios";
        } else {
            return "redirect:/users";
        }

    }





}
