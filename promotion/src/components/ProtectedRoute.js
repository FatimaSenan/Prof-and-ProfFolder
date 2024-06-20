import { Navigate } from "react-router-dom"
import UserService from "./Professor/service/UsersService"


const ProtectedRoute = ({children, role}) => {
    if(!UserService.isAuthenticated()) {
        return <Navigate to="/" />;
    }
    if (role === 'ADMIN' && !UserService.isAdmin()) {
        return <Navigate to="/administration" />;
    }
    if (role === 'PROFESSOR' && !UserService.isProf()) {
        return <Navigate to="/acceuil" />;
    }
    if (role === 'COMMISSION' && !UserService.isCommission()) {
        return <Navigate to="/" />;
    }
    return children;
};
export default ProtectedRoute;