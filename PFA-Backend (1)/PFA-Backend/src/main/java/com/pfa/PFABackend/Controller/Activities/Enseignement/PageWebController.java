package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PageWebService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PageWebController {
    @Autowired
    private PageWebService pageWebService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-page-web")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addPageWeb(@RequestParam("activityName") String activityName, @RequestParam("lien") String lien) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        try{
            pageWebService.savePageWeb(specificActivitySubType2Instance, activityName, lien);
            return "A new Page web is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add page web";
        }

    }

    @GetMapping("/pages-webs")
    public Iterable<PageWeb> getMPagesWebs() {
        return pageWebService.getPageWebs();
    }
}
