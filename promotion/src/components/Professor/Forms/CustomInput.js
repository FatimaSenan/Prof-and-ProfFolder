import { useField } from "formik";

const CustomInput = ({ label, handleOptionChange,...props }) => {
  const [field, meta] = useField(props);

  const handleChange = (event) => {
    field.onChange(event); // Update form values
    if (handleOptionChange) {
      handleOptionChange(event); // Call handleOptionChange if provided
    }
  };

  return (
    <>
      <label>{label}</label>
      <input
        {...field}
        {...props}
        onChange={handleChange}
        className={meta.touched && meta.error ? "input-error" : ""}
      />
      {meta.touched && meta.error && <div className="error">{meta.error}</div>}
    </>
  );
};
export default CustomInput;