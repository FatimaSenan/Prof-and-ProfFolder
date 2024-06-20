import * as React from 'react';
import { styled } from '@mui/material/styles';
import MuiAppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import LogoutIcon from '@mui/icons-material/Logout';
import { useNavigate } from 'react-router-dom';
import { useAppStore } from '../../appStore';
import { useState } from 'react';
import UserService from '../Professor/service/UsersService';
import { Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Button } from '@mui/material';
import {useTheme} from '@mui/material/styles';
const AppBar = styled(MuiAppBar, {})(({ theme }) => ({
  zIndex: theme.zIndex.drawer + 1,
}));

export default function NavbarAdministration() {
  const theme = useTheme();
  const navigate = useNavigate();
  const [openDialog, setOpenDialog] = useState(false);
  const updateOpen = useAppStore((state) => state.updateOpen);
  const dopen = useAppStore((state) => state.dopen);

  const handleOpenDialog = () => {
    setOpenDialog(true);
  };

  const handleCloseDialog = () => {
    setOpenDialog(false);
  };

  const handleDisconnect = () => {
    setOpenDialog(false);
    
    navigate('/deconnexion');
  };

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="fixed" elevation={4} sx={{ backgroundColor: '#ffffff', color: '#A66253' }}>
        <Toolbar sx={{ justifyContent: 'space-between' }}>
          <Typography variant="h6" noWrap component="div" sx={{ display: { xs: 'none', sm: 'block' } }}>
            <img src='./icons/logo_test_1.jpg' height={50} alt='logo' />
          </Typography>
          <IconButton
            size="large"
            edge="end"
            aria-label="logout"
            onClick={handleOpenDialog}
            color="inherit"
            sx={{ ml: 'auto' }} // Pour placer l'IconButton tout à droite
          >
            <LogoutIcon />
          </IconButton>
        </Toolbar>
      </AppBar>
      <Dialog
            open={openDialog}
            onClose={handleCloseDialog}
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
            <DialogTitle id="alert-dialog-title">Confirmer la déconnexion</DialogTitle>
            <DialogContent>
              <DialogContentText id="alert-dialog-description">
                Êtes-vous sûr de vouloir vous déconnecter ?
              </DialogContentText>
            </DialogContent>
            <DialogActions>
              <Button onClick={handleCloseDialog} color="primary"sx={{
                        color: '#0D0D0D', // Change text color
                        '&:hover': {
                          backgroundColor: '#ecd5d0', // Change hover background color
                        },
                      }}>
                Annuler
              </Button>
              <Button
                onClick={handleDisconnect}
                sx={{
                  color: theme.palette.getContrastText("#A66253"),
                  backgroundColor: "#A66253",
                  '&:hover': {
                    backgroundColor: "#7F3D30",
                  },
                }}
                autoFocus
              >
                se Déconnecter
              </Button>
            </DialogActions>
          </Dialog>

    </Box>
  );
}
