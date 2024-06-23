import React from 'react';
import Box from '@mui/material/Box';
import Sidenav from '../../components/Professor/Sidenav';
import Navbar from '../../components/Professor/Navbar';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import Typeactivity from '../../components/Typeactivity';

// Define your theme
const theme = createTheme();

function Listeactivities() {
  return (
    <ThemeProvider theme={theme}>
      <>
        <Navbar />
        <Box height={30} />
        <Box sx={{ display: 'flex', paddingTop: '80px', paddingLeft:'40px' }}>
          <Sidenav />
          <Box sx={{ textAlign: 'left',color:'#A66253' }}>
            <h3>Grille d'évaluation</h3>
            <Box sx={{ marginLeft: 'auto', marginRight: 'auto', width: '100%', height: '100%', p: 3 }}>
              <Typeactivity />
            </Box>
          </Box>
          <Box component="main" sx={{ flexGrow: 1, p: 3 }} />
        </Box>
      </>
    </ThemeProvider>
  );
}

export default Listeactivities;
