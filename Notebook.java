
public class Notebook {
    private String name;
    private Integer ram;
    private Integer sd;
    private String os;
    private String color;

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getRam(){
        return ram;
    }

    public void setSd(Integer sd) {
        this.sd = sd;
    }

    public Integer getSd(){
        return sd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs(){
        return os;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public Notebook(String name, Integer ram, Integer sd, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.sd = sd;
        this.os = os;
        this.color = color;
    }
    @Override
    public String toString() {
        return name + "; " + "ОЗУ:" + ram +  "; " + "Память: " + sd + "; " + "Операционная система: " + os + "; " + "Цвет:" + color + "; ";
    }
}
