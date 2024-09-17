package com.supply.supply.admin.service;

import com.supply.supply.admin.model.Admin;
import com.supply.supply.admin.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }


    // Guardar un nuevo Admin
    public Admin saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    // Encontrar un Admin por su id
    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Encontrar un Admin por su username
    public Optional<Admin> findAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    // Eliminar un Admin
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Listar todos los Admins
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    // Actualizar un Admin existente
    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        admin.setUsername(adminDetails.getUsername());
        admin.setPassword(passwordEncoder.encode(adminDetails.getPassword()));
        admin.setRol(adminDetails.getRol());

        return adminRepository.save(admin);
    }




}
