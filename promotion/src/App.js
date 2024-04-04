import Sidenav from './components/Sidenav';
import './App.css';
import {Routes,Route,BrowserRouter} from "react-router-dom";
import Accueil from './pages/Accueil';
import Apropos from './pages/Apropos';
import Deconnexion from './pages/Deconnexion';
import Listeactivities from './pages/Listeactivities';
import Parametres from './pages/Parametres';
import Profile from './pages/Profile';
import SignInUp from './components/SignInUp/SignInUp';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/*<Route path='/' exact element={<SignInUp/>}/>*/}
        <Route path='/' exact element={<Accueil/>}></Route>
        <Route path='/profile' exact element={<Profile/>}></Route>
        <Route path='/listeactivities' exact element={<Listeactivities/>}></Route>
        <Route path='/apropos' exact element={<Apropos/>}></Route>
        <Route path='/deconnexion' exact element={<Deconnexion/>}></Route>
        <Route path='/parametres' exact element={<Parametres/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
