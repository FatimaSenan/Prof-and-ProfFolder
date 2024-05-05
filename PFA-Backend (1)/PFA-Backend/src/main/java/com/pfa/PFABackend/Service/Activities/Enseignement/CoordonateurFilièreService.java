package com.pfa.PFABackend.Service.Activities.Enseignement;


import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import org.springframework.stereotype.Service;


public interface CoordonateurFilièreService {

    public void saveCoordonateurFilière(CoordonateurFilière coordonateurFilière);

    public Iterable<CoordonateurFilière> getCoordonateurFilières();
}
