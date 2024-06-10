import React, { useState } from 'react';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import FormLabel from '@mui/material/FormLabel';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select'
import './ProfessorForm.css';
import FileUploadIcon from '@mui/icons-material/FileUpload';
import { styled } from '@mui/material/styles';


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


  const handleCiviliteChange = (event) => {
    setCivilite(event.target.value);
  };

  const handleDateChange = (event) => {
    const selectedDate = event.target.value;
    const formattedDate=new Date('2024-04-19').toISOString().slice(0, 10)
    setSelectedDate(formattedDate);
  };
  const handleDoctorateTypeChange = (event) => { // Gestionnaire pour le changement de type de doctorat
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
    fetch('http://localhost:9005/folder/add?professorId=12', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        civility: civilite,
        birth_date: selectedDate,
        email: email, // Utilisation de la valeur de l'état
        phone: tel, // Utilisation de la valeur de l'état
        grade: grade, // Utilisation de la valeur de l'état
        drpp: drpp, // Utilisation de la valeur de l'état
        profile: profil, // Utilisation de la valeur de l'état
        speciality: specialite, // Utilisation de la valeur de l'état
        establishment: etablissement, // Utilisation de la valeur de l'état
        phd_type: doctorateType
      }),
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Erreur de réseau: ' + response.statusText);
      }
      return response.json();
    })
    .then(data => {
      console.log('Réponse du serveur:', data);
      // Réinitialiser le formulaire
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
    })
    .catch((error) => {
      console.error('Erreur lors de la soumission du formulaire:', error);
    });
  };

  return (

    <div className="professor-form-container">
      <Grid container className='grid_container' spacing={2} direction="row">
        <Grid item xs={6} md={4}>
          <Paper className="personal-info">
            <FormLabel component="legend" className="text">Informations Personnelles
            <div className="underline"></div></FormLabel>
            
         
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
            <TextField id="prenom" label="Prénom" variant="outlined" fullWidth className="input-field" />
            <TextField id="nom" label="Nom" variant="outlined" fullWidth className="input-field" />
            <TextField id="cne" label="CNE" variant="outlined" fullWidth className="input-field" />
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
            <FormLabel component="legend" className="text">Informations Professionnelles
            
            <div className="underline"></div></FormLabel>
            
            <TextField id="grade" label="Grade" variant="outlined" fullWidth className="input-field" value={grade} onChange={handleGradeChange}  />
            <TextField id="drpp" label="DRPP" variant="outlined" fullWidth className="input-field" />
            <TextField
              id="profil"
              select
              label="Choisir un Profil"
              variant="outlined"
              fullWidth
              className="input-field"
              value={profil}
              onChange={handleProfilChange}
            >
              <MenuItem value="prof1">Profil 1</MenuItem>
              <MenuItem value="prof2">Profil 2</MenuItem>
            </TextField>
            <TextField
              id="specialite"
              select
              label="Choisir Spécialité"
              variant="outlined"
              fullWidth
              value={specialite}
              onChange={handleSpecialiteChange}
              className="input-field"
            >
              <MenuItem value="spec1">Spécialité 1</MenuItem>
              <MenuItem value="spec2">Spécialité 2</MenuItem>
            </TextField>
            <TextField
              id="etablissement"
              select
              label="Choisir Etablissement"
              variant="outlined"
              fullWidth
              className="input-field"
              value={etablissement}
              onChange={handleEtablissementChange}
            >
              <MenuItem value="etab1">Ensa</MenuItem>
              <MenuItem value="etab2">Est</MenuItem>
            </TextField>
          </Paper>
        </Grid>

        <Grid item xs={6} md={4}>
          <Paper className="upload-container">
            <FormLabel component="legend" className="text"> Télécharger Documents
                    
            <div className="underline"></div></FormLabel>
    
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadDemande" className="label">Demande de Candidature(Fomat pdf):</label>
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
                    <VisuallyHiddenInput type="file" />
                    </Button>
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadDemande" className="label">Curriculum Vitae(CV)(Fomat pdf):</label>
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
                    <VisuallyHiddenInput type="file" />
                    </Button>
              </div>
            </div>
            <div className="upload-button-container">
              <FormLabel htmlFor="doctorateType" className="label">Type du Doctorat</FormLabel>
              <Select // Champs de sélection pour le type de doctorat
                id="doctorateType"
                variant="outlined"
                fullWidth
                value={doctorateType}
                onChange={handleDoctorateTypeChange}
                className="input-field select"
              >
                <MenuItem value="etranger">Étranger</MenuItem>
                <MenuItem value="national">National</MenuItem>
              </Select>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadEquivalence" className="label">Equivalence (Bulletin Officiel)(png/jpeg):</label>
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
                    <VisuallyHiddenInput type="file" />
                    </Button>
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadDiplomeDoctorat" className="label">Diplome de Doctorat:</label>
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
                    <VisuallyHiddenInput type="file" />
                    </Button>
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadDiplomeHabilitation" className="label">Diplome d'Habilitation -1 (Format pdf):</label>
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
                    <VisuallyHiddenInput type="file" />
                    </Button>
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadArretNomination" className="label"> Arret de  Nomination(PH) -2 (Format pdf):</label>
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
                    <VisuallyHiddenInput type="file" />
                    </Button>
              </div>
            </div>
            <div className="upload-button-container">
              <div className="label-container">
                <label htmlFor="uploadAttestation" className="label">Attestation -3 (Format pdf):</label>
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
                    <VisuallyHiddenInput type="file" />
                    </Button>
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
     
           
    </div>
   
  );
}
