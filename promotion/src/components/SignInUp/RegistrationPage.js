import { useNavigate } from "react-router-dom";
import { useState } from "react";
import "./signInUpContainer.css";
import UserService from "../Professor/service/UsersService";
import PersonIcon from "@mui/icons-material/Person";
import LockIcon from '@mui/icons-material/Lock';
import MailIcon from '@mui/icons-material/Mail';
import {  Button } from "@mui/material";
import Alert from '@mui/material/Alert';

const allowedEmails = ["m.saber@ump.ac.ma", "t.bouchentouf@ump.ac.ma", "jberrich@gmail.com", "i.elfarissi@ump.ac.ma", "a.administration@ump.ac.ma", "c.commission@ump.ac.ma"]
export default function RegistrationPage() {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        firstname: '',
        lastname: '',
        email: '',
        password: '',
        role: ''
    });
    const [alert, setAlert] = useState({ show: false,severity:"", message: '' });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };
    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!allowedEmails.includes(formData.email)) {
            setAlert({
                show: true,
                severity: "error",
                message: "Votre email n'est pas autorisé pour l'inscription."
            });
            return;
        }
        try {
            // Call the register method from UserService

            const token = localStorage.getItem('token');
            console.log(formData);
            await UserService.register(formData, token);

            // Clear the form fields after successful registration
            setFormData({
                firstname: '',
                lastname: '',
                email: '',
                password: '',
                role: ''
            });
           
           setAlert({
            show: true,
            severity: "success",
            message: 'Le compte a été créé avec succès!'
        });
           
        } catch (error) {
            console.error('Error registering user:', error);
            setAlert({
                show: true,
                severity: "error",
                message: 'Une erreure s\'est produite . Veuillez réessayer plus tard/'
            })
        }
    };
    const handleLoginClick = (e) => {
        e.preventDefault();
        navigate('/login');
    }

    return(
        <>
        {alert.show? (
            <Alert
            severity={alert.severity}
                action={
                    <Button color="inherit" size="small" onClick={() => navigate('/login')}>
                        {alert.severity === "success" ? "Continuer": "Annuler"}
                    </Button>
                }
            >
                {alert.message}
            </Alert>
        ):(
        <form className="sign-in-up-container" onSubmit={handleSubmit}>
            <div className="header">
                    <div className="text">
                        S'inscrire
                    </div>
                    <div className="underline"></div>
            </div>
                    <div className="inputs">
                        <div className="input">
                            <PersonIcon className='input-icon'/>
                            <input type="text"  name="firstname" value={formData.firstname} placeholder="Prénom" onChange={handleInputChange} required/>
                        </div>
                        
                        <div className="input">
                            <PersonIcon className='input-icon'/>
                            <input type="text"  name="lastname" value={formData.lastname} placeholder="Nom" onChange={handleInputChange} required/>
                        </div>
                    <div className="inputs">
                        <div className="input">
                            <MailIcon className='input-icon'/>
                            <input type="email"  name="email" value={formData.email} placeholder="Email" onChange={handleInputChange} required/>
                        </div>
                        
                        <select className="input" name="role" value={formData.role} onChange={handleInputChange}>
                            <option value="">Selectionnez un role</option>
                            <option value="PROFESSOR">Professeur</option>
                            <option value="COMMISSION">Commission</option>
                            <option value="ADMIN">Administration</option>
                        </select>
                    
                    <div className="input">
                        <LockIcon className="input-icon"/>
                        <input type="password" name="password" value={formData.password} placeholder="Mot de Passe" onChange={handleInputChange} required/>
                    </div>
                    </div>
                
                <div className="submit-container">
                    <button type="submit" className="submit" >S'inscrire</button>
                </div>
               <div className='login-link'>
                    <p>
                       Vous avez déjà un compte?
                       <a href="#" onClick={handleLoginClick}>Se Connecter</a>
                    </p>
                </div>
                
                    
            </div>
          
        </form>
       )}
        </>
    );
}