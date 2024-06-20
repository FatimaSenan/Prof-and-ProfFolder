import React from 'react'
import Box from '@mui/material/Box';
import NavbarAdministration from '../../components/administration/NavbarAdministration';

import ProfessorsList from '../../components/commission/ProfessorsList';
function ProfessorsTable() {
  

  
  return (
    <>
    <NavbarAdministration/>
    <Box height={30}/>
        <Box sx={{display:'flex', justifyContent: 'center', alignItems: 'center'}}>
        
        <Box component="main" sx={{ flexGrow: 1, p: 6 }}>
            <ProfessorsList/>  
        </Box> 
    </Box>
   
    </>
  )
}

export default ProfessorsTable;