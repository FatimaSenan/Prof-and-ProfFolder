import axios from "axios";
const API_BASE_URL = 'http://localhost:9005/professor';
class ActivityService {

static async fetchAllActivities ({token}) {
    try{
    const response = await axios.get(`${API_BASE_URL}/activities/current-user`,
        {
            headers: {Authorization: `Bearer ${token}`}
        }
    );
    return response.data;
    }catch(error){
        throw error;
    }
};

static async fetchActivitiesTypes({token}){
    try{
        const response = await axios.get(`${API_BASE_URL}/activity-types`,
            {
                headers: {Authorization: `Bearer ${token}`}
            }
        );
        return response.data;
    }catch(error){
        throw error;
    }
};

static async fetchActivitiesSubTypes1(){
    try{
        const response = await axios.get(`${API_BASE_URL}/activity_subTypes1`);
        return response.data;
    }catch(error){
        throw error;
    }
};
static async fetchActivitiesSubTypes2(){
    try{
        const response = await axios.get(`${API_BASE_URL}/activity_subTypes2`);
        return response.data;
    }catch(error){
        throw error;
    }
};

}
export default ActivityService;