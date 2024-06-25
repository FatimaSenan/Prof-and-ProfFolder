import React, { useState } from 'react';
import { styled, useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import MuiDrawer from '@mui/material/Drawer';
import List from '@mui/material/List';
import CssBaseline from '@mui/material/CssBaseline';
import Divider from '@mui/material/Divider';
import IconButton from '@mui/material/IconButton';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import ChevronRightIcon from '@mui/icons-material/ChevronRight';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import { MdHome } from "react-icons/md";
import { CgProfile } from "react-icons/cg";
import { FaCircleInfo } from "react-icons/fa6";
import { RxActivityLog } from "react-icons/rx";
import { IoMdSettings } from "react-icons/io";
import { RiLogoutCircleLine } from "react-icons/ri";
import { useNavigate } from 'react-router-dom';
import { useAppStore } from '../../appStore';
import { Collapse, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Button } from '@mui/material';
import ExpandLessIcon from '@mui/icons-material/ExpandLess';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import { FaChalkboardTeacher } from "react-icons/fa";
import { GiArchiveResearch } from "react-icons/gi";
import { useLocation } from 'react-router-dom';

const drawerWidth = 240;

const openedMixin = (theme) => ({
  width: drawerWidth,
  transition: theme.transitions.create('width', {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.enteringScreen,
  }),
  overflowX: 'hidden',
});

const closedMixin = (theme) => ({
  transition: theme.transitions.create('width', {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  overflowX: 'hidden',
  width: `calc(${theme.spacing(7)} + 1px)`,
  [theme.breakpoints.up('sm')]: {
    width: `calc(${theme.spacing(8)} + 1px)`,
  },
});

const DrawerHeader = styled('div')(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'flex-end',
  padding: theme.spacing(0, 1),
  ...theme.mixins.toolbar,
}));

const Drawer = styled(MuiDrawer, { shouldForwardProp: (prop) => prop !== 'open' })(
  ({ theme, open }) => ({
    width: drawerWidth,
    flexShrink: 0,
    whiteSpace: 'nowrap',
    boxSizing: 'border-box',
    ...(open && {
      ...openedMixin(theme),
      '& .MuiDrawer-paper': openedMixin(theme),
    }),
    ...(!open && {
      ...closedMixin(theme),
      '& .MuiDrawer-paper': closedMixin(theme),
    }),
  }),
);
const ListItemButtonStyled = styled(ListItemButton)(({ theme }) => ({
  '&.active': {
    backgroundColor: theme.palette.action.selected ,
  },
  '&:hover': {
    backgroundColor: theme.palette.action.selected,
  },
}));

export default function Sidenav() {
  const theme = useTheme();
  const navigate = useNavigate();
  const location = useLocation();
  const currentPath = location.pathname;
  const open = useAppStore((state) => state.dopen);

  const [isCollapse, setIsCollapse] = useState(false);
  const [openDialog, setOpenDialog] = useState(false);

  const handleCollapse = () => {
    setIsCollapse(!isCollapse);
  };

  const handleOpenDialog = () => {
    setOpenDialog(true);
  };

  const handleCloseDialog = () => {
    setOpenDialog(false);
  };
  const handleDisconnect = () => {
    
    setOpenDialog(false);
    
    navigate('/deconnexion');
  //  UserService.logout();
  };

  return (
    <>
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <Box height={30} />
      <Drawer variant="permanent" open={open}>
        <DrawerHeader>
          <IconButton>
            {theme.direction === 'rtl' ? <ChevronRightIcon /> : <ChevronLeftIcon />}
          </IconButton>
        </DrawerHeader>
        <Divider />
        <List sx={{ color: '#0D0D0D' }}>
          <ListItem disablePadding sx={{ display: 'block' }} onClick={() => navigate('/acceuil')}>
            <ListItemButtonStyled
              className={currentPath === '/acceuil' ? 'active' : ''}
              sx={{
                minHeight: 48,
                justifyContent: open ? 'initial' : 'center',
                px: 2.5,
              }}
            >
              <ListItemIcon
                sx={{
                  minWidth: 0,
                  mr: open ? 3 : 'auto',
                  justifyContent: 'center',
                }}
              >
                <MdHome color="#0D0D0D" />
              </ListItemIcon>
              <ListItemText primary="Accueil" sx={{ opacity: open ? 1 : 0 }} />
            </ListItemButtonStyled>
          </ListItem>

          <ListItem disablePadding sx={{ display: 'block' }}>
            <ListItemButtonStyled
              className={currentPath === '/activites' ? 'active' : ''}
              sx={{
                minHeight: 48,
                justifyContent: open ? 'initial' : 'center',
                px: 2.5,
              }}
            >
              <ListItemIcon
                sx={{
                  minWidth: 0,
                  mr: open ? 3 : 'auto',
                  justifyContent: 'center',
                }}
              >
                <RxActivityLog color="#0D0D0D" />
              </ListItemIcon>
              <ListItemText primary="Liste des Activités" sx={{ opacity: open ? 1 : 0 }} onClick={handleCollapse} />
              {isCollapse ? <ExpandLessIcon /> : <ExpandMoreIcon />}
            </ListItemButtonStyled>
          </ListItem>

          <Collapse in={isCollapse} timeout="auto" unmountOnExit>
            <List sx={{ pl: 4 }}>
              <ListItem disablePadding sx={{ display: 'block' }} onClick={() => navigate('/activite_enseignement')}>
                <ListItemButtonStyled
                  className={currentPath === '/enseignement' ? 'active' : ''}
                  sx={{
                    minHeight: 48,
                    justifyContent: open ? 'initial' : 'center',
                    px: 2.5,
                  }}
                >
                  <ListItemIcon
                    sx={{
                      minWidth: 0,
                      mr: open ? 3 : 'auto',
                      justifyContent: 'center',
                    }}
                  >
                    <FaChalkboardTeacher color="#A66253" fontSize="large" />
                  </ListItemIcon>
                  <ListItemText primary="Enseignement" sx={{ opacity: open ? 1 : 0 }} />
                </ListItemButtonStyled>
              </ListItem>

              <ListItem disablePadding sx={{ display: 'block' }} onClick={() => navigate('/activite_recherche')}>
                <ListItemButtonStyled
                  className={currentPath === '/recherche' ? 'active' : ''}
                  sx={{
                    minHeight: 48,
                    justifyContent: open ? 'initial' : 'center',
                    px: 2.5,
                  }}
                >
                  <ListItemIcon
                    sx={{
                      minWidth: 0,
                      mr: open ? 3 : 'auto',
                      justifyContent: 'center',
                    }}
                  >
                    <GiArchiveResearch color="#A66253" fontSize="large" />
                  </ListItemIcon>
                  <ListItemText primary="Recherche" sx={{ opacity: open ? 1 : 0 }} />
                </ListItemButtonStyled>
              </ListItem>
            </List>
          </Collapse>

          <ListItem disablePadding sx={{ display: 'block' }} onClick={() => navigate('/profile')}>
            <ListItemButtonStyled
              className={currentPath === '/profile' ? 'active' : ''}
              sx={{
                minHeight: 48,
                justifyContent: open ? 'initial' : 'center',
                px: 2.5,
              }}
            >
              <ListItemIcon
                sx={{
                  minWidth: 0,
                  mr: open ? 3 : 'auto',
                  justifyContent: 'center',
                }}
              >
                <CgProfile color="#0D0D0D" />
              </ListItemIcon>
              <ListItemText primary="Profile" sx={{ opacity: open ? 1 : 0 }} />
            </ListItemButtonStyled>
          </ListItem>

        </List>
        <Divider />

        
       

        <ListItem disablePadding sx={{ display: 'block', color: '#0D0D0D' }}>
          <ListItemButtonStyled
            sx={{
              minHeight: 48,
              justifyContent: open ? 'initial' : 'center',
              px: 2.5,
            }}
            onClick={handleOpenDialog}
          >
            <ListItemIcon
              sx={{
                minWidth: 0,
                mr: open ? 3 : 'auto',
                justifyContent: 'center',
              }}
            >
              <RiLogoutCircleLine color="#0D0D0D" />
            </ListItemIcon>
            <ListItemText primary="Déconnexion" sx={{ opacity: open ? 1 : 0 }} />
          </ListItemButtonStyled>
        </ListItem>
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
            <Button
              onClick={handleCloseDialog}
              color="primary"
              sx={{
                color: '#0D0D0D', // Change text color
                '&:hover': {
                  backgroundColor: '#ecd5d0', // Change hover background color
                },
              }}
            >
              Annuler
            </Button>
            <Button
              onClick={handleDisconnect}
              sx={{
                color: theme.palette.getContrastText('#A66253'),
                backgroundColor: '#A66253',
                '&:hover': {
                  backgroundColor: '#7F3D30',
                  
                },
              }}
              autoFocus
            >
              Déconnecter
            </Button>
          </DialogActions>
        </Dialog>
      </Drawer>
    </Box>
  </>
  );
}