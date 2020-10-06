package jasper;

public class DataBean {
    private static Integer count = 0;
    private Integer number;
    private String work;
    private String material;
    private String mesaure;
    private Integer quantity;
    private Integer costWithNDS;
    private Integer estimatedCost;

    public DataBean() {
        this.setNumber(++count);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMesaure() {
        return mesaure;
    }

    public void setMesaure(String mesaure) {
        this.mesaure = mesaure;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCostWithNDS() {
        return costWithNDS;
    }

    public void setCostWithNDS(Integer costWithNDS) {
        this.costWithNDS = costWithNDS;
    }

    public Integer getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Integer estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}