import * as React from 'react';
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import DeleteIcon from '@mui/icons-material/Delete';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';


function Row({subType, activities}) {
  
  const [open, setOpen] = React.useState(false);
  const [filteredActivities, setFilteredActivities] = useState([]);
  const navigate = useNavigate();
  console.log(activities)
  useEffect(()=> {
    const validActivityNames = new Set(subType.activities.map(activity => activity.name));
    const filtered = activities.map(subArray => 
      subArray.filter(activity => validActivityNames.has(activity.activityName))
    );
    setFilteredActivities(filtered);
  },[activities, subType])

  const handleActivityClick = (activity) => {
    navigate('/activite_informations', { state: { activity } });
    console.log(activity);
  
  };
 
  return (
    <React.Fragment>
      <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
        <TableCell>
          <IconButton
            aria-label="expand row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUpIcon sx={{color:"#A66253"}}/> : <KeyboardArrowDownIcon sx={{color:"#A66253"}}/>}
          </IconButton>
        </TableCell>
        <TableCell colSpan={2} align="left">{subType.name}</TableCell>
        <TableCell />
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={4}>
          <Collapse in={open} timeout="auto" unmountOnExit>
            <Box sx={{ margin: 1 }}>
              <Table size="small" aria-label="activity table">
                <TableBody>
                {filteredActivities.map((subArray, subArrayIndex) => (
                    <React.Fragment key={subArrayIndex}>
                      {subArray.map((activity, activityIndex) => (
                        <TableRow key={activityIndex} onClick={() => handleActivityClick(activity)} style={{ cursor: 'pointer' }}>
                          <TableCell component="th" scope="row">{activity.activityName}</TableCell>
                          <TableCell align="right">
                            <IconButton aria-label="delete" color="error">
                              <DeleteIcon />
                            </IconButton>
                          </TableCell>
                        </TableRow>
                      ))}
                    </React.Fragment>
                  ))}
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </React.Fragment>
  );
}

Row.propTypes = {
  subType: PropTypes.object.isRequired,
};

export default function CollapsibleTable({types, activityType,activities}) {
 // const { types } = props;

  return (
    <TableContainer component={Paper} Width="100%">
      <Table aria-label="collapsible table">
        <TableHead>
          <TableRow>
            <TableCell />
            <TableCell align="center" style={{ fontSize: '24px', padding: '20px' }}>{activityType}</TableCell>
            <TableCell />
          </TableRow>
        </TableHead>
        <TableBody>
          {types.map((type, index) => (
            <React.Fragment key={index}>
              <TableRow sx={{ backgroundColor: '#ecd5d0' }}>
                <TableCell />
                <TableCell colSpan={2} align="left"  style={{ fontSize: '18px', padding: '20px' }}>{type.name} </TableCell>
              </TableRow>
              {type.subTypes.map((subType, index) => (
                <Row key={index} subType={subType} activities={activities}/>
              ))}
            </React.Fragment>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

CollapsibleTable.propTypes = {
  types: PropTypes.array.isRequired,
};