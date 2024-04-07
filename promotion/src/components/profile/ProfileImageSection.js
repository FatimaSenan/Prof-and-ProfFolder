import { Avatar, Button } from "@mui/material";
import './profilImageSection.css';
export default function ProfileImageSection(){

    return(
        <div className="profil-image-section">
            <Avatar  sx={{ width: 90, height: 90 }} src="/broken-image.jpg"/>
            <div className="delete-modify-btns">
                <Button className="delete-btn" style={{ color: "#A66253" }}>Supprimer la photo</Button>
                <Button className="modify-btn" variant="contained" style={{ backgroundColor: "#A66253" , color: "#F2F2F2"}}>Modifier la photo</Button>
            </div>
        </div>
    )
}