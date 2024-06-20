import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../components/Professor/Sidenav';
import Navbar from '../components/Professor/Navbar';
import CollapsibleTable from '../components/Professor/ListeActivities/CollapsibleTable';
import ActivityService from '../components/Professor/service/ActivityService';
import axios from 'axios';
import { useState, useEffect } from 'react';

function ActiviteEnseignement() {
  const types = [
    {
      name: 'Les activités pédagogiques',
      subTypes: [
        { 
          name: 'Publication d\'ouvrages en relation avec le domaine de l\'enseignement',
          activities: [
            { name: "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)" },
            { name: "Manuel ( exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)"}
          ]
        },
        { 
          name: 'Tous supports et procédés sélectionnés et traités à des fins d\'utilisation didactique (Tous les documents doivent être visés par le chef de l\'établissement)',
          activities: [
            { name: "Polycopiés pédagogiques" },
            { name: "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse" },
            {name: "Montages expérimentaux"},
            {name: "Préparation de sorties de terrain"}
          ]
        },
        { 
            name: 'Supports NTIC',
            activities: [
              { name: "Supports" },
              { name: "Didacticiels" },
              {name: "Page web à caractère pédagogique"},
              {name: "MOOC : Production de contenus en ligne"}
            ]
          },
          
      ]
    },
    {
      name:  "L\'encadrement pédagogique" ,
      subTypes: [
        { 
          name: 'Encadrement des projets et des mémoires de fin d\'études (Tous les documents doivent être visés par le chef de l\'établissement',
          activities: [
            { name: 'Mémoire de PFE' }
          ]
        },
        { 
          name: 'Encadrement de stages ou visites de terrain pour tous les cycles de formation et de recherche. (Copie de l\'ordre de mission signé par le chef d\'établissement)',
          activities: [
            { name: 'Rapport de stage de visite ou de terrain' }
          ]
        },
        { 
            name: 'Encadrement des ressources humaines',
            activities: [
              { name: 'Formation de formateurs ou du Personnel administratif ou technique' }
            ]
          }
      ]
    },
    {
        name:  "Les responsabilités pédagogiques" ,
        subTypes: [
          { 
            name: 'Les responsabilités pédagogiques (Attestation du chef d\'établissement)',
            activities: [
              { name: 'Coordonnateur d\'une filière' },
              { name: 'Coordonnateur d\'un module (ou deux au maximum )' },
              {name: "Chef de département"}
            ]
          },
          { 
            name: 'Autres responsabilités(Attestation du chef d\'établissement)',
            activities: [
              { name: 'Vice-doyen ( non cumulable avec commission permanente)' },
              { name: 'Membre élu du conseil d\'établissement' },
              {name: 'Membre d\'une commission permanente de l\'établissement'},
              {name: 'Membre du conseil de coordination'},
              {name: 'Membre d\'une commission permanente du conseil de coordination'},
              {name: 'Membre d\'une commission ad hoc'}
            ]
          }
        ]
      }
  ];
 
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
        <CollapsibleTable types={types} activityType="Activités d'enseignement" activities={activities}/>
        
      </Box>
  
        
      </Box>
   
    </>
  )
}

export default ActiviteEnseignement;