import { Navigate } from "react-router-dom"
import UserService from "./Professor/service/UsersService"


const ProtectedRoute = ({children}) => {
    if(!UserService.isAuthenticated()) {
        return <Navigate to="/" />;
    }
    return children;
};
export default ProtectedRoute;