import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../components/Professor/Sidenav';
import Navbar from '../components/Professor/Navbar';
import CollapsibleTable from '../components/Professor/ListeActivities/CollapsibleTable';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { act } from 'react';
import { rechercheTypes } from '../Activities/activitésRechercheTypes';

function ActiviteRecherche() {
  
  const [activities, setActivities] = useState([]);
 

  useEffect(() => {
    const fetchData = async () => {
      try {
        const token = localStorage.getItem('token');
        const response = await axios.get('http://localhost:9005/professor/activities/current-user', {
          headers: {
            'Authorization': `Bearer ${token}`
          }
        });
     
       const extractedData = response.data; 
       setActivities(extractedData);
      } catch (error) {
        console.error('Error:', error);
      }
    };

    fetchData();
  }, []);
  console.log(activities);
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
  
    <Box component="main" sx={{ flexGrow: 1, p: 6 }}>
        <CollapsibleTable types={rechercheTypes} activityType="Activités de recherche" activities={activities}/>
        
      </Box>
  
        
      </Box>
   
    </>
  )
}

export default ActiviteRecherche;