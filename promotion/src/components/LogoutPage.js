import React from 'react';
import { Box, Grid, Typography, Button } from '@mui/material';
import LogoutIcon from '@mui/icons-material/Logout';
import { useNavigate } from 'react-router-dom';
import UserService from './Professor/service/UsersService';

const LogoutPage = () => {
  const navigate = useNavigate();

  const handleSignIn = () => {
    UserService.logout();
    navigate('/login'); // Naviguer vers la page de connexion
  };

  return (
    <Box
      sx={{
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '100vh',
        textAlign: 'center',
        boxShadow: '0px 4px 10px rgba(0, 0, 0, 0.1)', // Ajoute l'effet d'élévation

      }}
    >
      <Grid container direction="column" alignItems="center" spacing={2}>
        <Grid item>
          <LogoutIcon sx={{ fontSize: 100, color: '#A66253' }} />
        </Grid>
        <Grid item>
          <Typography variant="h4">Vous êtes déconnecté</Typography>
        </Grid>
        <Grid item>
          <Button
            variant="contained"
            onClick={handleSignIn}
            sx={{
              backgroundColor: '#A66253',
              '&:hover': {
                backgroundColor: '#7F3D30',
              },
            }}
          >
            Sign In
          </Button>
        </Grid>
      </Grid>
    </Box>
  );
};

export default LogoutPage;