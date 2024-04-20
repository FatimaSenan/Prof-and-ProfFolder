import './App.css';
import {Routes,Route,BrowserRouter} from "react-router-dom";
import Accueil from './pages/Accueil';
//import Apropos from './pages/Apropos';
//import Deconnexion from './pages/Deconnexion';
//import Listeactivities from './pages/Listeactivities';
//import Parametres from './pages/Parametres';
//import Profile from './pages/Profile';
import { Suspense, lazy } from 'react';
import LoadingComponent from './LoadingComponent';
//import Menugrille from './pages/Menugrille'
//import Stepperenseignement from './pages/Stepperenseignement';
//import StepperRecherche from './pages/StepperRecherche';

//const Accueil = lazy(() => import("./pages/Accueil"));
const Profile = lazy(() => import("./pages/Profile"));
const Listeactivities = lazy(() => import("./pages/Listeactivities"));
const Apropos = lazy(() => import("./pages/Apropos"));
const Deconnexion = lazy(() => import("./pages/Deconnexion"));
const Parametres = lazy(() => import("./pages/Parametres"));
const Stepperenseignement = lazy(() => import("./pages/Stepperenseignement"));
const StepperRecherche = lazy(() => import("./pages/StepperRecherche"));
const Menugrille = lazy(() => import("./pages/Menugrille"));

function App() {
  return (
    <BrowserRouter>
      <Suspense fallback={<LoadingComponent/>}>
      <Routes>
          {/*<Route path='/' exact element={<SignInUp/>}/>*/}
          <Route path='/' exact element={<Accueil/>}></Route>
          
            <Route path='/profile' exact element={<Profile/>}></Route>
            <Route path='/listeactivities' exact element={<Listeactivities/>}></Route>
            <Route path='/apropos' exact element={<Apropos/>}></Route>
            <Route path='/deconnexion' exact element={<Deconnexion/>}></Route>
            <Route path='/parametres' exact element={<Parametres/>}></Route>
            <Route path='/stepper_enseignement' exact element={<Stepperenseignement/>}></Route>
            <Route path='/stepper_recherche' exact element={<StepperRecherche/>}></Route>
            <Route path='/menu_grille' exact element={<Menugrille/>}></Route>
          

        </Routes>
      </Suspense>
    </BrowserRouter>
  );
}

export default App;
