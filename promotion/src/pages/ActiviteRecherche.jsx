import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';
import CollapsibleTable from '../components/Professor/ListeActivities/CollapsibleTable';

function ActiviteRecherche() {
  const types = [
    {
      name: 'La production scientifique',
      subTypes: [
        { 
          name: 'Articles scientifiques publiés dans des revues indexées internationales, ou des actes de congrès internationaux ou nationaux ou à comité de lecture internationaux ou nationaux',
          activities: [
            { name: "Publications dans des revues scientifiques internationales à comité de lecture ISSN tel qu'il est défini dans la liste officielle du CNRST)" },
            { name: "Publications dans des revues scientifiques nationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)"}
          ]
        },
        { 
          name: 'Ouvrages de recherche',
          activities: [
            { name: "Ouvrage spécialisé ISBN et publié par une maison d'édition" },
            { name: "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN " }
          ]
        },
        { 
            name: 'Communications dans des congrès ou des conférences (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu\'une seule fois)',
            activities: [
              { name: "Ouvrage spécialisé ISBN et publié par une maison d'édition" },
              { name: "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN " }
            ]
        },
        { 
            name: 'Communications dans des congrès ou des conférences (non publiés) (Les communications ne peuvent être comptabilisées qu\'une seule fois)',
            activities: [
              { name: "Ouvrage spécialisé ISBN et publié par une maison d'édition" },
              { name: "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN " }
            ]
        }
      ]
    },
    {
      name:  " L'encadrement scientifique" ,
      subTypes: [
        { 
          name: 'Encadrement des thèses de doctorat (Attest,ation délivrée par le chef d\'établissement)',
          activities: [
            { name: 'Activity 1' },
            { name: 'Activity 2' }
          ]
        },
        { 
          name: 'Encadrement des mémoires de Master (Attestation délivrée par le chef d\'établissement',
          activities: [
            { name: 'Activity 3' },
            { name: 'Activity 4' }
          ]
        },
        { 
            name: 'Participation comme président ou rapporteur ou membre du jury de thèse de doctorat ou d\'habilitation (Attestation délivrée par le chef d\'établissement)',
            activities: [
              { name: 'Activity 3' },
              { name: 'Activity 4' }
            ]
          }
      ]
    },
    {
        name:  "Les responsabilités scientifiques" ,
        subTypes: [
          { 
            name: 'Responsable ou membre d\'une structure de recherche (au moins une année)',
            activities: [
              { name: 'Activity 1' },
              { name: 'Activity 2' }
            ]
          },
          { 
            name: 'Projets ou contrats de recherche (Attestation délivrée par le chef d\'établissement)',
            activities: [
              { name: 'Activity 3' },
              { name: 'Activity 4' }
            ]
          },
          { 
              name: 'Les activités d\'expertises et d\'évaluations scientifiques nationales et internationales (correctement justifiée par une attestation ou un rapport signé par le chef d\'établissement) ',
              activities: [
                { name: 'Activity 3' },
                { name: 'Activity 4' }
              ]
            }
        ]
      },
      {
        name:  "Rayonnement-Ouverture-Innovation-Valorisation" ,
        subTypes: [
          { 
            name: 'Animation des structures d\'interaction avec l\'environnement socio-économique et organisation des manifestations scientifiques (le nom du candidat organisateur doit figurer sur le dépliant correspondant, à fournir)',
            activities: [
              { name: 'Activity 1' },
              { name: 'Activity 2' }
            ]
          },
          { 
            name: 'Expertise et valorisation d\'actions au profit des milieux socio-économiques (correctement justifiée par une attestation ou un rapport d\'expertise signé et cacheté par le chef d\'établissement)',
            activities: [
              { name: 'Activity 3' },
              { name: 'Activity 4' }
            ]
          },
          { 
              name: 'Les activités d\'expertises et d\'évaluations scientifiques nationales et internationales (correctement justifiée par une attestation ou un rapport signé par le chef d\'établissement) ',
              activities: [
                { name: 'Activity 3' },
                { name: 'Activity 4' }
              ]
            }
        ]
      }
  ];

  
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
  
    <Box component="main" sx={{ flexGrow: 1, p: 6 }}>
        <CollapsibleTable types={types} activityType="Activités de recherche"/>
        
      </Box>
  
        
      </Box>
   
    </>
  )
}

export default ActiviteRecherche;