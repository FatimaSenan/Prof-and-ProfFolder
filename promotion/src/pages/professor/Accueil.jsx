import React from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Navbar from '../../components/Professor/Navbar';
import Sidenav from '../../components/Professor/Sidenav';
import TreeView from '../../components/Treeview';
import ChoiceCardsContainer from '../../components/Professor/Menu/ChoiceCardsContainer';

import { useState , useEffect} from 'react';
import axios from 'axios';
function Accueil() {
  const [professorName, setProfessorName] = useState({firstname: '', lastname: '',});
  
  
  useEffect(() => {
    const fetchProfessorName = async () => {
        try {
            const token = localStorage.getItem('token');
            const response = await axios.get('http://localhost:9005/professor/profile', {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            const data = response.data;
            setProfessorName({
                firstname: data.firstname,
                lastname: data.lastname
                
            });
        } catch (error) {
            console.error('Erreur lors de la récupération des informations du professeur:', error);
            
        }
    };
    fetchProfessorName(); 
  }, []);

  
  return (
    <>
      <Navbar />
      <Box height={30} />
      <Box sx={{ marginTop: '70px', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <Typography variant="h7" gutterBottom sx={{ color: '#404040', fontWeight: 'bold' }}> {`Bonjour ${professorName.firstname} ${professorName.lastname}`}👋🏽</Typography>
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
