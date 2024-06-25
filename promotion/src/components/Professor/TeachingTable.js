import React, { useState } from 'react';
import { Button, Grid, Typography, TextField, Snackbar } from '@mui/material';
import UploadFileIcon from '@mui/icons-material/UploadFile';
import DownloadIcon from '@mui/icons-material/Download';
import axios from 'axios';
import MuiAlert from '@mui/material/Alert';
import Navbar from './Navbar';
import Sidenav from './Sidenav';

const TeachingTable = () => {
  const [file, setFile] = useState(null);
  const [fileName, setFileName] = useState('');
  const [openSnackbar, setOpenSnackbar] = useState(false);

  const handleFileChange = (event) => {
    const selectedFile = event.target.files[0];
    if (selectedFile) {
      setFile(selectedFile);
      setFileName(selectedFile.name);
    }
  };

  const handleCloseSnackbar = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setOpenSnackbar(false);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!file) {
      alert('Veuillez sélectionner un fichier.');
      return;
    }

    const formData = new FormData();
    formData.append('file', file);

    try {
      const response = await axios.post('http://localhost:9005/annexe3/add-annexe3', formData, {
        headers: {
          'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
      });

      console.log('File upload successful:', response.data);
      setOpenSnackbar(true); // Ouvrir le snackbar en cas de succès

      setFile(null);
      setFileName('');
    } catch (error) {
      console.error('Error uploading file:', error);
      alert('Erreur lors du téléchargement du fichier.');
    }
  };

  const handleDownloadTemplate = async () => {
    try {
      const response = await axios.get('http://localhost:9005/professor/template/download', {
        responseType: 'blob',
        headers: {
          'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
      });

      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute('download', 'template.xlsx');
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    } catch (error) {
      console.error('Error downloading template:', error);
      alert('Erreur lors du téléchargement du template.');
    }
  };

  return (
    <>
      <Navbar />
      <Sidenav />
      <form onSubmit={handleSubmit}>
        <Grid container spacing={2} justifyContent="center" alignItems="center" direction="column" style={{ padding: '2rem', marginTop: '3.5rem' }}>
          <Grid item>
            <Typography variant="h5" component="h2">
              Tableau détaillé par l'enseignement aux différents niveaux
            </Typography>
          </Grid>
          <Grid item>
            <Button variant="contained" sx={{
                backgroundColor: '#A66253',
                '&:hover': {
                  backgroundColor: '#7F3D30',
                },
              }} startIcon={<DownloadIcon />} onClick={handleDownloadTemplate}>
              Télécharger le template
            </Button>
          </Grid>
          <Grid item>
            <input
              accept=".xls,.xlsx,.csv"
              id="file-upload"
              type="file"
              style={{ display: 'none' }}
              onChange={handleFileChange}
            />
            <label htmlFor="file-upload">
              <Button variant="contained" sx={{
                backgroundColor: '#A66253',
                '&:hover': {
                  backgroundColor: '#7F3D30',
                },
              }} component="span" startIcon={<UploadFileIcon />}>
                Parcourir
              </Button>
            </label>
          </Grid>
          <Grid item>
            <TextField
              value={fileName || 'Aucun fichier sélectionné'}
              variant="outlined"
              fullWidth
              disabled
            />
          </Grid>
          <Grid item>
            <Button type="submit" variant="contained" sx={{
                backgroundColor: '#A66253',
                '&:hover': {
                  backgroundColor: '#7F3D30',
                },
              }}>
              Valider
            </Button>
          </Grid>
        </Grid>
      </form>
      <Snackbar
        open={openSnackbar}
        autoHideDuration={6000}
        onClose={handleCloseSnackbar}
        anchorOrigin={{ vertical: 'top', horizontal: 'center' }}
      >
        <MuiAlert onClose={handleCloseSnackbar} severity="success">
          Fichier téléchargé avec succès.
        </MuiAlert>
      </Snackbar>
    </>
  );
};

export default TeachingTable;
