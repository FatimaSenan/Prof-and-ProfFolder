
import * as React from 'react';
import Typography from '@mui/material/Typography';
import AssignmentIndIcon from '@mui/icons-material/AssignmentInd';
import './choiceCard.css';
import Paper from '@mui/material/Paper';
import { styled } from '@mui/material/styles';
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



export default function ChoiceCard({title, icon, onClick}) {
    const [iconDossier, setIconDossier] = useState(false);
    const [iconEvaluation, setIconEvaluation] = useState(false);
    const [iconInscription, setIconInscription] = useState(false);
    const [iconTableau, setIconTableau] = useState(false);
    useEffect(() => {
      if (icon === 'dossier')
        setIconDossier(true);
      else if (icon === 'evaluation')
        setIconEvaluation(true);
      else if (icon === 'inscription')
        setIconInscription(true);
      else if (icon === 'tableau')
        setIconTableau(true);
    }, [icon]); // Include icon as a dependency
    
  return (
  // <Box className="choice-box" sx={{ maxWidth: 180 , boxShadow: '1px 1px 4px #404040', borderRadius: '7px'}} >
    <DemoPaper variant="elevation" className='choice-box ' onClick={onClick}>
        {iconDossier && <AssignmentIndIcon sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        {iconEvaluation && <Grading sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        {iconInscription && <AssignmentIcon sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        {iconTableau && <TableChartIcon sx={{fontSize: 40, paddingBottom: '1rem'}} style={{color: "#A66253"}}/>}
        <Typography sx={{ fontSize: 14 , fontWeight: 'bold'}} color="#0D0D0D" gutterBottom>
        {title}
      </Typography>
    </DemoPaper>
      //<Card variant="outlined">{card}</Card>
    //</Box>
  );
}