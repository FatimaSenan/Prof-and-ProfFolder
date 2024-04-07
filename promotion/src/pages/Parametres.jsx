import React from 'react';
import Box from '@mui/material/Box';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';
import SignInUp from '../components/SignInUp/SignInUp';
function Parametres() {
  return (
    <>

      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <SignInUp/>
        
      </Box>

      

   
    </>
  )
}

export default Parametres;