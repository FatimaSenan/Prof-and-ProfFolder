import React from 'react'
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Navbar from '../components/Navbar';
import Sidenav from '../components/Sidenav';

function Accueil() {
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
      <h1>Accueil</h1>

      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        
        
      </Box>

      
    </Box>
   
    </>
    
  )
}

export default Accueil;