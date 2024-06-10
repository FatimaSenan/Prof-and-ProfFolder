import React from 'react';
import Box from '@mui/material/Box';
import Navbar from '../components/Navbar';
import Sidenav from '../components/Sidenav';
import ProfessorForm from '../components/Professor/DossierAdministratif/ProfessorForm';
function DossierAdministratif() {
  

  return (
    
    <>
    <Navbar/>
    <Box height={30}/>
        <Box sx={{display:'flex'}}>
        <Sidenav/>
        <Box component="main" sx={{ flexGrow: 1, p: 1 ,width:'100%'}}>
            <ProfessorForm/>
        </Box>
    </Box>
   
    </>
  )
}

export default DossierAdministratif;