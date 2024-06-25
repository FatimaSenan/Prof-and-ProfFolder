import { useState } from "react";
import { useNavigate } from "react-router-dom";
import UserService from "../Professor/service/UsersService";
import "./signInUpContainer.css";
import PersonIcon from "@mui/icons-material/Person";
import LockIcon from '@mui/icons-material/Lock';
export default function LoginPage(){
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')
    const navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault();
    
        try {
            const userData = await UserService.login(email, password)
            console.log(userData)
            if (userData.token) {
                localStorage.setItem('token', userData.token);
                localStorage.setItem('role', userData.role);
                window.dispatchEvent(new Event('storage')); 
                if (userData.role === 'PROFESSOR') {
                    navigate('/acceuil');
                } else if (userData.role === 'COMMISSION') {
                    navigate('/professors_table'); 
                } else if (userData.role === 'ADMIN') {
                    navigate('/administration'); // Adapt as needed
                } else {
                    setError("Rôle non reconnu"); // Handle unrecognized roles
                }
            }else{
                setError(userData.message)
            }
        } catch (error) {
            console.log(error)
            setError(error.message)
            setTimeout(()=>{
                setError('');
            }, 5000);
        }
    }
            
    const handleRegisterClick = (e) => {
        e.preventDefault();
        navigate('/register');
    }
    return(
        <form className="sign-in-up-container" onSubmit={handleSubmit}>
                <div className="header">
                    <div className="text">
                        Se Connecter
                    </div>
                    <div className="underline"></div>
                        {error && <p style={{color: 'red'}} className="error-message">{error}</p>}
                </div>
                <div className="inputs">
                    <div className="input">
                        <PersonIcon className='input-icon'/>
                        <input type="email"  name="email" value={email} placeholder="Email" onChange={(e) => setEmail(e.target.value)} required/>
                    </div>
                    <div className="input">
                        <LockIcon className="input-icon"/>
                        <input type="password" name="password" value={password} placeholder="Mot de Passe" onChange={(e) => setPassword(e.target.value)} required/>
                    </div>
                    <div className="submit-container">
                    <button type="submit" className="submit" >Se Connecter</button>
                    
                </div>
                <div className='register-link'>
                    <p>
                    Vous n'avez pas de compte ?
                       <a href="#" onClick={handleRegisterClick}>S'inscrire</a>
                    </p>
                </div>
            </div>
        </form>
    );
            
}