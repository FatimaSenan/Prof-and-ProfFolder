import React, { useState } from 'react';
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
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import VisibilityIcon from '@mui/icons-material/Visibility'; 
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';


// Composant réutilisable pour rendre les lignes des activités
function ActivityRow({subType, activities, selectedUser}) {
 
  const [open, setOpen] = useState(false);
  const [selectedActivity, setSelectedActivity] = useState(null);
  const [filteredActivities, setFilteredActivities] = useState([]);
  const navigate = useNavigate();

  useEffect(()=> {
    const validActivityNames = new Set(subType.activities.map(activity => activity.name));
    const filtered = activities.map(subArray => 
      subArray.filter(activity => validActivityNames.has(activity.activityName))
    );
    setFilteredActivities(filtered);
  },[activities, subType])
  console.log("filterd activities", filteredActivities);
  const onViewActionClick = (activity)=>{
    navigate('/activite_informations', {state: {activity, selectedUser}});
    //console.log(activity)

  }
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
              <TableHead >
                <TableRow >
                  <TableCell  style={{ fontWeight: 'bold' ,fontSize:'15px'}}>Nom de l'activité</TableCell>
                  <TableCell align="right"  style={{ fontWeight: 'bold' ,fontSize:'15px' }}>Action</TableCell>
                  <TableCell align="right"  style={{ fontWeight: 'bold' ,fontSize:'15px'}} >Points attribués</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
              {filteredActivities.map((subArray, subArrayIndex) => (
                    <React.Fragment key={subArrayIndex}>
                      {subArray.map((activity, activityIndex) => (
                        <TableRow key={activityIndex}  style={{ cursor: 'pointer' }}>
                          <TableCell component="th" scope="row" /*onClick={() => handleActivityClick(activity)}*/>{activity.activityName}</TableCell>
                          <TableCell align="right">
                            <IconButton aria-label="view" sx={{color:"#A66253"}}>
                              <VisibilityIcon onClick={()=> onViewActionClick(activity)}/>
                            </IconButton>
                          </TableCell>
                          <TableCell align="right" >
                            {activity.pointsAttribués}
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

ActivityRow.propTypes = {
  subType: PropTypes.object.isRequired,
  type: PropTypes.string.isRequired,
};

// Composant TableActivities
export default function TableActivities({types, activityType, activities, selectedUser}) {
  
  

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
                <ActivityRow key={index} subType={subType} activities={activities} selectedUser={selectedUser}/>
              ))}
            </React.Fragment>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

TableActivities.propTypes = {
  types: PropTypes.array.isRequired,
  activityType: PropTypes.oneOf(['research', 'teaching']).isRequired,
};
