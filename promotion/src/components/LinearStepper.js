import React, { useState } from "react";
import {
  Typography,
  TextField,
  Button,
  Stepper,
  Step,
  StepLabel,
} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";


const useStyles = makeStyles((theme) => ({
  button: {
    marginRight: theme.spacing(1),
    color: '#ecd5d0', // Change button text color
    borderColor: '#ecd5d0', // Change button border color
    '&:hover': {
      backgroundColor: '#A66253', // Change button background color on hover
      color: '#fff', // Change button text color on hover
  },
},
  stepLabel: {
    color: "0D0D0D", // Modifier la couleur du label
  },
  root:{
    "& .MuiStepIcon-active": {color:"#A66253"},
    "& .MuiStepIcon-completed":{color:"#A66253"}
  }
  
}));

function getSteps() {
  return [
    { label: "La production scientifique", points: 16 },
    { label: "L'encadrement scientifique", points: 12 },
    { label: "Les responsabilités scientifiques", points: 3 },
  ];
}

function getStepContent(step) {
  switch (step) {
    case 0:
      return <h3>"Form 1"</h3>;

    case 1:
      return <h3>"Form 2"</h3>;
    
    case 2:
      return <h3>"Form 3"</h3>;
    
    default:
      return "unknown step";
  }
}
  

const LinearStepper = () => {
  const classes = useStyles();
  const [activeStep, setActiveStep] = useState(0);
  const [skippedSteps, setSkippedSteps] = useState([]);
  const steps = getSteps();

  const isStepOptional = (step) => {
    return step === 0 || step === 1 || step === 2;
  };

  const isStepSkipped = (step) => {
    return skippedSteps.includes(step);
  };

  const handleNext = () => {
    setActiveStep(activeStep + 1);
    setSkippedSteps(skippedSteps.filter((skipItem) => skipItem !== activeStep));
  };

  const handleBack = () => {
    setActiveStep(activeStep - 1);
  };

  const handleSkip = () => {
    if (!isStepSkipped(activeStep)) {
      setSkippedSteps([...skippedSteps, activeStep]);
    }
    setActiveStep(activeStep + 1);
  };

  return (
    <div>
      <Stepper

        alternativeLabel
        activeStep={activeStep}
        
      >
        {steps.map((step, index) => {
          const labelProps = {};
          const stepProps = {};
          if (isStepOptional(index)) {
            labelProps.optional = (
              <Typography
                variant="caption"
                align="center"
                style={{ display: "block", color: "#404040" }} // Modifier la couleur du label
              >
                Points: {step.points}
              </Typography>
            );
          }
          if (isStepSkipped(index)) {
            stepProps.completed = false;
          }
          return (
            <Step {...stepProps} key={index}>
              <StepLabel
                {...labelProps}
                classes={{ label: classes.stepLabel ,root:classes.root}} // Appliquer une classe personnalisée au label
                
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
          >
            Back
          </Button>
          {isStepOptional(activeStep) && (
            <Button
              className={classes.button}
              variant="contained"
              style={{ backgroundColor: '#A66253', color: '#0d0d0d' }}
              onClick={handleSkip}
            >
              Skip
            </Button>
          )}
          <Button
            className={classes.button}
            variant="contained"
            style={{ backgroundColor: '#A66253', color: '#0d0d0d' }}
            onClick={handleNext}
            
          >
            {activeStep === steps.length - 1 ? "Finish" : "Next"}
          </Button>
        </>
      )}
    </div>
  );
};

export default LinearStepper;
