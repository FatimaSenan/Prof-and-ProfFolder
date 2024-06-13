import * as React from 'react';
import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import { IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import './uploadFileButton.css'
/*const VisuallyHiddenInput = styled('input')({
  clip: 'rect(0 0 0 0)',
  clipPath: 'inset(50%)',
  height: 1,
  overflow: 'hidden',
  position: 'absolute',
  bottom: 0,
  left: 0,
  whiteSpace: 'nowrap',
  width: 1,
});*/

export default function UploadFileButton(props) {

  const { accept, onSelectFile, onDeleteFile, disabled, fileName} = props;
  const hiddenFileInput = React.useRef(null);
  //const [file, setFile] = React.useState(null);

  const handleClick = (event) => {
    hiddenFileInput.current.click();
  };

  const handleChange = (event) => {
   // setFile(event.target.files[0]);
   onSelectFile(event)
  };

  const onDeleteFileHandler = () => {
  //  setFile(null);
    hiddenFileInput.current.value = null;
    onDeleteFile();
  };
  return (
    <div className='file-uploader'>
      <div className={`file-div ${disabled && "disabled"}`}>
        

        <Button
        className='cloudupload-icon'
        onClick={handleClick}
        disabled = {disabled}
        >
          <CloudUploadIcon style={{color: "#A66253"}}/>
          <input
            type="file"
            id="actual-btn"
            accept={accept}
            ref={hiddenFileInput}
            onChange={handleChange}
            hidden
            disabled={disabled}
            data-testid="file-upload-input"
          />
          <div className="file-name">
            {fileName ? <div>{fileName}</div> : <div>Choose file</div>}
          </div>
        </Button>
      </div>
      <div className={`${disabled && "disabled"}`}>
        <IconButton
          aria-label="delete"
          disabled={disabled}
          color="primary"
          onClick={onDeleteFileHandler}
        >
          <DeleteIcon style={{color: "#404040", opacity: "0.8"}}/>
        </IconButton>
      </div>
    </div>
   
  );
}