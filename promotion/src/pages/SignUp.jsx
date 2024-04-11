import React from 'react';
import Box from '@mui/material/Box';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';
import SignInUp from '../components/SignInUp';
function SignUp() {
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
      <h1>SignUp</h1>

      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        
        <SignInUp/>
      </Box>

      
    </Box>
   
    </>
  )
}

export default Parametres;