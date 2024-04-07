import ProfileImageSection from "./ProfileImageSection";
import PersonalData from "./PersonalData";
import './profileContainer.css';
export default function ProfileContainer(){

    return(
        <div className="profile-container">
           
           <ProfileImageSection/>
           <PersonalData typeData="Nom et Prénom" profData="NomProf Prénom Prof"/>
           <PersonalData typeData="Adresse e-mail" profData="adressProf@ump.ac.ma"/>
           <PersonalData typeData="Date de naissance" profData="JJ/MM/AAAA"/>
           <PersonalData typeData="Cadre" profData=""/>
           <PersonalData typeData="Grade" profData="gradeProf"/>
        </div>
    );
}