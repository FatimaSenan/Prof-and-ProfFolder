package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.ProfessorFolder;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ChefDépartementRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import com.pfa.PFABackend.dto.ProfessorDTO;
import com.pfa.PFABackend.dto.ReqRes;
import com.pfa.PFABackend.dto.UserProfileDTO;
import io.jsonwebtoken.Jwts;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class UserManagementService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityService activityService;




    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final List<String> allowedEmails = Arrays.asList("m.saber@ump.ac.ma", "t.bouchentouf@ump.ac.ma", "jberrich@gmail.com", "i.elfarissi@ump.ac.ma",  "a.administration@ump.ac.ma", "c.commission@ump.ac.ma");

    public ReqRes register(ReqRes registrationRequest) {
        ReqRes response = new ReqRes();
        if (!allowedEmails.contains(registrationRequest.getEmail())) {
            response.setStatusCode(403);
            response.setMessage("Votre email n'est pas autorisé pour l'inscription.");
            return response;
        }

        try{

            User user = new User();
            user.setFirstname(registrationRequest.getFirstname());
            user.setLastname(registrationRequest.getLastname());
            user.setEmail(registrationRequest.getEmail());
            user.setRole(registrationRequest.getRole());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            User userResult = userRepository.save(user);
            if(userResult.getId()>0) {
                response.setUser(userResult);
                response.setMessage("User saved successflly");
                response.setStatusCode(200);
            }
        }catch(Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public ReqRes login(ReqRes loginRequest) {
        ReqRes response = new ReqRes();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                    loginRequest.getPassword()));
            var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hrs");
            response.setMessage("Successfully logged in");
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        try{
            String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
            User users = userRepository.findByEmail(ourEmail).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getToken());
                response.setExpirationTime("24Hr");
                response.setMessage("Successfully Refreshed Token");
            }
            response.setStatusCode(200);
            return response;

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return response;
        }
    }


    public ReqRes getAllUsers() {
        ReqRes reqRes = new ReqRes();

        try {
            List<User> result = userRepository.findAll();
            if (!result.isEmpty()) {
                reqRes.setUsersList(result);
                reqRes.setStatusCode(200);
                reqRes.setMessage("Successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("No users found");
            }
            return reqRes;
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
            return reqRes;
        }
    }


    public ReqRes getUsersById(Integer id) {
        ReqRes reqRes = new ReqRes();
        try {
            User usersById = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
            reqRes.setUser(usersById);
            reqRes.setStatusCode(200);
            reqRes.setMessage("Users with id '" + id + "' found successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
        }
        return reqRes;
    }


    public ReqRes deleteUser(Integer userId) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                userRepository.deleteById(userId);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User deleted successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for deletion");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return reqRes;
    }

    public ReqRes updateUser(Integer userId, User updatedUser) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();
                existingUser.setEmail(updatedUser.getEmail());


                existingUser.setRole(updatedUser.getRole());

                // Check if password is present in the request
                if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                    // Encode the password and update it
                    existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                }

                User savedUser = userRepository.save(existingUser);
                reqRes.setUser(savedUser);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User updated successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
        }
        return reqRes;
    }


    public ReqRes getMyInfo(String email){
        ReqRes reqRes = new ReqRes();
        try {
            Optional<User> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()) {
                reqRes.setUser(userOptional.get());
                reqRes.setStatusCode(200);
                reqRes.setMessage("successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;

    }

    // Méthode pour sauvegarder l'image de profil
    @Transactional
    public void saveProfileImage(MultipartFile file, String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            try {
                user.setImage(file.getBytes());
                userRepository.save(user);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store profile image: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }

    // Méthode pour supprimer l'image de profil
    @Transactional
    public void deleteProfileImage(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setImage(null);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }

    // Méthode pour récupérer l'image de profil
    public byte[] getProfileImage(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            byte[] image = user.getImage();
            if (image != null) {
                return image;
            }
        }
        // Si l'utilisateur n'a pas d'image, renvoyer une image par défaut
        try {
            InputStream defaultImageStream = new ClassPathResource("static/default-profile.jpg").getInputStream();
            return defaultImageStream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load default profile image", e);
        }
    }
    public UserProfileDTO getProfile(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            userProfileDTO.setFirstname(user.getFirstname());
            userProfileDTO.setLastname(user.getLastname());
            userProfileDTO.setEmail(user.getEmail());

            if (user.getProfessorFolder() != null) {
                userProfileDTO.setBirthDate(user.getProfessorFolder().getBirthDate());
                userProfileDTO.setGrade(user.getProfessorFolder().getGrade());
            }

            return userProfileDTO;
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }

    public ResponseEntity<List<ProfessorDTO>> getAllProfessors() {
        List<User> users = userRepository.findByRole("PROFESSOR");
        List<ProfessorDTO> professors = new ArrayList<>();

        for (User user : users) {
            ProfessorFolder folder = user.getProfessorFolder();
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setFirstname(user.getFirstname());
            professorDTO.setLastname(user.getLastname());
            professorDTO.setEmail(user.getEmail());
            professorDTO.setPhone(folder != null ? folder.getPhone() : null);
            professorDTO.setProfile(folder != null ? folder.getProfile() : null);
            professorDTO.setEstablishment(folder != null ? folder.getEstablishment() : null);
            professorDTO.setEvaluationStatus(activityService.getEvaluationStatus(user.getEmail()));
            // professorDTO.setEvaluationStatus(folder != null && folder.getEvaluationStatus() != null ? folder.getEvaluationStatus() : "Not Evaluated");
            professors.add(professorDTO);
        }

        return ResponseEntity.ok(professors);
    }



}

