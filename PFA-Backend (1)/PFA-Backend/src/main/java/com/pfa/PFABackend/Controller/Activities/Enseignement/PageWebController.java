package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PageWebService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String addPageWeb(@RequestBody PageWeb pageWeb) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        pageWeb.setActivitySubType2(specificActivitySubType2Instance);
        pageWebService.savePageWeb(pageWeb);
        return "A new Page web is added";
    }

    @GetMapping("/pages-webs")
    public Iterable<PageWeb> getMPagesWebs() {
        return pageWebService.getPageWebs();
    }
}
