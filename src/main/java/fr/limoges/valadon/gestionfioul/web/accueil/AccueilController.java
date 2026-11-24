package fr.limoges.valadon.gestionfioul.web.accueil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Controller (et non @RestController) : la méthode renvoie le NOM d'une vue Thymeleaf,
 * pas des données JSON. Spring cherche alors le fichier templates/accueil/index.html.
 */
@Controller
public class AccueilController {

    @GetMapping("/")
    public String accueil(Model model) {
        // le Model transporte des données du contrôleur vers la vue
        model.addAttribute("titre", "Commandes groupées de fioul");
        return "accueil/index";
    }
}