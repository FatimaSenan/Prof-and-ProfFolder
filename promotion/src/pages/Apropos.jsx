import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';

function Apropos() {
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
      <h1>A Propos</h1>

      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        
        
      </Box>

      
    </Box>
   
    </>
  )
}

export default Apropos;