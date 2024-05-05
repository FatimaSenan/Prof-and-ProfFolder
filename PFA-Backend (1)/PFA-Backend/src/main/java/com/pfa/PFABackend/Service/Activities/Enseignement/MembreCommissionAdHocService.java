package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionAdHoc;

public interface MembreCommissionAdHocService {

    public void saveMembreCommissionAdHoc(MembreCommissionAdHoc membreCommissionAdHoc);

    public Iterable<MembreCommissionAdHoc> getMembreCommissionAdHocs();
}
