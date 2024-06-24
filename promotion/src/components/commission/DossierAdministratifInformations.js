import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import PictureAsPdfIcon from '@mui/icons-material/PictureAsPdf';
import { useState, useEffect} from 'react';


import { useLocation, useNavigate } from 'react-router-dom';

import {useTheme} from '@mui/material/styles';

import '@react-pdf-viewer/core/lib/styles/index.css';

import Box from '@mui/material/Box';
import axios from 'axios';

import NavbarAdministration from '../administration/NavbarAdministration';
import Alert from '@mui/material/Alert';



export default function DossierAdministratifInformations () {
  const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
      
    },
    [`&.${tableCellClasses.body}`]: {
      fontSize: 14,
    },
    
  }));
  
  const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
    },
    // hide last border
    '&:last-child td, &:last-child th': {
      border: 0,
    },
  }));
  
    const location = useLocation();
    const {prof} = location.state; 
   
    
    const theme = useTheme();
    const navigate = useNavigate();
    const [professorFolder, setProfessorFolder] = useState({});
    const filteredProfessorFolder = { ...professorFolder };
   
        delete filteredProfessorFolder.folder_id;

        const keyMapping = {
            civility: 'Civilité',
            nom: 'Nom',
            prenom: 'Prenom',
            drpp: 'DRPP',
            cne: 'CNE',
            email: 'Email',
            birthDate: 'Date de naissance',
            phone: 'Téléphone',
            profile: 'Profile',
            speciality: 'Spécialité',
            establishment: 'Etablissement',
            phdType: 'Type de doctorat',
            equivalence: 'Equivalence',
            cv: 'Curriculum Viate(CV)',
            applicationDemande: 'Equivalence(Bulletin Officiel)',
            phdDiplome: 'Diplome de Doctorat',
            habilitationDiplome: 'Diplome d\'Habilitation',
            arretNomination: 'Arret de Nomination',
            attestation: 'Attestation'
          
          };


   const handleViewPdf = async (namePdf) => {
    try{
        let response;
        if(namePdf ==="equivalence"){
            response = await axios.get('http://localhost:9005/commission/get-equivalence', {
                responseType: 'blob',
                params: {id: professorFolder.folder_id , userEmail: prof.email },
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token'),
              },
            });
        }
        else if(namePdf ==="cv"){
            response = await axios.get('http://localhost:9005/commission/get-cv', {
                responseType: 'blob',
                params: {id: professorFolder.folder_id , userEmail: prof.email },
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token'),
              },
            });
        }else if (namePdf === "applicationDemande"){
            response = await axios.get('http://localhost:9005/commission/get-application-demande', {
                responseType: 'blob',
                params: {id: professorFolder.folder_id, userEmail: prof.email},
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token'),
              },
            });
        }else if(namePdf === "phdDiplome"){
            response = await axios.get('http://localhost:9005/commission/get-phd-diplome', {
                responseType: 'blob',
                params: { id: professorFolder.folder_id, userEmail: prof.email},
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token'),
              },
            });
        }else if(namePdf === "habilitationDiplome"){
            response = await axios.get('http://localhost:9005/commission/get-habilitation-diplome', {
                responseType: 'blob',
                params: { id: professorFolder.folder_id, userEmail: prof.email},
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token'),
              },
            });
        }else if(namePdf === "arretNomination"){
            response = await axios.get('http://localhost:9005/commission/get-arret-nomination', {
                responseType: 'blob',
                params: { id: professorFolder.folder_id, userEmail: prof.email},
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token'),
              },
            });
        }else if(namePdf === "attestation"){
            response = await axios.get('http://localhost:9005/commission/get-attestation', {
                responseType: 'blob',
                params: { id: professorFolder.folder_id, userEmail: prof.email},
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token'),
              },
            });
        }
        const fileURL = window.URL.createObjectURL(new Blob([response.data], { type: 'application/pdf' }));
          window.open(fileURL);

        } catch (error) {
            console.error('Error fetching PDF: ', error);
          }

   }
  
   
  useEffect(() => {
    const getDossierAdministratif= async () => {
      try {
        const response = await axios.get('http://localhost:9005/commission/get-professor-folder', {
          params: { userEmail: prof.email },
          headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token'),
          },
        });
        const extractedData = response.data;
        setProfessorFolder(extractedData); 
      } catch (error) {
        console.error('Error fetching annexe 2: ', error);
      }
    };

    getDossierAdministratif();
  }, [prof.email]);   
          
    return (
      <>
      
        <NavbarAdministration/>
      <Box height={30}/>
      <Box sx={{display: 'flex'}}>
      
        
       <Box component="main" sx={{flexGrow: 1, p:6}} >
         <Box component="main" sx={{flexGrow: 1, p:6}}>
          <Paper sx={{ width: '100%', overflow: 'hidden' }}>
        
        <TableContainer component={Paper}>
     <Table sx={{ minWidth: 700 }} aria-label="customized table">
       <TableHead>
         <TableRow sx={{backgroundColor: '#ecd5d0'}}>
             <TableCell align="center" colSpan={2} sx={{fontWeight: 'bold', color: '#404040'}}>
                <StyledTableCell align="center" colSpan={2} style={{backgroundColor: "transparent", color: "#404040", fontWeight: "bold"}}>
                 Dossier administratif de l'enseignant de l'enseignant {prof.firstname} {prof.lastname}
                </StyledTableCell>
             </TableCell>
         </TableRow>
       </TableHead>
       <TableBody>
         {Object.entries(filteredProfessorFolder).map(([key, value]) => (
           <StyledTableRow key={key}>
             <StyledTableCell component="th" scope="row">
             {keyMapping[key] || key}
             </StyledTableCell>
             <StyledTableCell align="right"> 
             
             {key === "equivalence" || key==="cv" || key==="applicationDemande" || key==="phdDiplome" || key ==="habilitationDiplome" || key==="arretNomination" || key==="attestation" ? <PictureAsPdfIcon color='#404040' style={{cursor: 'pointer'}} onClick={() => handleViewPdf(key)} />: value }
             </StyledTableCell>
            
           </StyledTableRow>
         ))}
       </TableBody>
     </Table>
   </TableContainer>
  

     </Paper>
     
            </Box>
         
          
        </Box>

        
      
      </Box>
      </>
        
    );
}