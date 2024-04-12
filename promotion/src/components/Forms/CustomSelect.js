import { useField } from "formik";

const CustomSelect = ({ label,value,htmlFor, ...props }) => {
  const [field, meta] = useField(props);

  return (
    <>
      <label htmlFor={htmlFor}>{label}</label>
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