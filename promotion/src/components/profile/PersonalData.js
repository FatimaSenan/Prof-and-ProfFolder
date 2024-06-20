import { Button, Divider } from "@mui/material";
import './personalData.css';

export default function PersonalData({typeData, profData}){

    return (
        
        <div className="personal-data">
            <Divider color="#D9ABA0"/>
            <div className="row-1">
                <div><strong>{typeData}</strong></div>
            </div>
            <div className="row-2">
                <div>{profData}</div>
            </div>
        </div>
    )
}