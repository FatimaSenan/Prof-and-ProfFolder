import React from 'react';
import { Box } from '@mui/material';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';
import StepperCustom from '../components/StepperCustom';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import ChoiceCardsContainer from '../components/Menu/ChoiceCardsContainer';
import Typography from '@mui/material/Typography';

// Define your theme
const theme = createTheme();

const nom = "NOM";
const prenom = "Prènom";
function Deconnexion() {
  return (
    <>
      <Navbar />
      <Box height={30} />
      <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <Box sx={{ width: '100%', display: 'flex', justifyContent: 'center', marginTop: '60px' }}>
          <Typography variant="h5" gutterBottom sx={{ color: '#0D0D0D' }}>{`Bonjour Mr ${nom} ${prenom},`}</Typography>
        </Box>
        <Box sx={{ width: '100%', display: 'flex', justifyContent: 'center' }}>
          <ChoiceCardsContainer sx={{ width: '80%', height: '100%', marginTop: '20px' }} />
        </Box>
        <Box sx={{ width: '100%', display: 'flex', justifyContent: 'center', marginTop: '10px' }}>
          <Sidenav />
        </Box>
      </Box>
    </>
  );
}

export default Deconnexion;
