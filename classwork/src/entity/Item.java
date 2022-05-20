package entity;

public class Item {
private String icode;
private String iname;
private  String iprice;
private String qty;

    public Item() {
    }

    public Item(String icode, String iname, String iprice, String qty) {
        this.icode = icode;
        this.iname = iname;
        this.iprice = iprice;
        this.qty = qty;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIprice() {
        return iprice;
    }

    public void setIprice(String iprice) {
        this.iprice = iprice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

}
