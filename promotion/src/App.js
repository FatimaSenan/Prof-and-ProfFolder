import './App.css';
import {Routes,Route,BrowserRouter, Navigate} from "react-router-dom";

import { Suspense, lazy } from 'react';
import LoadingComponent from './LoadingComponent';
import UserService from '../src/components/Professor/service/UsersService';

import ProtectedRoute from './components/ProtectedRoute';
import LoginContainer from './components/SignInUp/LoginContainer';
import RegistrationContainer from './components/SignInUp/RegistrationContainer';
import DossierAdministratif from './pages/professor/DossiersAdministratif';
import ActiviteEnseignement from './pages/professor/ActiviteEnseignement';

import ActivitiesTableForSelectedUser from './pages/commission/ActivitiesTableForSelectedUser';
import ProfessorsList from './components/commission/ProfessorsList';
import ProfessorsListAdministration from './pages/administration/ProfessorsListAdministration';
import ProfessorsInformationsMenu from './components/commission/ProfessorsInformationsMenu';
import { useState, useEffect } from 'react';

const Accueil = lazy(() => import("./pages/professor/Accueil"));
const Profile = lazy(() => import("./pages/professor/Profile"));
const ActiviteRecherche = lazy(() => import("./pages/professor/ActiviteRecherche"));
const Deconnexion = lazy(() => import("./pages/Deconnexion"));

const Stepperenseignement = lazy(() => import("./pages/professor/Stepperenseignement"));
const StepperRecherche = lazy(() => import("./pages/professor/StepperRecherche"));
const Menugrille = lazy(() => import("./pages/professor/Menugrille"));
const Annexe2 = lazy(()=> import("./components/Professor/Annexe2/Annexe2"))
const TeachingTable = lazy(() => import("./components/Professor/TeachingTable"))
const Administration = lazy(() => import("./components/administration/Administration"))
const ProfessorsTable = lazy(() => import("./pages/commission/ProfessorsTable"))
const ActivitiesInformationTable = lazy(() => import("./components/Professor/ListeActivities/ActivitiesInformationsTable"))
const Annexe2Informations = lazy(() => import("./components/commission/Annexe2Informations"))
const DossierAdministratifInformations = lazy(() => import("./components/commission/DossierAdministratifInformations"))
const Annexe3Informations = lazy(() => import("./components/commission/Annexe3Informations"))
function App() {

  const [isAuthenticated, setIsAuthenticated] = useState(UserService.isAuthenticated());
  const [role, setRole] = useState(UserService.getRole());

  useEffect(() => {
    const updateAuthState = () => {
      setIsAuthenticated(UserService.isAuthenticated());
      setRole(UserService.getRole());
    };

    window.addEventListener('storage', updateAuthState);

    return () => {
      window.removeEventListener('storage', updateAuthState);
    };
  }, []);

  return (
    <BrowserRouter>
      <Suspense fallback={<LoadingComponent/>}>
      <Routes>
        
          <Route exact path='/'  element={<LoginContainer/>}/>
          <Route exact path='/login' element={<LoginContainer/>}/>
          <Route exact path='/register' element={<RegistrationContainer/>}/>
          {UserService.isProf() && (
            <>
                <Route path='/acceuil' exact element={
            <ProtectedRoute>
              <Accueil />
            </ProtectedRoute>
          } />
          <Route path='/profile' exact element={
            <ProtectedRoute>
              <Profile />
            </ProtectedRoute>
          } />
          <Route path='/activite_enseignement' exact element={
                <ProtectedRoute>
                  <ActiviteEnseignement />
                </ProtectedRoute>
            } />
          <Route path='/activite_recherche' exact element={
                <ProtectedRoute>
                  <ActiviteRecherche />
                </ProtectedRoute>
            } />
            <Route path='/activite_informations' exact element={
                <ProtectedRoute>
                  <ActivitiesInformationTable userRole="PROFESSOR"/>
                </ProtectedRoute>
            } />
          
          <Route path='/deconnexion' exact element={
            <ProtectedRoute>
              <Deconnexion />
            </ProtectedRoute>
          } />
          
          <Route path='/stepper_enseignement' exact element={
            <ProtectedRoute>
              <Stepperenseignement />
            </ProtectedRoute>
          } />
          <Route path='/stepper_recherche' exact element={
            <ProtectedRoute>
              <StepperRecherche />
            </ProtectedRoute>
          } />
          <Route path='/menu_grille' exact element={
            <ProtectedRoute>
              <Menugrille />
            </ProtectedRoute>
          } />
          <Route path='/dossier_administratif' exact element={
            <ProtectedRoute>
            <DossierAdministratif/>
            </ProtectedRoute>}/>
            <Route path='/annexe_3' exact element={
                <ProtectedRoute role="PROFESSOR">
                  <TeachingTable />
                </ProtectedRoute>
              } />
              <Route path='/annexe_2' exact element={
                <ProtectedRoute role="PROFESSOR">
                  <Annexe2/>
                </ProtectedRoute>
              } />
            </>
          )}
          {/*<Route path="*" element={<Navigate to="/login" />} />*/}
          {UserService.isAdmin() && (
            <>
            <Route path='/administration' exact element={
              <ProtectedRoute role="ADMIN">
                <ProfessorsListAdministration />
              </ProtectedRoute>
              }/>
              <Route path='/deconnexion' exact element={
            <ProtectedRoute>
              <Deconnexion />
            </ProtectedRoute>
          } />
          </>

              
          
          )}

        {UserService.isCommission() && (
            <>
            <Route path='/professors_table' exact element={
              <ProtectedRoute role="COMMISSION">
                <ProfessorsTable />
              </ProtectedRoute>
              }/>
              <Route path='/menu-informations' exact element={
              <ProtectedRoute role="COMMISSION">
                <ProfessorsInformationsMenu />
              </ProtectedRoute>
              }/>
              <Route path='/selected-user-activities' exact element={
              <ProtectedRoute role="COMMISSION">
                <ActivitiesTableForSelectedUser/>
              </ProtectedRoute>
              }/>
              
              <Route path='/activite_informations' exact element={
              <ProtectedRoute role="COMMISSION">
                <ActivitiesInformationTable userRole="COMMISSION"/>
              </ProtectedRoute>
              }/>
              
              <Route path='/formulaire_inscription-informations' exact element={
                <ProtectedRoute>
                  <Annexe2Informations/>
                </ProtectedRoute>
              } />
              
              <Route path='/dossier-administratif-informations' exact element={
                <ProtectedRoute>
                  <DossierAdministratifInformations/>
                </ProtectedRoute>
              } />

              <Route path='/tableau-detaillé-informations' exact element={
                <ProtectedRoute>
                  <Annexe3Informations/>
                </ProtectedRoute>
              } />
               <Route path='/deconnexion' exact element={
            <ProtectedRoute>
              <Deconnexion />
            </ProtectedRoute>
          } />
          
          </>

              
          
          )}
        </Routes>
      </Suspense>
    </BrowserRouter>
  );
}

export default App;
