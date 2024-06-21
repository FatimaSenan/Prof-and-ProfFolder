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
import axios from 'axios';
import {Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Button } from '@mui/material';
import { useTheme } from '@mui/material/styles';


function Row({subType, activities}) {
  
  const [open, setOpen] = React.useState(false);
  const [openConfirmationDialog, setOpenConfirmationDialog] = useState(false);
  const [selectedActivity, setSelectedActivity] = useState(null);
  const [filteredActivities, setFilteredActivities] = useState([]);
  const navigate = useNavigate();
  const theme = useTheme();
  //console.log(activities)
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
  const handleDeleteClick = (activity) => {
    setSelectedActivity(activity);
    setOpenConfirmationDialog(true);
    console.log("Selected activity: ",selectedActivity);
  };
  console.log("filtered Activities : ",typeof filteredActivities);
  //console.log('Is filteredActivities an array?', filteredActivities[1][0].activityName); 
  

  const handleDeleteConfirm = async () => {
    try{
      const response = await axios.delete('http://localhost:9005/professor/activities/delete-activity', {
        params: { activityName: selectedActivity.activityName, id: selectedActivity.id },
        headers: {
          'Authorization': 'Bearer ' +localStorage.getItem('token')
        }
      });
      if(response.status === 200) {
        alert("activité supprimé avec succès!");
      
        //console.log(filteredActivities);
        const updatedFilteredActivities = filteredActivities.map(subArray =>
          subArray.filter(activity => activity.activityName !== selectedActivity.activityName)
        );
        setFilteredActivities(updatedFilteredActivities);
        
        
      }else {
        alert("Échec de la suppression de l'activité");
      }
    } catch (error) {
      console.error("There was an error deleting the activity!", error);
      alert("Une erreur est survenue lors de la suppression de l'activité");
    }
    setOpenConfirmationDialog(false);
    };
  
    const handleDeleteCancel = () => {
      setOpenConfirmationDialog(false);
    };
    //console.log(filteredActivities);
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
                        <TableRow key={activityIndex}  style={{ cursor: 'pointer' }}>
                          <TableCell component="th" scope="row" onClick={() => handleActivityClick(activity)}>{activity.activityName}</TableCell>
                          <TableCell align="right">
                            <IconButton aria-label="delete" color="error" onClick={() => handleDeleteClick(activity)}>
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
      <Dialog
            open={openConfirmationDialog}
            onClose={handleDeleteCancel}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description"
            sx={{
              '& .MuiDialog-container .MuiPaper-root': {
                width: '80%',
                maxWidth: '400px',
                height: '40%',
                maxHeight: '300px',
              },
            }}
          >
            <DialogTitle id="alert-dialog-title">Confirmer la suppression</DialogTitle>
            <DialogContent>
              <DialogContentText id="alert-dialog-description">
                Êtes-vous sûr de vouloir supprimer cette activité ?
              </DialogContentText>
            </DialogContent>
            <DialogActions>
              <Button onClick={handleDeleteCancel} color="primary"sx={{
                        color: '#0D0D0D', // Change text color
                        '&:hover': {
                          backgroundColor: '#ecd5d0', // Change hover background color
                        },
                      }}>
                Annuler
              </Button>
              <Button
                onClick={handleDeleteConfirm}
                sx={{
                  color: theme.palette.getContrastText("#A66253"),
                  backgroundColor: "#A66253",
                  '&:hover': {
                    backgroundColor: "#7F3D30",
                  },
                }}
                autoFocus
              >
                Supprimer
              </Button>
            </DialogActions>
          </Dialog>
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