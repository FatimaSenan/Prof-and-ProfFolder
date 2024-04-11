import { Form, Formik } from "formik";
import { advancedSchema } from "../schemas";
import CustomSelect from "./CustomSelect";
import Grid from "@mui/material/Grid";

const onSubmit = async (values, actions) => {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  actions.resetForm();
};

const Form_1 = () => {
  return (
    <Formik
      initialValues={{ username: "", jobType: "", acceptedTos: false }}
      validationSchema={advancedSchema}
      onSubmit={onSubmit}
    >
      {({ isSubmitting }) => (
        <Form>
          <Grid container spacing={4}>
              <Grid item xs={12} sm={6}>
                <CustomSelect
                  label="Type Activity"
                  name="Type"
                  placeholder="Please select an option"
                >
                  <option value="">Please select an option</option>
                  <option value="developer">A</option>
                  <option value="designer">B</option>
                  <option value="manager">C</option>
                  <option value="other">D</option>
                </CustomSelect>
              </Grid>
              <Grid item xs={12} sm={6}>
                <CustomSelect
                  label="Activity Name"
                  name="jobType"
                  placeholder="Please select a job"
                >
                  <option value="">Please select an option</option>
                  <option value="developer">A</option>
                  <option value="designer">B</option>
                  <option value="manager">C</option>
                  <option value="other">D</option>
                </CustomSelect>
              </Grid>
           </Grid>

        </Form>
      )}
    </Formik>
  );
};
export default Form_1;
