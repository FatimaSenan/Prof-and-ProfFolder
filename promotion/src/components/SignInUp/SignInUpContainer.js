
import PersonIcon from "@mui/icons-material/Person";
import LockIcon from '@mui/icons-material/Lock';
import MailIcon from '@mui/icons-material/Mail';
import BadgeIcon from '@mui/icons-material/Badge';
import { useState } from "react";
import {useNavigate} from "react-router-dom";
import "./signInUpContainer.css";
import UserService from "../Professor/service/UsersService";
export default function SignInUpContainer(){
    const [isSignUp, setIsSignUp] = useState(false);
    const [error, setError] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] =useState('');
    //const [role, setRole] = useState('');
    const [formData, setFormData] = useState({
        email: '',
        password: '',
        role: ''
    });
    const navigate = useNavigate();
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        if(name){
            setFormData({ ...formData, [name]: value });
        }
    };


    const handleSubmit = async(e) => {
        e.preventDefault();

        try {
            if(isSignUp === false){
            const userData = await UserService.login(email, password);
            console.log(userData);
            if (userData.token) {
                localStorage.setItem('token', userData.token);
                localStorage.setItem('role', userData.role);
                navigate('/acceuil');
            }else{
                setError(userData.message)
            }
        }else{
            
             // Call the register method from UserService

            // const token = localStorage.getItem('token');

             
            // console.log(token);
             console.log(formData);
             await UserService.register(formData);
 
             // Clear the form fields after successful registration
             setFormData({
                 email: '',
                 password: '',
                 role: ''
             });
             alert('User registered successfully');
             navigate('/admin/user-management');
 
 
        }
        }catch (error) {
           if(isSignUp === false){ console.log(error);
            setError(error.message);
            setTimeout(()=>{
                setError('');
            }, 5000);}else {
                console.error('Error registering user:', error);
                alert('An error occurred while registering user');
            }
        }
    }
    
    const handleClick = ()=>{
        setIsSignUp(!isSignUp);
    }
    return(
        <form className="sign-in-up-container" onSubmit={handleSubmit}>
                <div className="header">
                    <div className="text">
                        {isSignUp ? "S'inscrire": "Se Connecter"}
                    </div>
                    <div className="underline"></div>
                    {error && <p className="error-message">{error}</p>}
                </div>
                <div className="inputs">
                    <div className="input">
                        <PersonIcon className='input-icon'/>
                        <input type="email"  name="email" value={isSignUp ? formData.email: email} placeholder="Email" onChange={isSignUp ? handleInputChange : (e) => setEmail(e.target.value)} required/>
                    </div>
                    {/*{isSignUp ? (
                    <div className="input">
                        <MailIcon className='input-icon'/>
                        <input type="text" placeholder="DRPP" required/>
                    </div>
                    ): null}
                    {isSignUp ? (
                    <div className="input">
                        <BadgeIcon className='input-icon'/>
                        <input type="text" placeholder="CIN" required/>
                    </div>
                    ): null}*/}
                    {isSignUp ? (
                        <select className="input" name="role" value={formData.role} onChange={handleInputChange}>
                            <option value="PROFESSOR">Professeur</option>
                            <option value="COMMISSION">Commission</option>
                            <option value="ADMIN">Administration</option>
                        </select>
                    ) : null}
                    <div className="input">
                        <LockIcon className="input-icon"/>
                        <input type="password" name="password" value={isSignUp ? formData.password: password} placeholder="Mot de Passe" onChange={isSignUp ? handleInputChange : (e) => setPassword(e.target.value)} required/>
                    </div>
                    {/*{isSignUp ? (
                        <div className="input">
                            <LockIcon className="input-icon"/>
                            <input type="password" placeholder="Confirmer Mot de passe" required/>
                    </div>): null}*/}
                </div>
                <div className="accept-forgot">
                    {isSignUp ? 
                        null
                        :
                        (<div className='remember-forgot'>
                            <label><input type="checkbox"/>Se souvenir de moi</label>
                            <a href="#">Mot de passe oublié</a>
                        </div>)}
                </div>
                <div className="submit-container">
                    <button type="submit" className="submit" >{isSignUp ? "S'inscrire": "Se Connecter"}</button>
                </div>
                {isSignUp ? (<div className='login-link'>
                    <p>
                       Vous avez déjà un compte?
                       <a href="#" onClick={handleClick}>Se Connecter</a>
                    </p>
                </div>): (<div className='register-link'>
                    <p>
                    Vous n'avez pas de compte ?
                       <a href="#" onClick={handleClick}>S'inscrire</a>
                    </p>
                </div>)}
                
             
            
        </form>
    );
}