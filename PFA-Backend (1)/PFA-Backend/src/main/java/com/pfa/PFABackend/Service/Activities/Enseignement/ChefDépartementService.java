package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;

public interface ChefDépartementService {
    public void saveChefDépartement(ChefDépartement chefDépartement);

    public Iterable<ChefDépartement> getChefDépartements();



}
