import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useState, useEffect} from 'react';


import { useLocation, useNavigate } from 'react-router-dom';

import {useTheme} from '@mui/material/styles';

import '@react-pdf-viewer/core/lib/styles/index.css';

import Box from '@mui/material/Box';
import axios from 'axios';

import NavbarAdministration from '../administration/NavbarAdministration';
import Alert from '@mui/material/Alert';


const StyledLink = styled('div')({
    textDecoration: 'underline',
    color: '#404040',
    cursor: 'pointer',
    
  });
export default function Annexe3Informations () {
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
   
    const [pdfURL, setPdfURL] = useState('');
    const theme = useTheme();
    const navigate = useNavigate();
    const [annexe3, setAnnexe3] = useState({});

    console.log(prof);
    
   
   

    const handleDownloadExcel = async () => {
        try{
           
            
               const response = await axios.get('http://localhost:9005/annexe3/get-annexe3', {
                    responseType: 'blob',
                    params: {userEmail: prof.email},
                    headers: {
                      'Authorization': 'Bearer ' + localStorage.getItem('token'),
                      
                  },
                });
                const blob = new Blob([response.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });

                // Use FileSaver.js or similar library to trigger download
                const downloadUrl = window.URL.createObjectURL(blob);
                const link = document.createElement('a');
                link.href = downloadUrl;
                link.download = 'annexe3.xlsx'; // Adjust filename as needed
                link.click();
    
            } catch (error) {
                console.error('Error fetching Excel file: ', error);
              }
    
       }
   
  
   
  
 
          
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
                 Tableau detaillé de l'enseignant {prof.firstname} {prof.lastname}
                </StyledTableCell>
             </TableCell>
         </TableRow>
       </TableHead>
       <TableBody>
         
           <StyledTableRow key={annexe3.id}>
             <StyledTableCell component="th" scope="row">
                Document
             </StyledTableCell>
             <StyledTableCell align="right"> 
             
             <StyledLink onClick={handleDownloadExcel}>
                  Télécharger le document
            </StyledLink>
             </StyledTableCell>
            
           </StyledTableRow>
       
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