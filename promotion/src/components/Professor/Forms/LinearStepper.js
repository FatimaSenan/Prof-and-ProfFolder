import React, { useState } from "react";
import {
  Typography,
  Stepper,
  Step,
  StepLabel,
} from "@material-ui/core";
import Button from '@mui/material/Button';
import { makeStyles } from "@material-ui/core/styles";
import Form_1 from "./Form1";

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
  },
  stepLabel: {
    color: "#0D0D0D",
  },
  root: {
    "& .MuiStepIcon-active": { color: "#A66253" },
    "& .MuiStepIcon-completed": { color: "#A66253" }
  },
  buttonContainer: {
    display: 'flex',
    justifyContent: 'center',
    marginTop: theme.spacing(2), // Ajout de marges en haut pour l'espacement
  },
}));
// for stepper enseignant
const getEnseignantSteps = () => {
  return [
    { label: "Activités pédagogiques", points: 15 },
    { label: "Encadrement pédagogique", points: 14 },
    { label: "Responsabilités pédagogiques", points: 6 },
  ];
};
// For Stepper Recherche
const getRechercheSteps = () => {
  return [
    { label: "Activités scientifiques", points: 16 },
    { label: "Encadrement scientifique", points: 12 },
    { label: "Responsabilités scientifiques", points: 3 },
    { label: "Rayonnement- Ouverture- Innovation- Valorisation", points: 4 },
  ];
};


const LinearStepper = ({type}) => {
  const classes = useStyles();
  const [activeStep, setActiveStep] = useState(0);
  const [skippedSteps, setSkippedSteps] = useState([]);
  

  
  

  

  const steps = type ==="enseignant" ? getEnseignantSteps() : getRechercheSteps();

  const isStepOptional = (step) => {
    return step === 0 || step === 1 || step === 2;
  };

  const isStepSkipped = (step) => {
    return skippedSteps.includes(step);
  };

  const handleNext = () => {
    setActiveStep((prevActiveStep) => prevActiveStep + 1);
  };

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1);
  };

  const handleSkip = () => {
    if (!isStepSkipped(activeStep)) {
      setSkippedSteps([...skippedSteps, activeStep]);
    }
    setActiveStep((prevActiveStep) => prevActiveStep + 1);
  };

  const getStepContent = (step) => {
    switch (step) {
      case 0:
        return <Form_1 activityType={type === "enseignant" ? "activités_d_enseignement" : "activités_de_recherche"} activityName={type==="enseignant" ? "activitésPédagogiques": "productionScientifique"}/>;

      case 1:
        return <Form_1 activityType={type === "enseignant" ? "activités_d_enseignement" : "activités_de_recherche"} activityName={type === "enseignant" ? "encadrementPédagogique": "encadrementScientifique"}/> ;

      case 2:
        return <Form_1 activityType={type === "enseignant" ? "activités_d_enseignement" : "activités_de_recherche"} activityName={type === "enseignant" ? "responsabilitésPédagogiques" : "responsabilitésScientifiques"}/>;

      case 3:
        return <Form_1 activityType="activités_de_recherche" activityName= "rayonnement_ouverture_innovation_valorisation"/>;
      default:
        return "unknown step";
    }
  };

  return (
    <div>
      <Stepper alternativeLabel activeStep={activeStep}>
        {steps.map((step, index) => {
          const labelProps = {};
          const stepProps = {};
          if (isStepOptional(index)) {
            labelProps.optional = (
              <Typography
                variant="caption"
                align="center"
                style={{ display: "block", color: "#404040" }}
              >
                Points: {step.points}
              </Typography>
            );
          }
          if (isStepSkipped(index)) {
            stepProps.completed = false;
          }
          return (
            <Step key={index} {...stepProps}>
              <StepLabel
                {...labelProps}
                classes={{ label: classes.stepLabel, root: classes.root }}
              >
                {step.label}
              </StepLabel>
            </Step>
          );
        })}
      </Stepper>

      {activeStep === steps.length ? (
        <Typography variant="h3" align="center">
          Terminé
        </Typography>
      ) : (
        <>
          <form>{getStepContent(activeStep)}</form>
          <Button
            className={classes.button}
            disabled={activeStep === 0}
            onClick={handleBack}
            style={{marginTop: "1rem"}}
          >
            Back
          </Button>
          {isStepOptional(activeStep) && (
            <Button
              className={classes.button}
              variant="contained"
              style={{ backgroundColor: "#A66253", color: "#0d0d0d", marginTop: "1rem" }}
              onClick={handleSkip}
            >
              Skip
            </Button>
          )}
          <Button
            className={classes.button}
            variant="contained"
            style={{ backgroundColor: "#A66253", color: "#0d0d0d" , marginTop: "1rem"}}
            onClick={handleNext}
          >
            {activeStep === steps.length - 1 ? "Terminer" : "Suivant"}
          </Button>
        </>
      )}
    </div>
  );
};

export default LinearStepper;
