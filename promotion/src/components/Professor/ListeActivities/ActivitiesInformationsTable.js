import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useState, useEffect } from 'react';
import PictureAsPdfIcon from '@mui/icons-material/PictureAsPdf';
import { Modal, keyframes } from '@mui/material';
import PDFModal from './PDFModal';
import { useLocation } from 'react-router-dom';
import { Viewer, Worker } from '@react-pdf-viewer/core';
import '@react-pdf-viewer/core/lib/styles/index.css';
import { pdfjs } from 'react-pdf';
import Navbar from '../../Navbar';
import Sidenav from '../../Sidenav';
import Box from '@mui/material/Box';

pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.min.js`;

export default function ActivitiesInformationTable () {
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
    const {activity} = location.state;
    const [pdfURL, setPdfURL] = useState('');

    console.log(activity);
   
      
     

      
      const filteredActivity = { ...activity };
      delete filteredActivity.user
      delete filteredActivity.id;
      delete filteredActivity.activityPoints;
      delete filteredActivity.activityName;

      
      useEffect(() => {
        // Convert bytes to Base64 string
        if (activity.justification && activity.justification.length > 0) {
          const blob = new Blob([activity.justification],
            { type: 'application/pdf' });
        const url = URL.createObjectURL(blob);
        setPdfURL(url);
        }
      }, [activity.justification]);

      const handlePdfIconClick = (justification) =>{
        window.open(pdfURL, '_blank');
      }
    return (
      <>
      <Navbar/>
      <Box height={30}/>
      <Box sx={{display: 'flex'}}>
        <Sidenav/>
        <Box component="main" sx={{flexGrow: 1, p:6}}>
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
                  {key==="justification" ? <PictureAsPdfIcon color='#404040' style={{cursor: 'pointer'}} onClick={() => handlePdfIconClick(filteredActivity.justification)}/>: value }
                  {/*value*/}
              </StyledTableCell>
             
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
   

      </Paper>
        </Box>
      </Box>
      </>
        
    );
}