import { Box } from "@mui/material";
import ChoiceCard from "./ChoiceCard";
import './choiceCardsContainer.css'


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
        
        <ChoiceCard title="Dossier Administratif" icon="dossier"/>
        <ChoiceCard title="Grille d'evaluation" icon="evaluation"/>
        <ChoiceCard title="Formulaire d'inscription" icon="inscription"/>
        <ChoiceCard title="Tableau detaillé par l'enseignement aux differents niveaux" icon="tableau"/>
    </Box>
    );
}