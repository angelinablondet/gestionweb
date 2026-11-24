package fr.limoges.valadon.gestionfioul.web.accueil;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @WebMvcTest charge uniquement la couche web (ce contrôleur + Thymeleaf), sans démarrer de serveur.
 */
@WebMvcTest(AccueilController.class)
class AccueilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void accueil_affiche_la_vue_avec_le_titre() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("accueil/index"))
                .andExpect(model().attribute("titre", "Commandes groupées de fioul"))
                // le gabarit commun a bien été appliqué (en-tête + contenu de la page)
                .andExpect(content().string(containsString("Gestion Fioul")))
                .andExpect(content().string(containsString("Commandes groupées de fioul")));
    }
}
