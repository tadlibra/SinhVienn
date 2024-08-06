import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySinhVien {
    private ArrayList<SinhVien> danhSachSV = new ArrayList<>();
    private final String fileName = "sinhvien.dat";

    public void themSinhVien(SinhVien sv) {
        danhSachSV.add(sv);
    }

    public void xoaSinhVien(String maSV) {
        for (int i = 0; i < danhSachSV.size(); i++) {
            if (danhSachSV.get(i).getMaSV().equals(maSV)) {
                danhSachSV.remove(i);
                break;
            }
        }
    }

    public void hienThiDanhSachSinhVien() {
        for (SinhVien sv : danhSachSV) {
            System.out.println(sv);
        }
    }

    public void luuDuLieu() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(danhSachSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void docDuLieu() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            danhSachSV = (ArrayList<SinhVien>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Chưa có dữ liệu nào được lưu.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();
        qlsv.docDuLieu();
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("-----QUAN LY SINH VIEN-----");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Hien thi danh sach sinh vien");
            System.out.println("4. Luu du lieu");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma sinh vien: ");
                    String maSV = scanner.nextLine();
                    System.out.print("Nhap ten sinh vien: ");
                    String tenSV = scanner.nextLine();
                    System.out.print("Nhap tuoi sinh vien: ");
                    int tuoi = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng mới
                    SinhVien sv = new SinhVien(maSV, tenSV, tuoi);
                    qlsv.themSinhVien(sv);
                    break;
                case 2:
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    String maSVXoa = scanner.nextLine();
                    qlsv.xoaSinhVien(maSVXoa);
                    break;
                case 3:
                    qlsv.hienThiDanhSachSinhVien();
                    break;
                case 4:
                    qlsv.luuDuLieu();
                    System.out.println("Du lieu da duoc luu.");
                    break;
                case 0:
                    qlsv.luuDuLieu();
                    System.out.println("Thoat chuong trinh va luu du lieu.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}