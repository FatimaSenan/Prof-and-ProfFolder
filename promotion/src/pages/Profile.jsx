import React from 'react'
import Box from '@mui/material/Box';
import Sidenav from '../components/Sidenav';
import Navbar from '../components/Navbar';
import ProfileContainer from '../components/profile/ProfileContainer';
function Profile() {
  return (
    <>
    <Navbar/>
    <Box height={30}/>
    <Box sx={{display:'flex'}}>
    <Sidenav/>
      
      

      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <ProfileContainer/>
        
      </Box>

      
    </Box>
   
    </>
  )
}

export default Profile;