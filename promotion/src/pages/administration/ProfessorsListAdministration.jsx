import Administration from "../../components/administration/Administration";
import NavbarAdministration from "../../components/administration/NavbarAdministration";
import Box from '@mui/material/Box';


function ProfessorsListAdministration() {
  

  
  return (
    <>
    <NavbarAdministration/>
    <Box height={30}/>
        <Box sx={{display:'flex', justifyContent: 'center', alignItems: 'center'}}>
        
        <Box component="main" sx={{ flexGrow: 1, p: 6 }}>
            <Administration/> 
        </Box> 
    </Box>
   
    </>
  )
}

export default ProfessorsListAdministration;