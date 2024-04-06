import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';
import LinearStepper from '../components/LinearStepper'
import { CssBaseline, Container, Paper } from "@material-ui/core";


function Apropos() {
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
  
      <CssBaseline />
      <Container component={Box} p={8}>
        <Paper component={Box} p={3}>
          <LinearStepper />
        </Paper>
      </Container>
  
        
      </Box>
   
    </>
  )
}

export default Apropos;