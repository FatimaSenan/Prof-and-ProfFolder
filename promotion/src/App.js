import './App.css';
import {Routes,Route,BrowserRouter, Navigate} from "react-router-dom";
//import Accueil from './pages/Accueil';
//import Apropos from './pages/Apropos';
//import Deconnexion from './pages/Deconnexion';
//import Listeactivities from './pages/Listeactivities';
//import Parametres from './pages/Parametres';
//import Profile from './pages/Profile';
import { Suspense, lazy } from 'react';
import LoadingComponent from './LoadingComponent';
import SignInUp from './components/SignInUp/SignInUp';
import UserService from '../src/components/Professor/service/UsersService';

import ProtectedRoute from './components/ProtectedRoute';
import LoginContainer from './components/SignInUp/LoginContainer';
import RegistrationContainer from './components/SignInUp/RegistrationContainer';
import DossierAdministratif from './pages/DossiersAdministratif';
import ActiviteEnseignement from './pages/ActiviteEnseignement';
import ActivitiesInformationTable from './components/Professor/ListeActivities/ActivitiesInformationsTable';

const Accueil = lazy(() => import("./pages/Accueil"));
const Profile = lazy(() => import("./pages/Profile"));
const ActiviteRecherche = lazy(() => import("./pages/ActiviteRecherche"));
const Apropos = lazy(() => import("./pages/Apropos"));
const Deconnexion = lazy(() => import("./pages/Deconnexion"));
const Parametres = lazy(() => import("./pages/Parametres"));
const Stepperenseignement = lazy(() => import("./pages/Stepperenseignement"));
const StepperRecherche = lazy(() => import("./pages/StepperRecherche"));
const Menugrille = lazy(() => import("./pages/Menugrille"));
const Annexe2 = lazy(()=> import("./components/Professor/Annexe2/Annexe2"))
const TeachingTable = lazy(() => import("./components/Professor/TeachingTable"))
const Administration = lazy(() => import("./components/administration/Administration"))
const ProfessorsTable = lazy(() => import("./pages/commission/ProfessorsTable"))

function App() {
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
                  <ActivitiesInformationTable />
                </ProtectedRoute>
            } />
          <Route path='/apropos' exact element={
            <ProtectedRoute>
              <Apropos />
            </ProtectedRoute>
          } />
          <Route path='/deconnexion' exact element={
            <ProtectedRoute>
              <Deconnexion />
            </ProtectedRoute>
          } />
          <Route path='/parametres' exact element={
            <ProtectedRoute>
              <Parametres />
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
            <Route path='/teaching_table' exact element={
                <ProtectedRoute role="PROFESSOR">
                  <TeachingTable />
                </ProtectedRoute>
              } />
              <Route path='/annexe2' exact element={
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
                <Administration />
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
