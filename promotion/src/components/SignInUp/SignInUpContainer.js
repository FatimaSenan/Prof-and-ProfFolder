
import PersonIcon from "@mui/icons-material/Person";
import LockIcon from '@mui/icons-material/Lock';
import MailIcon from '@mui/icons-material/Mail';
import BadgeIcon from '@mui/icons-material/Badge';
import { useState } from "react";
import "./signInUpContainer.css";

export default function SignInUpContainer(){
    const [isSignUp, setIsSignUp] = useState(false);
    const handleClick = ()=>{
        setIsSignUp(!isSignUp);
    }
    return(
        <form className="sign-in-up-container">
                <div className="header">
                    <div className="text">
                        {isSignUp ? "Sign Up": "Sign In"}
                    </div>
                    <div className="underline"></div>
                </div>
                <div className="inputs">
                    <div className="input">
                        <PersonIcon className='input-icon'/>
                        <input type="text" placeholder="Email" required/>
                    </div>
                    {isSignUp ? (
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
                    ): null}
                    <div className="input">
                        <LockIcon className="input-icon"/>
                        <input type="password" placeholder="Password" required/>
                    </div>
                    {isSignUp ? (
                        <div className="input">
                            <LockIcon className="input-icon"/>
                            <input type="password" placeholder="Confirm password" required/>
                        </div>): null}
                </div>
                <div className="accept-forgot">
                    {isSignUp ? 
                        null
                        :
                        (<div className='remember-forgot'>
                            <label><input type="checkbox"/>Remember Me</label>
                            <a href="#">Forgot Password</a>
                        </div>)}
                </div>
                <div className="submit-container">
                    <button type="submit" className="submit">{isSignUp ? "Sign Up": "Log In"}</button>
                </div>
                {isSignUp ? (<div className='login-link'>
                    <p>
                        Already have an account?
                       <a href="#" onClick={handleClick}>Log In</a>
                    </p>
                </div>): (<div className='register-link'>
                    <p>
                        Don't have an account?
                       <a href="#" onClick={handleClick}>Register</a>
                    </p>
                </div>)}
                
             
            
        </form>
    );
}