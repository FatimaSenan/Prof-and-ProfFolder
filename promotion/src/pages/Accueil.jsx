import React from 'react'
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Navbar from '../components/Navbar';
import Sidenav from '../components/Sidenav';
import ChoiceCardsContainer from '../components/Menu/ChoiceCardsContainer';

function Accueil() {
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
      

      <Box component="main" sx={{ flexGrow: 1, p: 3 , display: 'flex',flexDirection: 'column', justifyContent: 'center', alignItems: 'center'}}>
        
        <ChoiceCardsContainer/>
      </Box>

      
    </Box>
   
    </>
    
  )
}

export default Accueil;