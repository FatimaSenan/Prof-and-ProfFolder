import {useState} from 'react';
import Accueil from '../pages/Accueil'
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
import { useAppStore } from '../appStore';







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
  // necessary for content to be below app bar
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

export default function Sidenav() {
  const theme = useTheme();
 // const [open, setOpen] = useState(true);
  const [menudata, setMenudata] = useState("Accueil");
  const navigate = useNavigate();

  const open= useAppStore((state)=> state.dopen);
 
  return (
    <>
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <Box height={30}/>
      <Drawer variant="permanent" open={open}>
        <DrawerHeader>
          <IconButton>
            {theme.direction === 'rtl' ? <ChevronRightIcon /> : <ChevronLeftIcon />}
          </IconButton>
       </DrawerHeader>
        <Divider />
        <List sx={{color:"#A66253"}}>
          
            <ListItem disablePadding sx={{ display: 'block' }} onClick={()=>{navigate('/')}} >
              <ListItemButton
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
                  <MdHome color="#A66253" />
                </ListItemIcon>
                <ListItemText primary="Accueil" sx={{opacity:open ? 1:0}} />
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding sx={{ display: 'block' }} onClick={()=>{navigate('/listeactivities')}} >
              <ListItemButton
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
                  <RxActivityLog color="#A66253" />
                </ListItemIcon>
                <ListItemText primary="Liste des Activités" sx={{opacity:open ? 1:0}}/>
              </ListItemButton>
            </ListItem>
            
            <ListItem disablePadding sx={{ display: 'block' }} onClick={()=>{navigate('/profile')}}>
              <ListItemButton
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
                  <CgProfile color="#A66253" />
                </ListItemIcon>
                <ListItemText primary="Profile" sx={{opacity:open ? 1:0}} />
              </ListItemButton>
            </ListItem>
         
        </List>
        <Divider />

        <ListItem disablePadding sx={{ display: 'block',color:"#A66253" }} onClick={()=>{navigate('/parametres')}} >
              <ListItemButton
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
                  <IoMdSettings color="#A66253" />
                </ListItemIcon>
                <ListItemText primary="Paramètres" sx={{opacity:open ? 1:0}} />
              </ListItemButton>
            </ListItem>
        
        <ListItem disablePadding sx={{ display: 'block',color:"#A66253" }} onClick={()=>{navigate('/apropos')}}>
              <ListItemButton
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
                  <FaCircleInfo color="#A66253" />
                </ListItemIcon>
                <ListItemText primary="A propos" sx={{opacity:open ? 1:0}} />
              </ListItemButton>
            </ListItem>

            <ListItem disablePadding sx={{ display: 'block',color:"#A66253" }} onClick={()=>{navigate('/deconnexion')}}>
              <ListItemButton
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
                  <RiLogoutCircleLine color="#A66253" />
                </ListItemIcon>
                <ListItemText primary="Déconnexion" sx={{opacity:open ? 1:0}} />
              </ListItemButton>
            </ListItem>
      </Drawer>
      
    </Box>
    </>
    
  );
}