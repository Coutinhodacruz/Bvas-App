package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Admin;
import africa.semicolon.bvasbetaa.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAdminRepositoryTest {

    private final AdminRepository adminRepository = new BvasAdminRepository();

    private Admin savedAdmin;

    @BeforeEach
    public void setUp(){
        Admin admin = buildTestAdmin();
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername("Coutinho_dacruz@gmail.com");
        userInformation.setPassword("Legend_my_guy123");
        admin.setUserInformation(userInformation);
        savedAdmin = adminRepository.save(admin);
    }

    @DisplayName("Save Admin")
    @Test
    public void testSaveAdmin(){
        assertNotNull(savedAdmin);
        assertNotNull(savedAdmin.getId());
    }

    @DisplayName("Find Admin Id")
    @Test
    public void testFindById(){
        Admin foundAdmin = adminRepository.findById(savedAdmin.getId());
        assertNotNull(foundAdmin);
        assertNotNull(foundAdmin.getUserInformation());

    }

    @DisplayName("Find All Admin")
    @Test
    public void findAllAdminTest(){
        Admin secondAdmin = new Admin();
        Admin thirdAdmin = new Admin();
        adminRepository.save(secondAdmin);
        adminRepository.save(thirdAdmin);

        List<Admin> admins = adminRepository.findAll();
        assertEquals(3, admins.size());
        assertNotNull(admins.get(0));
        assertNotNull(admins.get(1));
        assertNotNull(admins.get(2));
    }

    @DisplayName("Delete Voter By Id")
    @Test
    public void testDeleteVoterById(){
        Admin secondAdmin = new Admin();
        Admin secondSavedAdmin = adminRepository.save(secondAdmin);
        List<Admin> admins = adminRepository.findAll();
        assertEquals(2, admins.size());
        adminRepository.deleteById(secondSavedAdmin.getId());
        admins = adminRepository.findAll();
        assertEquals(1, admins.size());

    }



    private Admin buildTestAdmin(){
        Admin admin = new Admin();
        admin.setId("1");
        return admin;
    }

}