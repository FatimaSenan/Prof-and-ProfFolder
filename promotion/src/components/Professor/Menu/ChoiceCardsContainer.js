import { Box } from "@mui/material";
import ChoiceCard from "./ChoiceCard";
import './choiceCardsContainer.css';
import { Link, useNavigate } from 'react-router-dom';



export default function ChoiceCardsContainer({userRole, selectedUser}) {

  const navigate = useNavigate();
  console.log(selectedUser);

  const handleActivitésClick = () => {
    navigate('/selected-user-activities', {state: {prof: selectedUser}});
  }

  const handleFormulaireInscriptionClick = () => {
    navigate('/formulaire_inscription-informations', {state: {prof: selectedUser}});
  }
  const handleDossierAdministratifClick = () => {
    navigate('/dossier-administratif-informations', {state: {prof: selectedUser}});
  }
  const handleTableauDetailléClick = () => {
    navigate('/tableau-detaillé-informations', {state: {prof: selectedUser}});
  }
    return(
    <Box className="choice-cards-container"
    sx={{
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space between',
       flexWrap: 'wrap',
        '& > :not(style)': {
          m: 1,
        },
      }}>
        {userRole === "PROFESSOR" ? (<Link to={userRole === "PROFESSOR" ? "/dossier_administratif": ""} style={{ textDecoration: 'none' }}>
           <ChoiceCard title="Dossier Administratif" icon="dossier"/>
        </Link>) 
        : 
        (
          <ChoiceCard title="Dossier Administratif" icon="dossier" onClick={() => handleDossierAdministratifClick()}/>
        )}
        {userRole === "PROFESSOR" ? (<Link to="/menu_grille" style={{ textDecoration: 'none' }}>
           <ChoiceCard title="Grille d'évaluation" icon="evaluation"/>
        </Link>) :  <ChoiceCard title="Activités" icon="evaluation" onClick={() => handleActivitésClick()}/>}
        {userRole === "PROFESSOR" ? (<Link to={userRole === "PROFESSOR" ? "/annexe_2": ""} style={{ textDecoration: 'none' }}>
           <ChoiceCard title="Formulaire d'inscription" icon="inscription"/>
        </Link>)
        :
        <ChoiceCard title="Formulaire d'inscription" icon="inscription" onClick={() => handleFormulaireInscriptionClick()}/>
        }
        {userRole === "PROFESSOR" ? (<Link to={userRole === "PROFESSOR" ?"/annexe_3": ""} style={{ textDecoration: 'none' }}>
            <ChoiceCard title="Tableau detaillé par l'enseignement aux differents niveaux" icon="tableau"/>
        </Link>) 
        :
        <ChoiceCard title="Tableau detaillé par l'enseignement aux differents niveaux" icon="tableau" onClick={() => handleTableauDetailléClick()}/>
        }
    </Box>
    );
}