import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../components/Professor/Sidenav';
import Navbar from '../components/Professor/Navbar';
import CollapsibleTable from '../components/Professor/ListeActivities/CollapsibleTable';
import ActivityService from '../components/Professor/service/ActivityService';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { enseignementTypes } from '../Activities/activitésEnseignementTypes';

function ActiviteEnseignement() {
  
 
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



  
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
  
    <Box component="main" sx={{ flexGrow: 1, p: 6 }}>
        <CollapsibleTable types={enseignementTypes} activityType="Activités d'enseignement" activities={activities}/>
        
      </Box>
  
        
      </Box>
   
    </>
  )
}

export default ActiviteEnseignement;