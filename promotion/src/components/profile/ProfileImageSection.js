import { Avatar, Button } from "@mui/material";
import './profilImageSection.css';
import { useState , useEffect} from "react";
import axios from "axios";
export default function ProfileImageSection() {
    const [imageUrl, setImageUrl] = useState('/default-profile.jpg');
    const [selectedFile, setSelectedFile] = useState(null);
    const [previewUrl, setPreviewUrl] = useState(null);

    useEffect(() => {
        const fetchImage = async () => {
            const token = localStorage.getItem('token');
            try {
                const response = await axios.get('http://localhost:8080/professor/profileImage', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    },
                    responseType: 'arraybuffer'
                });

                const base64 = btoa(
                    new Uint8Array(response.data).reduce(
                        (data, byte) => data + String.fromCharCode(byte),
                        ''
                    )
                );
                setImageUrl(`data:image/jpeg;base64,${base64}`);
            } catch (error) {
                console.error('Erreur lors de la récupération de l\'image:', error);
            }
        };

        fetchImage();
    }, []);

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        setSelectedFile(file);
        const previewUrl = URL.createObjectURL(file);
        setPreviewUrl(previewUrl);
    };

    const handleUpload = async () => {
        const formData = new FormData();
        formData.append('file', selectedFile);
        const token = localStorage.getItem('token');

        try {
            const response = await axios.post('http://localhost:9005/professor/uploadImage', formData, {
                headers: {
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'multipart/form-data'
                }
            });
            console.log('Réponse du serveur:', response.data);
            setImageUrl(previewUrl); // Set the uploaded image as the current image
            setSelectedFile(null); // Reset the selected file
            setPreviewUrl(null); // Reset the preview URL
        } catch (error) {
            console.error('Erreur lors de l\'upload de l\'image:', error);
        }
    };

    const handleDelete = async () => {
        const token = localStorage.getItem('token');

        try {
            const response = await axios.delete('http://localhost:9005/professor/deleteImage', {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            console.log('Réponse du serveur:', response.data);
            setImageUrl('/default-profile.jpg'); // Reset the image to default
            setSelectedFile(null); // Reset the selected file
            setPreviewUrl(null); // Reset the preview URL
        } catch (error) {
            console.error('Erreur lors de la suppression de l\'image:', error);
        }
    };

    return (
        <div className="profil-image-section">
            <Avatar sx={{ width: 90, height: 90 }} src={previewUrl || imageUrl} />
            <div className="delete-modify-btns">
                <Button className="delete-btn" style={{ color: "#A66253" }} onClick={handleDelete}>
                    Supprimer la photo
                </Button>
                <Button className="modify-btn" variant="contained" component="label" style={{ backgroundColor: "#A66253", color: "#F2F2F2" }}>
                    Modifier la photo
                    <input type="file" hidden onChange={handleFileChange} />
                </Button>
                {previewUrl && (
                    <Button variant="contained" onClick={handleUpload} style={{ backgroundColor: "#A66253", color: "#F2F2F2", marginLeft:'2rem' }}>
                        Valider
                    </Button>
                )}
            </div>
        </div>
    );
}
