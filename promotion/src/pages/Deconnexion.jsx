import React from 'react';
import { Box } from '@mui/material';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';
import ChoiceCardsContainer from '../components/Menu/ChoiceCardsContainer';
import Typography from '@mui/material/Typography';
import UserService from '../components/Professor/service/UsersService';



function Deconnexion() {

  


  return (
    <>
      <Navbar />
      <Box height={30} />
      <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <Box sx={{ width: '100%', display: 'flex', justifyContent: 'center', marginTop: '60px' }}>
          
        </Box>
        
        <Box sx={{ width: '100%', display: 'flex', justifyContent: 'center', marginTop: '10px' }}>
          <Sidenav />
          
        </Box>
      </Box>
    </>
  );
}

export default Deconnexion;
