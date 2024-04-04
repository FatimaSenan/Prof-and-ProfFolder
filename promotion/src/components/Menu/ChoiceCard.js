
import * as React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import AssignmentIndIcon from '@mui/icons-material/AssignmentInd';
import './choiceCard.css';
import Stack from '@mui/material/Stack';
import Paper from '@mui/material/Paper';
import { styled } from '@mui/material/styles';
import GradingIcon from '@mui/icons-material/Grading';
import { useState , useEffect} from 'react';
import { Grading } from '@mui/icons-material';

import TableChartIcon from '@mui/icons-material/TableChart';
import AssignmentIcon from '@mui/icons-material/Assignment';

const DemoPaper = styled(Paper)(({ theme }) => ({
    width: 165,
    height: 165,
    padding: theme.spacing(2),
    ...theme.typography.body2,
    textAlign: 'center',
    boxShadow: '0.8px 0.8px 4px #404040'
  }));


/*const card = (
  <React.Fragment>
    <CardContent sx={{display: 'flex', justifyContent: 'spaceBetween', flexDirection: 'column', alignItems: 'center', marginBottom: '16px'}}>
        <AssignmentIndIcon sx={{fontSize: 36, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>
      <Typography sx={{ fontSize: 14 , fontWeight: 'bold'}} color="#A66253" gutterBottom>
        Dossier Administratif
      </Typography>
      
    </CardContent>
    
  </React.Fragment>
);*/

export default function ChoiceCard({title, icon}) {
    const [iconDossier, setIconDossier] = useState(false);
    const [iconEvaluation, setIconEvaluation] = useState(false);
    const [iconInscription, setIconInscription] = useState(false);
    const [iconTableau, setIconTableau] = useState(false);
    useEffect(()=>
    { if(icon === 'dossier')
        setIconDossier(true);
      else if(icon === 'evaluation')
        setIconEvaluation(true);
      else if(icon === 'inscription')
        setIconInscription(true);
        else if(icon === 'tableau')
        setIconTableau(true);
       }
      );
  return (
  // <Box className="choice-box" sx={{ maxWidth: 180 , boxShadow: '1px 1px 4px #404040', borderRadius: '7px'}} >
    <DemoPaper variant="elevation" className='choice-box '>
        {iconDossier && <AssignmentIndIcon sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        {iconEvaluation && <Grading sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        {iconInscription && <AssignmentIcon sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        {iconTableau && <TableChartIcon sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        <Typography sx={{ fontSize: 14 , fontWeight: 'bold'}} color="#A66253" gutterBottom>
        {title}
      </Typography>
    </DemoPaper>
      //<Card variant="outlined">{card}</Card>
    //</Box>
  );
}