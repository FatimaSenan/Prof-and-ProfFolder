package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;

public interface ViceDoyenService {

    public void saveViceDoyen(ViceDoyen viceDoyen);

    public Iterable<ViceDoyen> getVicesDoyens();
}
