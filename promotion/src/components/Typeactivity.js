import React from 'react';
import { Link } from 'react-router-dom';
import Grid from '@mui/material/Unstable_Grid2';
import Card from '@mui/material/Card';
import Box from '@mui/material/Box';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import { FaChalkboardTeacher } from "react-icons/fa";
import { GiArchiveResearch } from "react-icons/gi";

function Typeactivity() {
  return (
    <Box sx={{ flexGrow: 1}}>
      <Grid container spacing={1}>
        <Grid >
          <Link to="/stepper_enseignement" style={{textDecoration:"none"}}>
            <Card sx={{ minWidth: 345,'&:hover': { backgroundColor: '#ecd5d0' } }}>
              <CardActionArea>
                <CardContent>
                    <FaChalkboardTeacher fontSize={30} color='#A66253'/>
                    <Typography gutterBottom variant="h6" component="div" >
                        Activités d'enseignement
                    </Typography>
                    <Typography variant="body2" color="text.secondary" > 
                      50 points
                    </Typography>
                </CardContent>
              </CardActionArea>
            </Card>
          </Link>
        </Grid>
        <Grid>
        <Link to="/stepper_recherche" style={{textDecoration:"none"}}>
            <Card sx={{ minWidth: 345 ,'&:hover': { backgroundColor: '#ecd5d0' }}}>
              <CardActionArea>
                <CardContent>
                  <GiArchiveResearch fontSize={30} color='#A66253'/>
                  <Typography gutterBottom variant="h6" component="div">
                    Activités de recherche
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    50 points
                  </Typography>
                </CardContent>
              </CardActionArea>
            </Card>
          </Link>
        </Grid>
      </Grid>
    </Box>
  );
}

export default Typeactivity;
