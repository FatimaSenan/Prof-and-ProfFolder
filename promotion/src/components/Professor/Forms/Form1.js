import { Form, Formik, ErrorMessage } from "formik";
import { advancedSchema } from "../schemas";
import Grid from "@mui/material/Grid";
//import ResponsabilitésScientifique from "../data/ResponsabilitésScientifiques";
import { useState , useEffect} from "react";
import CustomInput from "./CustomInput";
import Modal from "../Modal/Modal";
import CustomModal from "../Modal/Modal";
import { Button } from "@mui/material";
import axios from 'axios';
import getEndpoint from "./GetEndpoint";
import UploadFileButton from "../../UploadFileButton";
import AddBoxIcon from '@mui/icons-material/AddBox';
import IconButton from '@mui/material/IconButton';

const onSubmit = async (values, actions) => {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  actions.resetForm();
};

const Form_1 = ({activityType, activityName}) => {
  const [selectedType, setSelectedType] = useState("");
  const [selectedActivity, setSelectedActivity] = useState("");
  const [selectedOption, setSelectedOption] = useState("");
  const [additionalData, setAdditionalData] = useState({});
  const [responsabilitésScientifiques, setResponsabilitésScientifiques] = useState([]);
  const [open, setOpen] = useState(false);
  const [file, setFile] = useState(null);
  const [fileName, setFileName] = useState("");
    const fetchData = async ()=>{
      try {
        const response = await fetch(`${process.env.PUBLIC_URL}/data/${activityType}/${activityName}.json`);
        if (!response.ok) {
          throw new Error('Failed to fetch data');
        }
        const data = await response.json();
        setResponsabilitésScientifiques(data);
      } catch (error) {
        console.error('Error fetching data:', error.message);
      }
      
    };

  
  useEffect(() =>{
      fetchData()
  },[activityType, activityName])

  const handleTypeChange = (event) => {
    setSelectedType(event.target.value);
    setSelectedActivity(""); // Reset selected activity when type changes
  };

  const handleActivityChange = (event) => {
    setSelectedActivity(event.target.value);
    setOpen(true);
  };
  const handleOptionChange = (event, nameDatabase) => {
    setSelectedOption(event.target.value);
    
    console.log("Event target name:", event.target.name);
    console.log("Event target value:", event.target.value);
    setAdditionalData((prev) => ({
      ...prev,
      [nameDatabase]: event.target.value,
    }));
   console.log(additionalData)
  };
  
  const onSelectFileHandler = (e) => {
    const selectedFile = e.target.files[0];
  console.log(selectedFile); // Log the selected file
  setFile(selectedFile); // Set the selected file to the state
  setFileName(selectedFile.name)
  }
  
  const onDeleteFileHandler = () => {
    setFile(null);
    setFileName("");
  }
  const handleFormSubmit = async (values, actions) => {
   let endpoint = getEndpoint(selectedActivity);

  
       
    const dataToSend = new FormData();
    dataToSend.append("activityName", selectedActivity);

    for(const key in additionalData) {
      if(additionalData.hasOwnProperty(key)) {
        dataToSend.append(key, additionalData[key]);
      }
    }
    if(file) {
      dataToSend.append("file", file);
    }

    try {
      for (let [key, value] of dataToSend.entries()) {
        console.log(`${key}: ${value}`);
      }
      const response = await axios.post(endpoint, dataToSend, {
         headers: {
          'Authorization': 'Bearer ' +localStorage.getItem('token'),
          'Content-Type': 'multipart/form-data'
      },});

     
     
      
    const updatedAdditionalData = {};
    Object.keys(additionalData).forEach(key => {
      updatedAdditionalData[key] = ''; // 
    });      
    setAdditionalData(updatedAdditionalData);
      setFile(null);
      setFileName("");
    
      
    } catch (error) {
      console.log("Error: ", error);
      setAdditionalData({});
    }
  };
  



  const typeActivity = responsabilitésScientifiques.map((item, id) => (
    <option value={item.type} key={id}>
      {item.type}
    </option>
  ));

  const selectedTypeObject = responsabilitésScientifiques.find(
    (item) => item.type === selectedType
  );
  const activitiesOptions = selectedTypeObject
    ? selectedTypeObject.activités.map((activity, index) => (
        <option value={activity.activité} key={index}>
          {activity.activité}
        </option>
      ))
    : null;

  const selectedActivityObject = selectedTypeObject
    ? selectedTypeObject.activités.find(
        (activity) => activity.activité === selectedActivity
      )
    : null;
    const inputFields = selectedActivityObject
    ? selectedActivityObject.informations.map((info, index) => (
        <Grid item xs={12} sm={6} key={index}>
        {info.itemType === "input"? (
          <CustomInput
            label={`${info.name}: `}
            type="text"
            id={`info-${index}`}
            name={`${info.name}:`}
            handleOptionChange={(event) =>
              handleOptionChange(event, info.name_database)
            }
          />) : (
          <>
            <label>{info.name} </label>
              <select
                name={info.name}
                placeholder="Sélectionnez une option"
                value={additionalData[info.name_database] || ""}
                onChange={(event) => handleOptionChange(event, info.name_database)}
              >
                <option value="">Sélectionnez une option</option>
                  { info.options.map((option, optionIndex) => (
                    <option value={option.value} key={optionIndex}>
                      {option.value}
                    </option>
                  ))}
              </select>
            </>

          )}  
          
        </Grid>
      ))
    : null;

    
  return (
    <Formik
      initialValues={{
        activityType: "",
        activityName: "",
        acceptedTos: false,
      }}
      onSubmit={onSubmit}
    >
      {({ isSubmitting }) => (
        <Form>
          <Grid container spacing={4}>
            <Grid item xs={11} sm={5}>
              <label>Type Activité: </label>
              <select
                name="activityType"
                placeholder="Sélectionnez un type"
                value={selectedType}
                onChange={handleTypeChange}
              >
                <option value="">Sélectionnez un type</option>
                {typeActivity}
              </select>
              <ErrorMessage name="activityType" component="div" className="error" />

               <Grid item xs={1} style={{ marginTop: '2.9rem'}}>
            
            
          </Grid>
            </Grid>
            <Grid item xs={12} sm={6}>
              <label>Activité: </label>
              <select
                name="activityName"
                placeholder="Sélectionnez une activité"
                value={selectedActivity}
                onChange={handleActivityChange}
              >
                <option value="">Sélectionnez une activité</option>
                {activitiesOptions}
              </select>
              <ErrorMessage name="activityName" component="div" className="error" />
            </Grid>
            <Grid item xs={1} style={{marginTop: '2.9rem'}} >
            {selectedActivity && !open && (
              <IconButton onClick={() => setOpen(true)} style={{color: '#A66253' }}>
                <AddBoxIcon fontSize="large" />
              </IconButton >
            )}
              
               
            </Grid>
            
          </Grid>
          <CustomModal  open={open} setOpen={setOpen} handleFormSubmit={handleFormSubmit}>
            <>
             {inputFields}
             {selectedActivity != "Page web à caractère pédagogique" && <UploadFileButton onSelectFile={onSelectFileHandler} onDeleteFile={onDeleteFileHandler} fileName={fileName}/>}
             
            </>
          </CustomModal>
        </Form>
      )}
    </Formik>
  );
};

export default Form_1;