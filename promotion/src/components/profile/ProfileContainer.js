import ProfileImageSection from "./ProfileImageSection";
import PersonalData from "./PersonalData";
import './profileContainer.css';
export default function ProfileContainer(){

    return(
        <div className="profile-container">
           
           <ProfileImageSection/>
           <PersonalData typeData="Nom" profData="lastname"/>
           <PersonalData typeData="Prénom" profData="firstname"/>
           <PersonalData typeData="Email" profData="email"/>
           <PersonalData typeData="Cadre" profData=""/>
           <PersonalData typeData="Grade" profData="gradeProf"/>
        </div>
    );
}