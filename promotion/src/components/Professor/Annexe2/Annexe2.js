import React, { useState } from 'react';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import FormLabel from '@mui/material/FormLabel';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import MenuItem from '@mui/material/MenuItem';
import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';
import '../DossierAdministratif/ProfessorForm.css';
import Navbar from '../Navbar';
import Sidenav from '../Sidenav';
import { Typography } from '@mui/material';
import axios from 'axios';


export default function Annexe2() {
  const [etablissement, setEtablissement] = useState('');
  const [departement, setDepartement] = useState('');
  const [nom, setNom] = useState('');
  const [prenom, setPrenom] = useState('');
  const [grade, setGrade] = useState('');
  const [echelon, setEchelon] = useState('');
  const [openSnackbar, setOpenSnackbar] = useState(false);

  const handleEtablissementChange = (event) => {
    setEtablissement(event.target.value);
  };

  const handleDepartementChange = (event) => {
    setDepartement(event.target.value);
  };

  const handleNomChange = (event) => {
    setNom(event.target.value);
  };

  const handlePrenomChange = (event) => {
    setPrenom(event.target.value);
  };

  const handleGradeChange = (event) => {
    setGrade(event.target.value);
  };

  const handleEchelonChange = (event) => {
    setEchelon(event.target.value);
  };

  const handleSubmit = async () => {
    const annexe2Data = {
      nom,
      prenom,
      grade,
      echelon,
      etablissement,
      departement
    };

    try {
      const response = await axios.post('http://localhost:9005/professor/annexe2/save', annexe2Data, {
        headers: {
          'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
      });

      console.log('Data saved successfully:', response.data);
      setOpenSnackbar(true); // Open the snackbar on success

      // Clear form state after successful submission
      setNom('');
      setPrenom('');
      setGrade('');
      setEchelon('');
      setEtablissement('');
      setDepartement('');

    } catch (error) {
      console.error('There was an error saving the data:', error);
      alert('Erreur lors de l\'enregistrement des données.');
    }
  };

  const handleCloseSnackbar = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }

    setOpenSnackbar(false);
  };

  return (
    <>
      <Navbar />
      <Sidenav />
      <Typography variant="h5" component="h2" sx={{ marginTop: '4rem', textAlign: 'center' }}>
        Formulaire d'inscription
      </Typography>

      <div className="professor-form-container">
        <Grid container className='grid_container' justifyContent="center">
          <Grid item xs={12} md={6}>
            <Paper className="professional-info">
              <FormLabel component="legend" className="text">
                Annexe2
              </FormLabel>
              <TextField
                id="nom"
                label="Nom"
                variant="outlined"
                fullWidth
                className="input-field"
                value={nom}
                onChange={handleNomChange}
              />
              <TextField
                id="prenom"
                label="Prénom"
                variant="outlined"
                fullWidth
                className="input-field"
                value={prenom}
                onChange={handlePrenomChange}
              />
              <TextField
                id="grade"
                label="Grade"
                variant="outlined"
                fullWidth
                className="input-field"
                value={grade}
                onChange={handleGradeChange}
              />
              <TextField
                id="echelon"
                label="Échelon"
                variant="outlined"
                fullWidth
                className="input-field"
                value={echelon}
                onChange={handleEchelonChange}
              />
              <TextField
                id="etablissement"
                label="Établissement"
                variant="outlined"
                fullWidth
                value={etablissement}
                onChange={handleEtablissementChange}
                className="input-field"
              />
              <TextField
                id="departement"
                label="Département"
                variant="outlined"
                fullWidth
                value={departement}
                onChange={handleDepartementChange}
                className="input-field"
              />
            </Paper>
            <Button
              variant="contained"
              sx={{
                backgroundColor: '#A66253',
                '&:hover': {
                  backgroundColor: '#7F3D30',
                },
              }}
              className="validate-button-annexe2"
              onClick={handleSubmit}
            >
              Valider
            </Button>
          </Grid>
        </Grid>
      </div>

      <Snackbar
        open={openSnackbar}
        autoHideDuration={6000}
        onClose={handleCloseSnackbar}
        anchorOrigin={{ vertical: 'top', horizontal: 'center' }}
      >
        <MuiAlert onClose={handleCloseSnackbar} severity="success">
          Données enregistrées avec succès.
        </MuiAlert>
      </Snackbar>
    </>
  );
}
