import { Form, Formik, ErrorMessage } from "formik";
import { advancedSchema } from "../schemas";
import Grid from "@mui/material/Grid";
//import ResponsabilitésScientifique from "../data/ResponsabilitésScientifiques";
import { useState , useEffect} from "react";
import CustomInput from "./CustomInput";
const onSubmit = async (values, actions) => {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  actions.resetForm();
};

const Form_1 = ({activityType, activityName}) => {
  const [selectedType, setSelectedType] = useState("");
  const [selectedActivity, setSelectedActivity] = useState("");
  const [responsabilitésScientifiques, setResponsabilitésScientifiques] = useState([]);
  
    const fetchData = ()=>{
        fetch(`http://localhost:3000/data/${activityType}/${activityName}.json`)
        .then(res => res.json())
        .then(data => setResponsabilitésScientifiques(data))
        .catch(e => console.log(e.message));
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
          <CustomInput
            label={`${info}: `}
            type="text"
            id={`info-${index}`}
            name={`info-${index}:`}
          />
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
            <Grid item xs={12} sm={6}>
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
            <>{inputFields}</>
          </Grid>
        </Form>
      )}
    </Formik>
  );
};

export default Form_1;
