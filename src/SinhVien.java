import java.io.Serializable;

public class SinhVien implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maSV;
    private String tenSV;
    private int tuoi;

    public SinhVien(String maSV, String tenSV, int tuoi) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.tuoi = tuoi;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public int getTuoi() {
        return tuoi;
    }

    @Override
    public String toString() {
        return "SinhVien :" + "\n" + "  Ma SV:    " + maSV + "\n" + "  Ten SV:   " + tenSV + "\n" + "  Tuoi:     " + tuoi + "\n" ;
    }
}
