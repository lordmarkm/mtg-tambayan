package mtg.tambayan.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Group;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RootController {

    private static Logger LOG = LoggerFactory.getLogger(RootController.class);

    private Facebook facebook;

    @Inject
    public RootController(Facebook facebook) {
        this.facebook = facebook;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String helloFacebook(Model model) {
        boolean authorized = facebook.isAuthorized();
        LOG.debug("Root request. authorized={}", authorized);
//        if (!facebook.isAuthorized()) {
//            return "redirect:/connect/facebook";
//        }

        PagedList<Post> posts = facebook.feedOperations().getFeed("MtgTambayan");
        model.addAttribute("grp", posts);
        return "home";
    }

}
