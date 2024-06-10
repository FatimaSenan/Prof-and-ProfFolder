import { Button, Divider } from "@mui/material";
import './personalData.css';
import { useState , useEffect} from "react";
import UserService from "../Professor/service/UsersService";

export default function PersonalData({typeData, profData}){
    const [profileData, setProfileData] = useState({});

    useEffect(() => {
        fetchProfileInfo();
    }, []);

    const fetchProfileInfo = async () => {
        try {

            const token = localStorage.getItem('token'); // Retrieve the token from localStorage
            const response = await UserService.getYourProfile(token);
            setProfileData(response.user);
        } catch (error) {
            console.error('Error fetching profile information:', error);
        }
    };
    return (
        
        <div className="personal-data">
            <Divider color="#D9ABA0"/>
            <div className="row-1">
                <div><strong>{typeData}</strong></div>
            </div>
            <div className="row-2">
                <div>{}</div>
                <Button variant="contained" style={{ backgroundColor: "#A66253" , color: "#F2F2F2"}}>Modifier</Button>
            </div>
        </div>
    )
}