import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../../components/Professor/Sidenav';
import Navbar from '../../components/Professor/Navbar';
import LinearStepper from '../../components/Professor/Forms/LinearStepper'
import { CssBaseline, Container, Paper } from "@material-ui/core";


function StepperRecherche() {
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Box sx={{ display: 'flex', justifyContent: 'center', width: '100%' }}>

    <Sidenav/>
      
  
      
      <Container component={Box} p={8}>
        <Paper component={Box} p={3}>
          <LinearStepper type="recherche"/>
        </Paper>
      </Container>
  
        
      </Box>
      </Box>
   
    </>
  )
}

export default StepperRecherche;