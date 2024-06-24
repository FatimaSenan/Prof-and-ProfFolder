
import React from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Navbar from '../../components/Professor/Navbar';
import Sidenav from '../../components/Professor/Sidenav';
import TreeView from '../../components/Treeview';
import ChoiceCardsContainer from '../../components/Professor/Menu/ChoiceCardsContainer';

import { useState , useEffect} from 'react';
import axios from 'axios';
import NavbarAdministration from '../administration/NavbarAdministration';
import { useLocation } from 'react-router-dom';
function ProfessorsInformationsMenu() {

    const location = useLocation();
    const {prof} = location.state || {};
  
  

  
  return (
    <>
      <NavbarAdministration />
      <Box height={30} />
      <Box sx={{ marginTop: '70px', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        
        <Box sx={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
          
          <Box sx={{ marginLeft: 'auto', marginRight: 'auto', width: '80%', height: '500px', p: 3 }}>
            <ChoiceCardsContainer userRole="COMMISSION" selectedUser={prof}/>
          </Box>
        </Box>
      </Box>
    </>
  );
}

export default ProfessorsInformationsMenu;
