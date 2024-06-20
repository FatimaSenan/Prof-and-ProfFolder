import React, { useState, useEffect } from 'react';
import axios from 'axios'; 

import ProfileImageSection from './ProfileImageSection';
import PersonalData from './PersonalData';
import './profileContainer.css';

const ProfileContainer = () => {
    const [professorInfo, setProfessorInfo] = useState({
        firstname: '',
        lastname: '',
        email: '',
        birthdate: '',
        cadre: 'cadre',
        grade: ''
    });

    useEffect(() => {
        const fetchProfessorInfo = async () => {
            try {
                const token = localStorage.getItem('token');
                const response = await axios.get('http://localhost:9005/professor/profile', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                const data = response.data;
                setProfessorInfo({
                    firstname: data.firstname,
                    lastname: data.lastname,
                    email: data.email,
                    birthdate: data.birthDate,
                    grade: data.grade,
                    
                });
            } catch (error) {
                console.error('Erreur lors de la récupération des informations du professeur:', error);
                
            }
        };
        
        fetchProfessorInfo(); 
        }, []);

    return (
        <div className="profile-container">
            <ProfileImageSection />
            <PersonalData typeData="Nom et Prénom" profData={`${professorInfo.firstname} ${professorInfo.lastname}`} />
            <PersonalData typeData="Adresse e-mail" profData={professorInfo.email} />
            <PersonalData typeData="Date de naissance" profData={professorInfo.birthdate} />
            <PersonalData typeData="Grade" profData={professorInfo.grade} />
            <PersonalData typeData="Cadre" profData={professorInfo.cadre} />
        </div>
    );
};

export default ProfileContainer;
