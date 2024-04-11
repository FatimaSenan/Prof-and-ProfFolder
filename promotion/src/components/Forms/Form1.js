import { Form, Formik } from "formik";
import { advancedSchema } from "../schemas";
import CustomSelect from "./CustomSelect";
import Grid from "@mui/material/Grid";
import ResponsabilitésScientifique from "../data/ResponsabilitésScientifiques";
import { useState } from "react";
import CustomInput from "./CustomInput";
const onSubmit = async (values, actions) => {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  actions.resetForm();
};

const Form_1 = () => {

  const [selectedType, setSelectedType] = useState("");
  const [selectedActivity, setSelectedActivity] = useState("");

  const handleTypeChange = (event) => {
      setSelectedType(event.target.value);
      setSelectedActivity(""); // Reset selected activity when type changes
  }

  const handleActivityChange = (event) => {
      setSelectedActivity(event.target.value);
  }

  const typeActivity = ResponsabilitésScientifique.map((item, id) => (
      <option value={item.type} key={id}>{item.type}</option>
  ));

  const selectedTypeObject = ResponsabilitésScientifique.find(item => item.type === selectedType);
  const activitiesOptions = selectedTypeObject ? selectedTypeObject.activités.map((activity, index) => (
      <option value={activity.activité} key={index}>{activity.activité}</option>
  )) : null;

  const selectedActivityObject = selectedTypeObject ? selectedTypeObject.activités.find(activity => activity.activité === selectedActivity) : null;
  const inputFields = selectedActivityObject ? selectedActivityObject.informations.map((info, index) => (
      <div key={index}>
        <CustomInput 
        label={`${info}: `}
        type="text"
        id={`info-${index}`}
        name={`info-${index}:`}
        />
      </div>
  )) : null;

  return (
    <Formik
      initialValues={{ activityType: "", activityName: "", acceptedTos: false }}
      validationSchema={advancedSchema}
      onSubmit={onSubmit}
    >
      {({ isSubmitting }) => (
        <Form>
          <Grid container spacing={4}>
              <Grid item xs={12} sm={6}>
                <CustomSelect
                  label="Type Activité: "
                  name="activityType"
                  placeholder="Sélectionnez un type"
                  value= {selectedType}
                  onChange={handleTypeChange}
                >
                  <option value="">Sélectionnez un type</option>
                  {typeActivity}
                </CustomSelect>
              </Grid>
              <Grid item xs={12} sm={6}>
                <CustomSelect
                  label="Activity Name"
                  name="activityName"
                  placeholder="Sélectionnez une activité"
                  value={selectedActivity} 
                  onChange={handleActivityChange}
                >
                  <option value="">Sélectionnez une activité</option>
                  {activitiesOptions}
                </CustomSelect>
              </Grid>
              <Grid>
                {inputFields}
              </Grid>
           </Grid>

        </Form>
      )}
    </Formik>
  );
};
export default Form_1;