import { Button, Dialog, DialogContent, DialogTitle, Box } from "@mui/material";
import CloseIcon from '@mui/icons-material/Close';
import { makeStyles } from "@material-ui/core/styles";

export default function CustomModal( {children, open, setOpen, handleFormSubmit}) {
  
   const useStyles = makeStyles((theme) => ({
    button: {
      marginRight: theme.spacing(1),
      color: '#ecd5d0',
      borderColor: '#ecd5d0',
      '&:hover': {
        backgroundColor: '#A66253',
        color: '#fff',
        
      },
      marginBottom: theme.spacing(1), // Ajout d'une marge en bas pour la flexibilité
    }}));
    //const classes = useStyles();
    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
       // width: 400,
        bgcolor: 'background.paper',
        border: '2px solid #000',
        boxShadow: 24,
        p: 4,
      };
      const handleClose = () => {
        setOpen(false)
      }
    return(
        <Dialog 
        open={open}
        onClose={handleClose}
        sx={{borderRadius: 30}}>
            <DialogTitle>
                <CloseIcon 
                sx={{ position: 'absolute', top: 2, right: 2, cursor: 'pointer', color: '#404040' }} 
                onClick={handleClose} 
                aria-label="close"
                />
            </DialogTitle>
            <DialogContent>
                {children}
                <Box sx={{ textAlign: 'right' }}>
                    <Button
                // className={classes.button}
                    variant="contained"
                    style={{ backgroundColor: "#A66253", color: "#0d0d0d", marginTop: "1rem", cursor: "pointer" }}
                    onClick={() =>{
                      handleFormSubmit();
                      handleClose();}}
                    >
                    Sauvegarder
                    </Button>
                </Box>
            </DialogContent>


        </Dialog>
    );
}