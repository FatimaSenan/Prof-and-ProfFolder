import React, { useState } from 'react';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import FormLabel from '@mui/material/FormLabel';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import './ProfessorForm.css';
import FileUploadIcon from '@mui/icons-material/FileUpload';
import { styled } from '@mui/material/styles';
import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';


const VisuallyHiddenInput = styled('input')({
  clip: 'rect(0 0 0 0)',
  clipPath: 'inset(50%)',
  height: 1,
  overflow: 'hidden',
  position: 'absolute',
  bottom: 0,
  left: 0,
  whiteSpace: 'nowrap',
  width: 1,
});

export default function ProfessorForm() {
  const [openSnackbar, setOpenSnackbar] = useState(false);

  const [prenom, setPrenom] = useState('');
  const [nom, setNom] = useState('');
  const [cne, setCne] = useState('');

  const [civilite, setCivilite] = useState('');
  const [selectedDate, setSelectedDate] = useState('');
  const [doctorateType, setDoctorateType] = useState('');
  const [email, setEmail] = useState('');
  const [tel, setTel] = useState('');
  const [grade, setGrade] = useState('');
  const [drpp, setDrpp] = useState('');
  const [profil, setProfil] = useState('');
  const [specialite, setSpecialite] = useState('');
  const [etablissement, setEtablissement] = useState('');
  const [demandeCandidature, setDemandeCandidature] = useState(null);
  const [cv, setCv] = useState(null);
  const [equivalence, setEquivalence] = useState(null);
  const [diplomeDoctorat, setDiplomeDoctorat] = useState(null);
  const [diplomeHabilitation, setDiplomeHabilitation] = useState(null);
  const [arretNomination, setArretNomination] = useState(null);
  const [attestation, setAttestation] = useState(null);

  const handleSnackbarClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setOpenSnackbar(false);
  };

  const handleFileChange = (event, setFile) => {
    setFile(event.target.files[0]);
  };

  const handleCiviliteChange = (event) => {
    setCivilite(event.target.value);
  };

  const handleDateChange = (event) => {
    setSelectedDate(event.target.value);
  };

  const handleDoctorateTypeChange = (event) => {
    setDoctorateType(event.target.value);
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handleTelChange = (event) => {
    setTel(event.target.value);
  };

  const handleGradeChange = (event) => {
    setGrade(event.target.value);
  };

  const handleDrppChange = (event) => {
    setDrpp(event.target.value);
  };

  const handleProfilChange = (event) => {
    setProfil(event.target.value);
  };

  const handleSpecialiteChange = (event) => {
    setSpecialite(event.target.value);
  };

  const handleEtablissementChange = (event) => {
    setEtablissement(event.target.value);
  };

  const handleSubmit = () => {
    const formData = new FormData();
    formData.append('prenom', prenom);  
    formData.append('nom', nom);     
    formData.append('civility', civilite);
    formData.append('birthDate', selectedDate);
    formData.append('email', email);
    formData.append('cne', cne);
    formData.append('phone', tel);
    formData.append('grade', grade);
    formData.append('drpp', drpp);
    formData.append('profile', profil);
    formData.append('speciality', specialite);
    formData.append('establishment', etablissement);
    formData.append('phdType', doctorateType);
    formData.append('applicationDemande', demandeCandidature);
    formData.append('cv', cv);
    formData.append('equivalence', equivalence);
    formData.append('phdDiplome', diplomeDoctorat);
    formData.append('habilitationDiplome', diplomeHabilitation);
    formData.append('arretNomination', arretNomination);
    formData.append('attestation', attestation);

    fetch('http://localhost:9005/professor/add-professor-folder', {
      method: 'POST',
      body: formData,
      headers: {
        'Authorization': 'Bearer ' +localStorage.getItem('token'),
         // 'Content-Type': 'multipart/form-data'
      }
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Erreur de réseau: ' + response.statusText);
      }
      console.log('Réponse du serveur:', response);
      setCivilite('');
      setSelectedDate('');
      setDoctorateType('');
      setEmail('');
      setTel('');
      setGrade('');
      setDrpp('');
      setProfil('');
      setSpecialite('');
      setEtablissement('');
      setDemandeCandidature(null);
      setCv(null);
      setEquivalence(null);
      setDiplomeDoctorat(null);
      setDiplomeHabilitation(null);
      setArretNomination(null);
      setAttestation(null);
      setPrenom('');  
      setNom(''); 
      setCne('');
      setOpenSnackbar(true);
    })
    .catch((error) => {
      console.error('Erreur lors de la soumission du formulaire:', error);
    });
  };

  const renderFileLink = (file) => {
    if (!file) return null;
    const url = URL.createObjectURL(file);
    return <a href={url} target="_blank" rel="noopener noreferrer" className="file-link">{file.name}</a>;
  };

  return (
    <div className="professor-form-container">
      <Grid container className="grid_container" spacing={2} direction="row">
        <Grid item xs={6} md={4}>
          <Paper className="personal-info">
            <FormLabel component="legend" className="text">
              Informations Personnelles
              <div className="underline"></div>
            </FormLabel>
            <TextField
              id="civilite"
              select
              label="Civilité"
              variant="outlined"
              fullWidth
              value={civilite}
              onChange={handleCiviliteChange}
              className="input-field"
            >
              <MenuItem value="Mme">Mme</MenuItem>
              <MenuItem value="Msr">Msr</MenuItem>
            </TextField>
            <TextField 
                id="prenom" 
                label="Prénom" 
                variant="outlined" 
                fullWidth 
                className="input-field" 
                value={prenom} 
                onChange={(e) => setPrenom(e.target.value)} 
              />
            <TextField 
              id="nom" 
              label="Nom" 
              variant="outlined" 
              fullWidth 
              className="input-field" 
              value={nom} 
              onChange={(e) => setNom(e.target.value)} 
            />
            <TextField id="cne" label="CNE" variant="outlined" fullWidth className="input-field" value={cne} 
              onChange={(e) => setCne(e.target.value)}/>
            <TextField
              id="dateNaissance"
              label="Date de Naissance"
              type="date"
              variant="outlined"
              fullWidth
              value={selectedDate}
              onChange={handleDateChange}
              className="input-field"
              InputLabelProps={{
                shrink: true,
              }}
            />
            <TextField id="email" label="Email" variant="outlined" fullWidth className="input-field" value={email} onChange={handleEmailChange} />
            <TextField id="tel" label="Téléphone" variant="outlined" fullWidth className="input-field" value={tel} onChange={handleTelChange} />
          </Paper>
        </Grid>

        <Grid item xs={6} md={4}>
          <Paper className="professional-info">
            <FormLabel component="legend" className="text">
              Informations Professionnelles
              <div className="underline"></div>
            </FormLabel>
            <TextField id="grade" label="Grade" variant="outlined" fullWidth className="input-field" value={grade} onChange={handleGradeChange} />
            <TextField id="drpp" label="DRPP" variant="outlined" fullWidth className="input-field" value={drpp} onChange={handleDrppChange} />
            <TextField
              id="profil"
              label="Profil"
              variant="outlined"
              fullWidth
              className="input-field"
              value={profil}
              onChange={handleProfilChange}
            />
             
            <TextField
              id="specialite"
              label="Spécialité"
              variant="outlined"
              fullWidth
              value={specialite}
              onChange={handleSpecialiteChange}
              className="input-field"
            />
            <TextField
              id="etablissement"
              label="Etablissement"
              variant="outlined"
              fullWidth
              className="input-field"
              value={etablissement}
              onChange={handleEtablissementChange}
            />
            <TextField
              id="type_doctorat"
              label="Type de Doctorat"
              variant="outlined"
              fullWidth
              className="input-field"
              value={doctorateType}
              onChange={handleDoctorateTypeChange}
            />
          </Paper>
        </Grid>

        <Grid item xs={6} md={4}>
          <Paper className="upload-container">
            <FormLabel component="legend" className="text">
              Télécharger Documents
              <div className="underline"></div>
            </FormLabel>

            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadDemande" className="label">
                  Demande de Candidature (Format pdf):
                </label>
              </div>
              <div className="button-container">
                <Button
                  className="upload-button"
                  component="label"
                  role={undefined}
                  variant="contained"
                  tabIndex={-1}
                  startIcon={<FileUploadIcon />}
                >
                  Parcourir
                  <VisuallyHiddenInput type="file" onChange={(e) => handleFileChange(e, setDemandeCandidature)} />
                </Button>
                {renderFileLink(demandeCandidature)}
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadCv" className="label">
                  Curriculum Vitae (CV) (Format pdf):
                </label>
              </div>
              <div className="button-container">
                <Button
                  className="upload-button"
                  component="label"
                  role={undefined}
                  variant="contained"
                  tabIndex={-1}
                  startIcon={<FileUploadIcon />}
                >
                  Parcourir
                  <VisuallyHiddenInput type="file" onChange={(e) => handleFileChange(e, setCv)} />
                </Button>
                {renderFileLink(cv)}
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadEquivalence" className="label">
                  Equivalence (Bulletin Officiel) (png/jpeg):
                </label>
              </div>
              <div className="button-container">
                <Button
                  className="upload-button"
                  component="label"
                  role={undefined}
                  variant="contained"
                  tabIndex={-1}
                  startIcon={<FileUploadIcon />}
                >
                  Parcourir
                  <VisuallyHiddenInput type="file" onChange={(e) => handleFileChange(e, setEquivalence)} />
                </Button>
                {renderFileLink(equivalence)}
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadDiplomeDoctorat" className="label">
                  Diplome de Doctorat:
                </label>
              </div>
              <div className="button-container">
                <Button
                  className="upload-button"
                  component="label"
                  role={undefined}
                  variant="contained"
                  tabIndex={-1}
                  startIcon={<FileUploadIcon />}
                >
                  Parcourir
                  <VisuallyHiddenInput type="file" onChange={(e) => handleFileChange(e, setDiplomeDoctorat)} />
                </Button>
                {renderFileLink(diplomeDoctorat)}
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadDiplomeHabilitation" className="label">
                  Diplome d'Habilitation -1 (Format pdf):
                </label>
              </div>
              <div className="button-container">
                <Button
                  className="upload-button"
                  component="label"
                  role={undefined}
                  variant="contained"
                  tabIndex={-1}
                  startIcon={<FileUploadIcon />}
                >
                  Parcourir
                  <VisuallyHiddenInput type="file" onChange={(e) => handleFileChange(e, setDiplomeHabilitation)} />
                </Button>
                {renderFileLink(diplomeHabilitation)}
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadArretNomination" className="label">
                  Arret de Nomination (PH) -2 (Format pdf):
                </label>
              </div>
              <div className="button-container">
                <Button
                  className="upload-button"
                  component="label"
                  role={undefined}
                  variant="contained"
                  tabIndex={-1}
                  startIcon={<FileUploadIcon />}
                >
                  Parcourir
                  <VisuallyHiddenInput type="file" onChange={(e) => handleFileChange(e, setArretNomination)} />
                </Button>
                {renderFileLink(arretNomination)}
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadAttestation" className="label">
                  Attestation -3 (Format pdf):
                </label>
              </div>
              <div className="button-container">
                <Button
                  className="upload-button"
                  component="label"
                  role={undefined}
                  variant="contained"
                  tabIndex={-1}
                  startIcon={<FileUploadIcon />}
                >
                  Parcourir
                  <VisuallyHiddenInput type="file" onChange={(e) => handleFileChange(e, setAttestation)} />
                </Button>
                {renderFileLink(attestation)}
              </div>
            </div>
          </Paper>
        </Grid>
        <Grid item xs={12}>
          <Grid container justifyContent="flex-start">
            <Button variant="contained" className="validate-button" onClick={handleSubmit}>
              Valider
            </Button>
          </Grid>
        </Grid>
      </Grid>
      <Snackbar
        open={openSnackbar}
        autoHideDuration={6000}
        onClose={handleSnackbarClose}
        anchorOrigin={{
          vertical: 'bottom',
          horizontal: 'left',
        }}
      >
        <MuiAlert onClose={handleSnackbarClose} severity="success" sx={{ width: '100%' }}>
          Les informations ont été ajoutées avec succès !
        </MuiAlert>
      </Snackbar>
    </div>
  );
}