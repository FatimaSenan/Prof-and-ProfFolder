import React, { useEffect, useState } from 'react';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import axios from 'axios';

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

const Administration = () => {
  const [professors, setProfessors] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:9005/admincommission/get-professors', {
      headers: {
        'Authorization': 'Bearer ' + localStorage.getItem('token'),
      },
    })
    .then(response => {
      // Response.data should be an array of professor objects
      const professorsData = response.data;
      // Map over each professor to fetch total points
      Promise.all(professorsData.map(professor => {
        return axios.get(`http://localhost:9005/administration/total-points`, {
          params: { email: professor.email },
          headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token'),
          },
        })
          .then(pointsResponse => {
            // Add total points to each professor object
            professor.points = pointsResponse.data;
            return professor;
          });
      }))
      .then(professorsWithPoints => {
        // Set state with professors array including points
        setProfessors(professorsWithPoints);
      })
      .catch(error => {
        console.error('Error fetching total points:', error);
      });
    })
    .catch(error => {
      console.error('Error fetching professors:', error);
    });
  }, []);

  return (
    <TableContainer component={Paper} className="custom-table-container" style={{ height: '100vh', width: '100vw', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <Table sx={{ minWidth: 700 }} aria-label="customized table" style={{marginLeft: '50px', marginRight: '50px'}}>
        <TableHead>
          <TableRow>
            <StyledTableCell className="separator" style={{ color: 'white', fontSize: '20px', marginBottom: '30px', backgroundColor: '#C38370' }}>Enseignants</StyledTableCell>
            <StyledTableCell align="right" style={{ color: 'white', fontSize: '20px', marginBottom: '30px', backgroundColor: '#C38370' }}>Points</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {professors.map((professor, index) => (
            <StyledTableRow key={index}>
              <StyledTableCell component="th" scope="row">
                {`${professor.firstname} ${professor.lastname}`}
              </StyledTableCell>
              <StyledTableCell align="right">{professor.points}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default Administration;
