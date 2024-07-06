
import poly.edu.Model.NhanVien;
import poly.edu.service.NhanVienService;
import java.util.ArrayList;
import org.junit.Test;
import poly.edu.Panels.NhanVienForm;
import org.junit.*;

public class NhanVienServiceTest {

   NhanVienService service = new NhanVienService();
   NhanVienForm f = new NhanVienForm();

    //Chức năng thêm nhân viên
        @Test
    public void testAddEm() {
        long expected, actual;
        NhanVien nv = new NhanVien(0, 2, "123456789", "John Doe", 25, "john@example.com",
                "1234567890", "Address", "password", "NV001", "2024-04-06");
        Integer row = service.AddEm(nv);
                String vaitro = "Nhân viên";
        Integer row2 = service.AddVT(vaitro);
        expected = 9;
        actual = service.getAllEm().size();
        Assert.assertNotNull(row);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddVT() { 
        long expected, actual;
NhanVien model = f.model();
        Integer row = service.AddEm(model);
                String vaitro = "Nhân viên";
        Integer row2 = service.AddVT(vaitro);
        expected = 9;
        actual = service.getAllEm().size();
        Assert.assertNotNull(row);
        Assert.assertEquals(expected, actual);
    }

    }
    //Chức năng sửa nhân viên
    
    @Test
    public void testUpdateEm() {
        NhanVien nv = new NhanVien(1, 1, "123456789", "John Doe", 25, "john@example.com",
                "1234567890", "Address", "password", "NV001", "2024-04-06");
        Integer row = service.UpdateEm(nv, 1);
        Assertions.assertNotNull(row);
        Assertions.assertEquals(1, row);
    }

    @Test
    public void testUpdateVT() {
        int ID = 1;
        String vt = "Updated Role";
        Integer row = service.UpdateVT(ID, vt);
        Assertions.assertNotNull(row);
        Assertions.assertEquals(1, row);
    }

    //Xóa
        @Test
    public void testDeleteEm() {
        int maNV = 1;
        Integer row = service.DeleteEm(maNV);
        Assertions.assertNotNull(row);
        Assertions.assertEquals(1, row);
    }

    @Test
    public void testDeleteVT() {
        int maID = 1;
        Integer row = service.DeleteVT(maID);
        Assertions.assertNotNull(row);
        Assertions.assertEquals(1, row);
    }
    //Các chức năng khác
    @Test
    public void testGetAllEm() {
        ArrayList<NhanVien> lst = service.getAllEm();
        Assertions.assertNotNull(lst);
        Assertions.assertFalse(lst.isEmpty());
    }

    @Test
    public void testGetAllEmTheoMa() {
        String maNV = "NV001";
        ArrayList<NhanVien> lst = service.getAllEmTheoMa(maNV);
        Assertions.assertNotNull(lst);
        Assertions.assertFalse(lst.isEmpty());
    }

    @Test
    public void testSearchEm() {
        String ten = "John";
        String mail = "john@example.com";
        String nvien = "NV001";
        ArrayList<NhanVien> lst = service.searchEm(ten, mail, nvien);
        Assertions.assertNotNull(lst);
        Assertions.assertFalse(lst.isEmpty());
    }




}