import * as React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useState } from 'react';
import PictureAsPdfIcon from '@mui/icons-material/PictureAsPdf';
import { Modal, keyframes } from '@mui/material';
import PDFModal from './PDFModal';
import { useLocation } from 'react-router-dom';
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

    console.log(activity);
   
      const rows = [
        {name: 'info1',data: 'data1' },
        {name: 'info2',data: 'data2' },
        {name: 'info3',data: 'data3' },
        {name: 'info4',data: 'data4' },
        {name: 'info5',data: '../../../public/dummy.pdf' }

      ];
      
      const [modalIsOpen, setModalIsOpen] = useState(false);
      const [pdfUrl, setPdfUrl] = useState('');

      const openModal = (url) => {
        setPdfUrl(url)
        setModalIsOpen(true);
      };
    
      const closeModal = () => {
        setModalIsOpen(false);
        setPdfUrl('');
      };
   
  
    return (
        <Paper sx={{ width: '100%', overflow: 'hidden' }}>
         <TableContainer component={Paper}>
      <Table sx={{ minWidth: 700 }} aria-label="customized table">
        <TableHead>
          <TableRow sx={{backgroundColor: '#D9ABA0'}}>
              <TableCell align="center" colSpan={2} sx={{fontWeight: 'bold', color: '#404040'}}>
                 Activity name
              </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {Object.entries(activity).map(([key, value]) => (
            <StyledTableRow key={key}>
              <StyledTableCell component="th" scope="row">
                {key}
              </StyledTableCell>
              <StyledTableCell align="right"> 
              {/* Conditionally render the icon if data is a PDF */}
                  {/*value.endsWith('.pdf') ? <PictureAsPdfIcon color='#404040' style={{cursor: 'pointer'}} onClick={() => openModal(value)}/> : value*/}
                  {value}
              </StyledTableCell>
             
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    <PDFModal isOpen={modalIsOpen} closeModal={closeModal} pdfUrl={pdfUrl}/>

      </Paper>
    );
}