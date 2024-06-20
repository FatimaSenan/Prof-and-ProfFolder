import React from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Navbar from '../components/Navbar';
import Sidenav from '../components/Sidenav';
import TreeView from '../components/Treeview';
import ChoiceCardsContainer from '../components/Professor/Menu/ChoiceCardsContainer';
import UserService from '../components/Professor/service/UsersService';
import { useState } from 'react';

function Accueil() {
  const [profName, setProfName] = useState('');
  // Supposons que vous avez les informations du nom et prénom de l'utilisateur
  const nom = "NOM";
  const prenom = "Prènom";
  const getProfName = async() =>{
    try {
      const token = localStorage.getItem('token');
      const userData = await UserService.getYourProfile();
      const { nom, prenom } = userData;
      setProfName(`${prenom} ${nom}`);
    } catch (error) {
      console.error('Failed to fetch profile data:', error);
    }
  }
  
  return (
    <>
      <Navbar />
      <Box height={30} />
      <Box sx={{ marginTop: '70px', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <Typography variant="h7" gutterBottom sx={{ color: '#404040', fontWeight: 'bold' }}>{profName}</Typography>
        <Box sx={{ display: 'flex', justifyContent: 'center', width: '100%' }}>
          <Sidenav />
          <Box sx={{ marginLeft: 'auto', marginRight: 'auto', width: '80%', height: '500px', p: 3 }}>
            <ChoiceCardsContainer/>
          </Box>
        </Box>
      </Box>
    </>
  );
}

export default Accueil;
