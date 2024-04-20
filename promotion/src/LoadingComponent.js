import { CircularProgress , Box} from "@mui/material";
export default function LoadingComponent () {
    return (
      <div style={{ display: 'flex' , justifyContent: 'center',alignItems: 'center',width: '100vw', height: '100vh'}}>
        <CircularProgress sx={{ color: "#A66253" }}/>
      </div>
    );
}