import React from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import './Administration.css'; 
import NavbarAdministration from './NavbarAdministration';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
    fontWeight: 200,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
  '&.separator': {
    borderRight: '1px solid #C37380 !important', // Style pour la ligne de séparation
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: theme.palette.action.hover,
  },
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));

function createData(name, points) {
  return { name, points };
}

const rows = [
  createData('John Doe', 85),
  createData('Jane Smith', 92),
  createData('Michael Johnson', 78),
  createData('Emily Williams', 88),
  createData('David Brown', 95),
];

export default function Administration() {
  return (
    <>
    <NavbarAdministration/>
    <TableContainer component={Paper} className="custom-table-container" style={{ height: '100vh', width: '100vw', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <Table sx={{ minWidth: 700 }} aria-label="customized table" style={{marginLeft: '50px', marginRight: '50px'}}>
        <TableHead>
          <TableRow>
            <StyledTableCell className="separator" style={{ color: 'white', fontSize: '20px', marginBottom: '30px', backgroundColor: '#C38370' }}>Enseignants</StyledTableCell>
            <StyledTableCell align="right" style={{ color: 'white', fontSize: '20px', marginBottom: '30px', backgroundColor: '#C38370' }}>Points</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row, index) => (
            <StyledTableRow key={row.name}>
              <StyledTableCell component="th" scope="row">
                {row.name}
              </StyledTableCell>
              <StyledTableCell align="right">{row.points}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </>
  );
}