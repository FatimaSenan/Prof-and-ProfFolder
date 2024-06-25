import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useState} from 'react';
import PictureAsPdfIcon from '@mui/icons-material/PictureAsPdf';

import { useLocation, useNavigate } from 'react-router-dom';

import {useTheme} from '@mui/material/styles';

import '@react-pdf-viewer/core/lib/styles/index.css';
import Navbar from '../Navbar';
import Sidenav from '../Sidenav';
import Box from '@mui/material/Box';
import axios from 'axios';
import Button from '@mui/material/Button';
import NavbarAdministration from '../../administration/NavbarAdministration';
import Alert from '@mui/material/Alert';



export default function ActivitiesInformationTable ({ userRole}) {
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
    const {activity, selectedUser} = location.state;
    const [pdfURL, setPdfURL] = useState('');
    const theme = useTheme();
    const navigate = useNavigate();

    const [alert, setAlert] = useState({open: false, severity: '', message: ''});

    console.log(activity);
   
      
     

      
      const filteredActivity = { ...activity };
      delete filteredActivity.user
      delete filteredActivity.id;
      delete filteredActivity.activityPoints;
      delete filteredActivity.activityName;
      delete filteredActivity.pointsAttribués;
      delete filteredActivity.evaluated;

      
      const handleViewPdf = async (activityName, id) => {
        try {
          let response;
          if(userRole === "PROFESSOR"){
            response = await axios.get('http://localhost:9005/professor/activities/justification', {
              responseType: 'blob',
              params: { activityName: activityName, id: id },
              headers: {
                'Authorization': 'Bearer ' + localStorage.getItem('token'),
            },
          });}else if(userRole === "COMMISSION"){
            response = await axios.get('http://localhost:9005/commission/activities/justification', {
              responseType: 'blob',
              params: { activityName: activityName, id: id, userEmail: selectedUser.email },
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
      };

      const handleValidate = async () => {
        try {
          const response = await axios.patch('http://localhost:9005/commission/activities/validate',{}, {
            params: {
             activityName: activity.activityName,
             id: activity.id
          },
           
            headers: {
              'Authorization': 'Bearer ' + localStorage.getItem('token'),
              'Content-Type': 'application/json', 
            },
          
        });
          console.log('Activité validée !');
          setAlert({open: true, severity: 'success', message: 'Cette activité a été évaluée avec succès!'});
        } catch (error) {
          console.error('Erreur lors de la validation de l\'activité : ', error);
          setAlert({open: true, severity: 'error', message: 'Une erreur est survenue . Veuillez réessayer plus tard'});
        }
      };
      const handleCancel = async() => {
        try {
          const response = await axios.patch('http://localhost:9005/commission/activities/cancel',{}, {
            params: {
             activityName: activity.activityName,
             id: activity.id
          },
           
            headers: {
              'Authorization': 'Bearer ' + localStorage.getItem('token'),
              'Content-Type': 'application/json', 
            },
          
        });
        setAlert({open: true, severity: 'success', message: 'Cette activité a été évaluée avec succès!'});
        console.log('Annulation de la validation de l\'activité');
      } catch (error) {
        console.error('Erreur lors de la validation de l\'activité : ', error);
        setAlert({open: true, severity: 'error', message: 'Une erreur est survenue . Veuillez réessayer plus tard'});
      }
        navigate('/selected-user-activities', {state: {prof: selectedUser}});
      };
     const  handleContinueClick = () => {
        setAlert({open: true, severity: 'success', message: 'Cette activité a été évaluée avec succès!'});
        navigate('/selected-user-activities', {state: {prof: selectedUser}});
      }
    return (
      <>
      
      {userRole=== "PROFESSOR" ? <Navbar/> : <NavbarAdministration/>}
      <Box height={30}/>
      <Box sx={{display: 'flex'}}>
      {userRole=== "PROFESSOR" && <Sidenav />}
        
        {alert.open ? (<Box component="main" sx={{flexGrow: 1, p:6}} >
          <Alert variant="outlined" severity={alert.severity} action={
          <Button color="inherit" size="small" onClick={() => handleContinueClick()}>
            Continuer
          </Button>}>
        {alert.message}</Alert>
        </Box>) : (<Box component="main" sx={{flexGrow: 1, p:6}}>
          <Paper sx={{ width: '100%', overflow: 'hidden' }}>
        
        <TableContainer component={Paper}>
     <Table sx={{ minWidth: 700 }} aria-label="customized table">
       <TableHead>
         <TableRow sx={{backgroundColor: '#ecd5d0'}}>
             <TableCell align="center" colSpan={2} sx={{fontWeight: 'bold', color: '#404040'}}>
                <StyledTableCell align="center" colSpan={2} style={{backgroundColor: "transparent", color: "#404040", fontWeight: "bold"}}>
                {activity.activityName}
                </StyledTableCell>
             </TableCell>
         </TableRow>
       </TableHead>
       <TableBody>
         {Object.entries(filteredActivity).map(([key, value]) => (
           <StyledTableRow key={key}>
             <StyledTableCell component="th" scope="row">
               {key}
             </StyledTableCell>
             <StyledTableCell align="right"> 
             {/* Conditionally render the icon if data is a PDF */}
                 {key==="justification" ? <PictureAsPdfIcon color='#404040' style={{cursor: 'pointer'}} onClick={() => handleViewPdf(activity.activityName, activity.id)}/>: value }
                 {/*value*/}
             </StyledTableCell>
            
           </StyledTableRow>
         ))}
       </TableBody>
     </Table>
   </TableContainer>
  

     </Paper>
     {userRole === 'COMMISSION' && (
            <Box sx={{ mt: 2, textAlign: 'right' }}>
              <Button  color="primary" onClick={handleCancel} sx={{
                        color: '#0D0D0D', // Change text color
                        '&:hover': {
                          backgroundColor: '#ecd5d0', // Change hover background color
                        },
                      }}>
                Annuler
              </Button>
              <Box sx={{ display: 'inline-block', width: 10 }} />
              <Button variant="contained" onClick={handleValidate} sx={{
                  color: theme.palette.getContrastText("#A66253"),
                  backgroundColor: "#A66253",
                  '&:hover': {
                    backgroundColor: "#7F3D30",
                  },
                }}
                >
                Valider
              </Button>
            </Box>
          )}
          
        </Box>
)}
        
      
      </Box>
      </>
        
    );
}