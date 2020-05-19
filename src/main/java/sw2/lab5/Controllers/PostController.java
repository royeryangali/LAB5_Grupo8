package sw2.lab5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sw2.lab5.Entity.Post;
import sw2.lab5.Repository.PostRepository;
import sw2.lab5.Repository.RoleRepository;
import sw2.lab5.Repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
               model.addAttribute("listaautores", postRepository.findAll());
        return "listapost";
    }
    @GetMapping("/editar")
    public String editarPost(@ModelAttribute("post") Post post,
                                      Model model, @RequestParam("id") int id) {

        Optional<Post> optProduct = postRepository.findById(id);
        if (optProduct.isPresent()) {
            post = optProduct.get();
            model.addAttribute("post", post);
            model.addAttribute("listarol", roleRepository.findAll());
           return "product/form";
        } else {
            return "redirect:/product";
        }
    }

    @PostMapping("/guardar")
    public String guardarPost(Post post,
                                  @RequestParam("author") String author,
                                  @RequestParam("content") String content,
                              @RequestParam("published") String published,@RequestParam("title") String title) {


        try {
            post.setAuthorid(author);
            post.setContent(content);
            post.setPublished(published);
            post.setTitle(title);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        postRepository.save(post);
        return "redirect:/posts";
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
