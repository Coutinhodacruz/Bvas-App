package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Admin;
import africa.semicolon.bvasbetaa.models.UserInformation;
import africa.semicolon.bvasbetaa.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasAdminRepository implements AdminRepository{
    List<Admin> admins = new ArrayList<>();

    @Override
    public Admin findById(String id) {
        for (Admin foundAdmin : admins){
            boolean sameAdmin = Objects.equals(foundAdmin.getId(),id);
            if (sameAdmin) return foundAdmin;
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return admins;
    }

    @Override
    public Admin save(Admin admin) {
        admin.setId(AppUtils.generateId());
        boolean isAdminWithUserInformation = admin.getUserInformation() != null;
        admins.add(admin);

//        String id = AppUtils.generateId();
//        admin.setId(id);
//        admins.add(admin);
        return admin;
//        admins.add(admin);
//        return admin;
    }

    @Override
    public void deleteById(String id) {
        Admin foundAdmin = findById(id);
        if(foundAdmin != null) admins.remove(foundAdmin);

    }
}
