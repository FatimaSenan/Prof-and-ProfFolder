package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Service.UserManagementService;
import com.pfa.PFABackend.dto.ProfessorDTO;
import com.pfa.PFABackend.dto.ReqRes;
import com.pfa.PFABackend.dto.UserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/auth/register")
    public ResponseEntity<ReqRes> register(@RequestBody ReqRes request) {
        return ResponseEntity.ok(userManagementService.register(request));
    }
    @PostMapping("/auth/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes request) {
        return ResponseEntity.ok(userManagementService.login(request));
    }
    @PostMapping("/auth/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes request) {
        return ResponseEntity.ok(userManagementService.refreshToken(request));
    }

    @GetMapping("/admin/get-all-users")
    public ResponseEntity<ReqRes> getAllUsers() {
        return ResponseEntity.ok(userManagementService.getAllUsers());
    }
    @GetMapping("/admin/get-user/{userId}")
    public ResponseEntity<ReqRes> getUserByIdr(@PathVariable Integer userId) {
        return ResponseEntity.ok(userManagementService.getUsersById(userId));
    }
    @GetMapping("/professor/profile")
    public ResponseEntity<UserProfileDTO> getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserProfileDTO userProfileDTO = userManagementService.getProfile(email);
        return ResponseEntity.ok(userProfileDTO);
    }

    @PostMapping("/professor/uploadImage")
    public ResponseEntity<String> uploadProfileImage(@RequestParam("file") MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        userManagementService.saveProfileImage(file, email);
        return ResponseEntity.ok("Image upload successful");
    }

    @DeleteMapping("/professor/deleteImage")
    public ResponseEntity<String> deleteProfileImage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        userManagementService.deleteProfileImage(email);
        return ResponseEntity.ok("Image delete successful");
    }

    @GetMapping(value = "/professor/profileImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getProfileImage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        byte[] image = userManagementService.getProfileImage(email);

        if (image == null) {
            try {
                InputStream defaultImageStream = getClass().getResourceAsStream("/static/default-profile.jpg");
                image = defaultImageStream.readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @GetMapping("/admincommission/get-professors")
    public ResponseEntity<List<ProfessorDTO>> getAllProfessors() {
        ResponseEntity<List<ProfessorDTO>> response = userManagementService.getAllProfessors();
        return response;
    }


    @GetMapping("professor/template/download")
    public ResponseEntity<Resource> downloadTemplate() {
        Resource resource = new ClassPathResource("templates/template.xlsx");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"template.xlsx\"")
                .body(resource);
    }
}
