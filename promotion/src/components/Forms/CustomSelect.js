import { useField } from "formik";

const CustomSelect = ({ label,value, ...props }) => {
  const [field, meta] = useField(props);
  

  return (
    <>
      <label>{label}</label>
      <select
        value={value}
        {...field}
        {...props}
        className={meta.touched && meta.error ? "input-error" : ""}
      />
      {meta.touched && meta.error && <div className="error">{meta.error}</div>}
    </>
  );
};
export default CustomSelect;