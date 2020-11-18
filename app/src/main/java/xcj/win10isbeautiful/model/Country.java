package xcj.win10isbeautiful.model;

public class Country {
    private String code;
    private String en;
    private String cn;

    public Country(String code, String en, String cn) {
        this.code = code;
        this.en = en;
        this.cn = cn;
    }

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", en='" + en + '\'' +
                ", cn='" + cn + '\'' +
                '}';
    }
}
