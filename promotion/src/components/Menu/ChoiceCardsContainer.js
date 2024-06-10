import { Box } from "@mui/material";
import ChoiceCard from "./ChoiceCard";
import './choiceCardsContainer.css';
import { Link } from 'react-router-dom';



export default function ChoiceCardsContainer() {
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
        <Link to="/dossier_administratif" style={{ textDecoration: 'none' }}>
           <ChoiceCard title="Dossier Administratif" icon="dossier"/>
        </Link>
        <Link to="/menu_grille" style={{ textDecoration: 'none' }}>
           <ChoiceCard title="Grille d'évaluation" icon="evaluation" />
        </Link>
        <ChoiceCard title="Formulaire d'inscription" icon="inscription"/>
        <ChoiceCard title="Tableau detaillé par l'enseignement aux differents niveaux" icon="tableau"/>
    </Box>
    );
}